package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static String formatter(List<Map<String, Object>> data) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        String json = "";
//        try {
//            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return json;
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }
}
