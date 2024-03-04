package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class ClassComparator {
    public static String genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder result = new StringBuilder();
        Set<String> union = new TreeSet<>();
        union.addAll(data1.keySet());
        union.addAll(data2.keySet());
        result.append("{")
                .append("\n");
        for (String key : union) {
            if (!data1.containsKey(key)) {
                //added
                result.append("+ ")
                        .append(key)
                        .append(": ")
                        .append(data2.get(key))
                        .append("\n");
            } else if (!data2.containsKey(key)) {
                //deleted
                result.append("- ")
                        .append(key)
                        .append(": ")
                        .append(data1.get(key))
                        .append("\n");
            } else if (data1.get(key).equals(data2.get(key))) {
                //unchanged
                result.append("  ")
                        .append(key)
                        .append(": ")
                        .append(data1.get(key))
                        .append("\n");
            } else {
                //changed
                result.append("- ")
                        .append(key)
                        .append(": ")
                        .append(data1.get(key))
                        .append("\n")
                        .append("+ ")
                        .append(key)
                        .append(": ")
                        .append(data2.get(key))
                        .append("\n");

            }
        }
        result.append("}");
        return result.toString();
    }
}

