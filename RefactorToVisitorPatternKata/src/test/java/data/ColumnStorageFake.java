package data;

import java.util.HashMap;
import java.util.Map;

import tree.Visitor;

public class ColumnStorageFake extends ColumnStorage {

    private String name;
    private int size = 0;
    private static final Map<String, Integer> _mock_data;

    static {
        _mock_data = new HashMap<>();
        _mock_data.put("JSON storage 1", 6645);
        _mock_data.put("JSON storage 2", 321);
        _mock_data.put("JSON storage 3", 566);
    }

    public ColumnStorageFake(String name) {
        this.name = name;
    }

    public void dump() {
        Logging.out.println("ColumnStorage: " + name);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void load() {
        if (_mock_data.containsKey(name)) {
            size = _mock_data.get(name);
        } else {
            size = -1;
        }
    }

	@Override
	public void accept(Visitor visitor) {
		visitor.handle(this);
	}

}
