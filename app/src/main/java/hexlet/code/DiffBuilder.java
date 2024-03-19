package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;


public class DiffBuilder {
    static List<Map<String, Object>> createData(Map<String, Object> data1, Map<String, Object> data2) {
        List<Map<String, Object>> result = new ArrayList<>();
        Set<String> union = new TreeSet<>();
        union.addAll(data1.keySet());
        union.addAll(data2.keySet());
        for (String key : union) {
            Map<String, Object> unit = new LinkedHashMap<>();
            unit.put("key", key);
            if (!data1.containsKey(key)) {
//                unit.put("key", key);
                unit.put("status", "added");
                unit.put("secondFileValue", data2.get(key));
            } else if (!data2.containsKey(key)) {
//                unit.put("key", key);
                unit.put("status", "deleted");
                unit.put("firstFileValue", data1.get(key));
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
//                unit.put("key", key);
                unit.put("status", "unchanged");
                unit.put("firstFileValue", data1.get(key));
            } else {
//                unit.put("key", key);
                unit.put("status", "changed");
                unit.put("firstFileValue", data1.get(key));
                unit.put("secondFileValue", data2.get(key));
            }
            result.add(unit);
        }
        return result;
    }
}
