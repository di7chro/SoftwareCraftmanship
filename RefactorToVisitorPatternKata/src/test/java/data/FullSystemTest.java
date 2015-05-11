package data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FullSystemTest {

    private Session session;
    private static final int size_after_load = 46544 + 344 + 465 + 6645 + 321 + 566;
    private static final int size_after_refreshes = 51345 + 545 + 513 + 6645 + 321 + 566;

    @Before
    public void setup() throws Exception {
        Logging.out = new FakeOut();

        this.session = new Session();
        Partition p1 = new Partition("partition 1");
        p1.addStorage(new TableStorageFake("SQL storage 1"));
        p1.addStorage(new ColumnStorageFake("JSON storage 1"));
        session.addPartition(p1);

        Partition p2 = new Partition("partition 2");
        p2.addStorage(new TableStorageFake("SQL storage 2"));
        session.addPartition(p2);

        Partition p3 = new Partition("partition 3");
        p3.addStorage(new TableStorageFake("SQL storage 3"));
        p3.addStorage(new ColumnStorageFake("JSON storage 2"));
        p3.addStorage(new ColumnStorageFake("JSON storage 3"));
        p2.addPartition(p3);
    }

    @Test
    public void initialCommitIdIsZero() throws Exception {
        assertEquals(0, session.getLatestCommitId());
    }

    @Test
    public void commitIdIs125AfterLoad() throws Exception {
        session.load();
        assertEquals(125, session.getLatestCommitId());
    }

    @Test
    public void commitIdAfterTwoRefreshesIs137() throws Exception {
        session.load();
        session.refresh();
        session.refresh();
        assertEquals(137, session.getLatestCommitId());
    }

    @Test
    public void initialSizeIsZero() throws Exception {
        assertEquals(0, session.getSize());
    }

    @Test
    public void sizeAfterLoadIs_MagicNumber() throws Exception {
        session.load();
        assertEquals(size_after_load, session.getSize());
    }

    @Test
    public void sizeAfterTwoRefreshesIs_MagicNumber() throws Exception {
        session.load().refresh().refresh();
        assertEquals(size_after_refreshes, session.getSize());
    }

    @Test
    public void printSession() throws Exception {
        session.printInfo();
        String actual = ((FakeOut) Logging.out).getOut();
        String expected = "Session:\n" +
                "Partition: partition 1\n" +
                "TableStorage: SQL storage 1\n" +
                "ColumnStorage: JSON storage 1\n" +
                "Partition: partition 2\n" +
                "Partition: partition 3\n" +
                "TableStorage: SQL storage 3\n" +
                "ColumnStorage: JSON storage 2\n" +
                "ColumnStorage: JSON storage 3\n" +
                "TableStorage: SQL storage 2\n";
        assertEquals(expected, actual);
    }

}
