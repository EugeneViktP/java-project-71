package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
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
