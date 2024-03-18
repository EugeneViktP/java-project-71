package hexlet.code.formatters;

//import hexlet.code.StatusValuesDB;

import java.util.List;
import java.util.Map;

public class Plain {
//    public static String formatter(Map<String, StatusValuesDB> data) {
//        StringBuilder result = new StringBuilder();
//        for (String key : data.keySet()) {
//            switch (data.get(key).getKey()) {
//                case "added" -> //added
//                        result.append("Property '")
//                                .append(key)
//                                .append("' was added with value: ")
//                                .append(checkComplexity(data.get(key).getValue1()))
//                                .append("\n");
//                case "deleted" -> //deleted
//                        result.append("Property '")
//                                .append(key)
//                                .append("' was removed")
//                                .append("\n");
//                case "unchanged" -> //unchanged
//                        result.append("");
//                case "changed" -> //changed
//                        result.append("Property '")
//                                .append(key)
//                                .append("' was updated. From ")
//                                .append(checkComplexity(data.get(key).getValue1()))
//                                .append(" to ")
//                                .append(checkComplexity(data.get(key).getValue2()))
//                                .append("\n");
//                default -> System.out.println("Status not identified");
//            }
//        }
//        return result.substring(0, result.length() - 1);
//    }

    public static String checkComplexity(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Map || obj instanceof List) {
            return "[complex value]";
        } else if (obj instanceof String && obj != null) {
            return "'" + obj.toString() + "'";
        }
        return obj.toString();
    }


//    new Plain formatter

    public static String formatter(List<Map<String, Object>> data) {
        StringBuilder result = new StringBuilder();
        for (var unit : data) {
            switch (unit.get("status").toString()) {
                case "added" -> //added
                        result.append("Property '")
                                .append(unit.get("key"))
                                .append("' was added with value: ")
                                .append(checkComplexity(unit.get("secondFileValue")))
                                .append("\n");
                case "deleted" -> //deleted
                        result.append("Property '")
                                .append(unit.get("key"))
                                .append("' was removed")
                                .append("\n");
                case "unchanged" -> //unchanged
                        result.append("");
                case "changed" -> //changed
                        result.append("Property '")
                                .append(unit.get("key"))
                                .append("' was updated. From ")
                                .append(checkComplexity(unit.get("firstFileValue")))
                                .append(" to ")
                                .append(checkComplexity(unit.get("secondFileValue")))
                                .append("\n");
                default -> System.out.println("Status not identified");
            }
        }
        return result.substring(0, result.length() - 1);
    }
}
