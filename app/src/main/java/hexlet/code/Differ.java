package hexlet.code;

import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> buffer1 = Parser.parse(filepath1);
        Map<String, Object> buffer2 = Parser.parse(filepath2);
        var data = DiffBuilder.compareData(buffer1, buffer2);
        return Formatter.format(data, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> buffer1 = Parser.parse(filepath1);
        Map<String, Object> buffer2 = Parser.parse(filepath2);
        var data = DiffBuilder.compareData(buffer1, buffer2);
        return Formatter.format(data, "stylish");
    }
}
