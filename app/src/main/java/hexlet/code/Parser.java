package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(Path filepath1) throws Exception {
        ObjectMapper objectMapper = null;
        File file1 = new File(String.valueOf(filepath1));
        if (Utils.getFileExtension(String.valueOf(filepath1)).equals("yml")) {
            objectMapper = new YAMLMapper();
        } else if (Utils.getFileExtension(String.valueOf(filepath1)).equals("json")) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper.readValue(file1, new TypeReference<Map<String, Object>>() {
        });
    }
}


