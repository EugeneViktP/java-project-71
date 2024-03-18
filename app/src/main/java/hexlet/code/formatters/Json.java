package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
//import hexlet.code.StatusValuesDB;

import java.util.List;
import java.util.Map;

public class Json {
//    public static String formatter(Map<String, StatusValuesDB> data) {
//        ObjectMapper mapper = new ObjectMapper();
//        String json = "";
//        try {
//            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return json;
//    }


    public static String formatter(List<Map<String, Object>> data) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return json;
    }
}
