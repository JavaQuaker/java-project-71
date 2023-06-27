package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {



    public static Map<String, Object> parse(String filePath) throws IOException {
        Map<String, Object> map = null;
        if (searchExtension(filePath).equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePath);
            map = mapper.readValue(file, new TypeReference<Map<String, Object>>() {
            });
            return map;
        }
        if (searchExtension(filePath).equals("yml")) {
            ObjectMapper mapper1 = new YAMLMapper();
            File file = new File(filePath);
            map = mapper1.readValue(file, new TypeReference<Map<String, Object>>() {
            });
            return map;
        }
        return map;
    }
    public static String searchExtension(String filePath) {
        String[] extension = filePath.split("\\.");
        String resultSearchExtension = extension[extension.length - 1];
        return resultSearchExtension;
    }

}



