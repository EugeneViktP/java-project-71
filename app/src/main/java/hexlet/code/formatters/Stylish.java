package hexlet.code.formatters;

//import hexlet.code.StatusValuesDB;

import java.util.List;
import java.util.Map;

public class Stylish {
//    public static String formatter(Map<String, StatusValuesDB> data) {
//        StringBuilder result = new StringBuilder();
//        result.append("{")
//                .append("\n");
//        for (String key : data.keySet()) {
//            switch (data.get(key).getKey()) {
//                case "added" -> //added
//                        result.append("  + ")
//                                .append(key)
//                                .append(": ")
//                                .append(data.get(key).getValue1())
//                                .append("\n");
//                case "deleted" -> //deleted
//                        result.append("  - ")
//                                .append(key)
//                                .append(": ")
//                                .append(data.get(key).getValue1())
//                                .append("\n");
//                case "unchanged" -> //unchanged
//                        result.append("    ")
//                                .append(key)
//                                .append(": ")
//                                .append(data.get(key).getValue1())
//                                .append("\n");
//                case "changed" -> //changed
//                        result.append("  - ")
//                                .append(key)
//                                .append(": ")
//                                .append(data.get(key).getValue1())
//                                .append("\n")
//                                .append("  + ")
//                                .append(key)
//                                .append(": ")
//                                .append(data.get(key).getValue2())
//                                .append("\n");
//                default -> System.out.println("Status not identified");
//            }
//        }
//        result.append("}");
//        return result.toString();
//    }


//    New stylish

    public static String formatter(List<Map<String, Object>> data) {
        StringBuilder result = new StringBuilder();
        result.append("{")
                .append("\n");
        for (var unit : data) {
            Object caseName = unit.get("status");
            switch (caseName.toString()) {
                case "added" -> //added
                        result.append("  + ")
                                .append(unit.get("key"))
                                .append(": ")
                                .append(unit.get("secondFileValue"))
                                .append("\n");
                case "deleted" -> //deleted
                        result.append("  - ")
                                .append(unit.get("key"))
                                .append(": ")
                                .append(unit.get("firstFileValue"))
                                .append("\n");
                case "unchanged" -> //unchanged
                        result.append("    ")
                                .append(unit.get("key"))
                                .append(": ")
                                .append(unit.get("firstFileValue"))
                                .append("\n");
                case "changed" -> //changed
                        result.append("  - ")
                                .append(unit.get("key"))
                                .append(": ")
                                .append(unit.get("firstFileValue"))
                                .append("\n")
                                .append("  + ")
                                .append(unit.get("key"))
                                .append(": ")
                                .append(unit.get("secondFileValue"))
                                .append("\n");
                default -> System.out.println("Status not identified");
            }
        }
        result.append("}");
        return result.toString();
    }
}
