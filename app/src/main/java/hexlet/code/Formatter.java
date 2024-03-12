package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, StatusValuesDB> data, String format) {
        switch (format) {
            case "stylish" -> {
                return Stylish.formatter(data);
            }
            case "plain" -> {
                return Plain.formatter(data);
            }
            default -> {
                return "Option -f format is Wrong";
            }
        }
    }
}
