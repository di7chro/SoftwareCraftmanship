package data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FakeOutTest {

    @Test
    public void simpleFlow() throws Exception {
        FakeOut f = new FakeOut();
        f.println("Hello");
        f.println("World");
        assertEquals("Hello\nWorld\n", f.getOut());
    }

}
