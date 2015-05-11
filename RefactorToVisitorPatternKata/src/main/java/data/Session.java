package data;

import java.util.ArrayList;
import java.util.List;

import tree.Visitable;
import tree.Visitor;

public class Session implements Visitable {

	private List<Partition> partitions = new ArrayList<>();

	public void addPartition(Partition partition) {
		partitions.add(partition);
	}

	public void printInfo() {
		Logging.out.println("Session:");
		for (Partition p : partitions) {
			p.printInfo();
		}
	}

	public Session load() {
		Visitor visitor = new LoadVisitor();
		accept(visitor);
		return this;
	}

	public Session refresh() {
//		for (Partition p : partitions) {
//			p.refresh();
//		}
		Visitor visitor = new RefreshVisitor();
		return this;
	}

	public int getLatestCommitId() {
		int latestCommitId = 0;
		for (Partition p : partitions) {
			int partitionCommitId = p.getLatestCommitId();
			if (partitionCommitId > latestCommitId) {
				latestCommitId = partitionCommitId;
			}
		}
		return latestCommitId;
	}

	public int getSize() {
		int totalSize = 0;
		for (Partition p : partitions) {
			totalSize += p.getSize();
		}
		return totalSize;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.handle(this);
		
		for (Partition p : partitions) {
			p.accept(visitor);
		}
	}
}
