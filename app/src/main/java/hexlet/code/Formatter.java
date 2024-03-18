package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
//    public static String format(Map<String, StatusValuesDB> data, String format) {
    public static String format(List<Map<String, Object>> data, String format) {
        switch (format) {
            case "stylish" -> {
                return Stylish.formatter(data);
            }
            case "plain" -> {
                return Plain.formatter(data);
            }
            case "json" -> {
                return Json.formatter(data);
            }
            default -> {
                return "Option -f format is Wrong";
            }
        }
    }
}
