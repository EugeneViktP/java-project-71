package hexlet.code.formatters;

import hexlet.code.StatusValuesDB;

import java.util.Map;

public class Plain {
    public static String formatter(Map<String, StatusValuesDB> data) {
        return data.toString();
    }
}
