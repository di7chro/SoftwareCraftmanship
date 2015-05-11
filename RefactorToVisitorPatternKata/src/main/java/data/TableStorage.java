package data;

/**
 * Implementation omitted, we use test doubles for testing
 */
public abstract class TableStorage implements Storage {

    abstract public int getSize();

    abstract public int getLatestCommitId();

    abstract public void printout();

    abstract public void load();

    abstract public void refresh();

}
