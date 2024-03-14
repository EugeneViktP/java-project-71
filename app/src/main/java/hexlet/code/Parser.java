package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filepath) throws Exception {
        ObjectMapper objectMapper;
        if (Utils.getFileExtension(filepath).equals("yml")) {
            objectMapper = new YAMLMapper();
        } else if (Utils.getFileExtension(filepath).equals("json")) {
            objectMapper = new ObjectMapper();
        } else {
            throw new Exception("Null pointer");
        }
        return objectMapper.readValue(Utils.createInToParse(filepath), new TypeReference<Map<String, Object>>() {
        });
    }
}


