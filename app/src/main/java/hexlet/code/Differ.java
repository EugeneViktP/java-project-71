package hexlet.code;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import java.io.IOException;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> buffer1 = Parser.parse(filepath1);
        Map<String, Object> buffer2 = Parser.parse(filepath2);
        return ClassComparator.genDiff(buffer1, buffer2);
    }
}
