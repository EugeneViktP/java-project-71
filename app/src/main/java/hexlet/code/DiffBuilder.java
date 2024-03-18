package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;
import java.util.List;
//import java.util.HashMap;
import java.util.ArrayList;


public class DiffBuilder {
    public static Map<String, StatusValuesDB> compareData(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, StatusValuesDB> result = new LinkedHashMap<>();
        Set<String> union = new TreeSet<>();
        union.addAll(data1.keySet());
        union.addAll(data2.keySet());
        for (String key : union) {
            if (!data1.containsKey(key)) {
                result.put(key, new StatusValuesDB("added", data2.get(key)));
            } else if (!data2.containsKey(key)) {
                result.put(key, new StatusValuesDB("deleted", data1.get(key)));
//                result.put(key, new StatusValuesDB("deleted", data2.get(key)));
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
                result.put(key, new StatusValuesDB("unchanged", data1.get(key)));
            } else {
                result.put(key, new StatusValuesDB("changed", data1.get(key), data2.get(key)));
            }
        }
        return result;
    }

//    New way of creating DataBase for Formatting through List<Map<String, Object>>

    static List<Map<String, Object>> createData(Map<String, Object> data1, Map<String, Object> data2) {
        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> union = new TreeSet<>();
        union.addAll(data1.keySet());
        union.addAll(data2.keySet());
        for (String key : union) {
            Map<String, Object> unit = new LinkedHashMap<>();
            if (!data1.containsKey(key)) {
                unit.put("key", key);
                unit.put("status", "added");
                unit.put("secondFileValue", data2.get(key));
            } else if (!data2.containsKey(key)) {
                unit.put("key", key);
                unit.put("status", "deleted");
                unit.put("firstFileValue", data1.get(key));
            } else if (Objects.equals(data1.get(key), data2.get(key))) {
                unit.put("key", key);
                unit.put("status", "unchanged");
                unit.put("firstFileValue", data1.get(key));
            } else {
                unit.put("key", key);
                unit.put("status", "changed");
                unit.put("firstFileValue", data1.get(key));
                unit.put("secondFileValue", data2.get(key));
            }
            result.add(unit);
        }
//        System.out.println(result);
        return result;
    }
}
