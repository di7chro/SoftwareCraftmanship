package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.Visitable;
import tree.Visitor;

public class TableStorageFake extends TableStorage implements Visitable {

    private static final Map<String, Map<String, List<Integer>>> _mock_data;

    static {
        _mock_data = new HashMap<>();
        _mock_data.put("SQL storage 1",
                m("cids", "0, 123,   126,   134,   156,   158",
                        "sizes", "0, 46544, 50444, 51345, 52333, 55991"));
        _mock_data.put("SQL storage 2",
                m("cids", "0, 125,   133,   134,   143,   155",
                        "sizes", "0, 344,   544,   545,   633,   791"));
        _mock_data.put("SQL storage 3",
                m("cids", "0, 124,   127,   137,   177,   199",
                        "sizes", "0, 465,   504,   513,   523,   559"));
    }

    private String name;
    private int mockDataIndex = 0;

    public TableStorageFake(String name) {
        this.name = name;
    }

    @Override
    public void printout() {
        Logging.out.println("TableStorage: " + name);
    }

    @Override
    public int getSize() {
        // return DaveStorageMock._mock_data[name]["sizes"][index]
        return _mock_data.get(name).get("sizes").get(mockDataIndex);
    }

    @Override
    public int getLatestCommitId() {
        // return DaveStorageMock._mock_data[name]["cids"][index]
        return _mock_data.get(name).get("cids").get(mockDataIndex);
    }

    @Override
    public void load() {
        this.mockDataIndex = 1;
    }

    @Override
    public void refresh() {
        this.mockDataIndex++;
        if (this.mockDataIndex > _mock_data.get(name).get("cids").size()) {
            throw new IllegalStateException("out of mock data!");
        }
    }

    // this is soo ugly
    private static Map<String, List<Integer>> m(Object... args) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int index = 0; index < args.length; index = index + 2) {
            String key = (String) args[index];
            List<Integer> values = new ArrayList<Integer>();
            for (String n : ((String) args[index + 1]).split(",")) {
                values.add(new Integer(n.trim()));
            }
            map.put(key, values);
        }
        return map;
    }

    @Override
    public void accept (Visitor visitor) {
    	visitor.handle(this);
    }
}
