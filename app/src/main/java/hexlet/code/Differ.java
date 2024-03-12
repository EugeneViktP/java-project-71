package hexlet.code;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import java.io.IOException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> buffer1 = Parser.parse(filepath1);
        Map<String, Object> buffer2 = Parser.parse(filepath2);
        var data = diffBuilder(buffer1, buffer2);
        return Formatter.format(data, format);
    }

    // DiffBuilder
    public static Map<String, StatusValuesDB> diffBuilder(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, StatusValuesDB> result = new LinkedHashMap<>();
        Set<String> union = new TreeSet<>();
        union.addAll(data1.keySet());
        union.addAll(data2.keySet());
        for (String key : union) {
            if (!data1.containsKey(key)) {
                result.put(key, new StatusValuesDB("added", data2.get(key)));
            } else if (!data2.containsKey(key)) {
                result.put(key, new StatusValuesDB("deleted", data1.get(key)));
            } else if (data1.get(key).equals(data2.get(key))) {
                result.put(key, new StatusValuesDB("unchanged", data1.get(key)));
            } else {
                result.put(key, new StatusValuesDB("changed", data1.get(key), data2.get(key)));
            }
        }
        return result;
    }
}
