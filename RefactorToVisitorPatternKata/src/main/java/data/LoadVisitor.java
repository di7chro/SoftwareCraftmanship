package data;

import tree.Visitor;

public class LoadVisitor implements Visitor {

	@Override
	public void handle(Session session) {
	}

	@Override
	public void handle(Partition partition) {
	}

	@Override
	public void handle(Storage storage) {
		storage.load();
	}

}
