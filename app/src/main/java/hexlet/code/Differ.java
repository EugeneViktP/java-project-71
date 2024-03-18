package hexlet.code;

import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String textOne = Utils.createInToParse(filepath1);
        String textTwo = Utils.createInToParse(filepath2);
        String firstFileExtension = Utils.getFileExtension(filepath1);
        String secondFileExtension = Utils.getFileExtension(filepath2);
        Map<String, Object> buffer1 = Parser.parse(textOne, firstFileExtension);
        Map<String, Object> buffer2 = Parser.parse(textTwo, secondFileExtension);
//        var data = DiffBuilder.compareData(buffer1, buffer2);
        var secondData = DiffBuilder.createData(buffer1, buffer2);
//        new method to make comparison
//        System.out.println(Plain.formatter2(secondData));
        return Formatter.format(secondData, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        String textOne = Utils.createInToParse(filepath1);
        String textTwo = Utils.createInToParse(filepath2);
        String firstFileExtension = Utils.getFileExtension(filepath1);
        String secondFileExtension = Utils.getFileExtension(filepath2);
        Map<String, Object> buffer1 = Parser.parse(textOne, firstFileExtension);
        Map<String, Object> buffer2 = Parser.parse(textTwo, secondFileExtension);
//        var data = DiffBuilder.compareData(buffer1, buffer2);
        var data = DiffBuilder.createData(buffer1, buffer2);

        return Formatter.format(data, "stylish");
    }
}
