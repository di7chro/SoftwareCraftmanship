package tree;

import data.Partition;
import data.Session;
import data.Storage;

public interface Visitor {
	void handle (Session session);

	void handle (Partition partition);

	void handle (Storage storage);	
}
