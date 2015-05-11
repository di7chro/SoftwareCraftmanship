package data;

import tree.Visitable;

public interface Storage extends Visitable {

    int getSize();

    void load();

}
