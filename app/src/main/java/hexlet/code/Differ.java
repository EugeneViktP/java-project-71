package hexlet.code;


//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
//import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(Path filepath1, Path filepath2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file1 = new File(String.valueOf(filepath1));
        File file2 = new File(String.valueOf(filepath2));
        Map<String, Object> buffer1 = objectMapper.readValue(file1, new TypeReference<Map<String, Object>>() {
        });
        Map<String, Object> buffer2 = objectMapper.readValue(file2, new TypeReference<Map<String, Object>>() {
        });
        return ClassComparator.genDiff(buffer1, buffer2);
    }
}
