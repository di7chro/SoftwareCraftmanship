package data;

import java.util.ArrayList;
import java.util.List;

import tree.Visitable;
import tree.Visitor;

public class Partition implements Visitable {

	private String name;
	private List<Storage> storages;
	private List<Partition> partitions;

	public Partition(String name, List<Partition> partitions,
			List<Storage> storages) {
		this.partitions = partitions;
		this.storages = storages;
		this.name = name;
	}

	public Partition(String name) {
		this(name, new ArrayList<Partition>(), new ArrayList<Storage>());
	}

	public void addPartition(Partition partition) {
		partitions.add(partition);
	}

	public void addStorage(Storage storage) {
		storages.add(storage);
	}

	public void printInfo() {
		Logging.out.println("Partition: " + name);
		for (Partition p : partitions) {
			p.printInfo();
		}
		for (Storage s : storages) {
			if (s instanceof TableStorage) {
				((TableStorage) s).printout();
			}
			if (s instanceof ColumnStorage) {
				((ColumnStorage) s).dump();
			}
		}
	}

	public void load() {  // Visitor
//		Visitor visitor = new LoadVisitor();
//		accept(visitor);
//		return visitor;
	}

	public void refresh() {
		for (Partition p : partitions) {
			p.refresh();
		}
		for (Storage s : storages) {
			if (s instanceof TableStorage) {
				((TableStorage) s).refresh();
			}
		}
	}

	public int getSize() {
		int total_size = 0;
		for (Partition p : partitions) {
			total_size += p.getSize();
		}
		for (Storage s : storages) {
			total_size += s.getSize();
		}
		return total_size;
	}

	public int getLatestCommitId() {
		int latestCommitId = 0;
		for (Partition p : partitions) {
			int partitionCommitId = p.getLatestCommitId();
			if (partitionCommitId > latestCommitId) {
				latestCommitId = partitionCommitId;
			}
		}
		for (Storage s : storages) {
			if (s instanceof TableStorage) {
				int storageCommitId = ((TableStorage) s).getLatestCommitId();
				if (storageCommitId > latestCommitId) {
					latestCommitId = storageCommitId;
				}
			}
		}
		return latestCommitId;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.handle(this);

		for (Partition p : partitions) {
			p.accept(visitor);
		}
		for (Storage s : storages) {
			s.accept(visitor);
		}
	}
}
