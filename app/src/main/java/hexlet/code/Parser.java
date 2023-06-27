package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {

    /* Доработать метод parse для применения в методу generate класса Differ*/
    public static Map<String, Object> parseFirst(String filePath1) throws IOException {
        Map<String, Object> map1 = null;
        Map<String, Object> map2 = null;
        if (searchExtension(filePath1).equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            File file1 = new File(filePath1);

            map1 = mapper.readValue(file1, new TypeReference<Map<String, Object>>() {
            });

            return map1;
        }

        if (searchExtension(filePath1).equals("yaml")) {
            ObjectMapper mapper = new YAMLMapper();
            File file1 = new File(filePath1);
            map2 = mapper.readValue(file1, new TypeReference<Map<String, Object>>() {
            });
        }
        return map2;
    }
    public static Map<String, Object> parseSecond(String filePath2) throws IOException {
        Map<String, Object> map1 = null;
        Map<String, Object> map2 = null;
        if (searchExtension(filePath2).equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            File file2 = new File(filePath2);

            map1 = mapper.readValue(file2, new TypeReference<Map<String, Object>>() {
            });


            return map1;
        }

        if (searchExtension(filePath2).equals("yaml")) {
            ObjectMapper mapper = new YAMLMapper();
            File file2 = new File(filePath2);
            map2 = mapper.readValue(file2, new TypeReference<Map<String, Object>>() {
            });
        }
        return map2;
    }


    public static String searchExtension(String filePath) {
        String[] extension = filePath.split("\\.");
        String resultSearchExtension = extension[extension.length - 1];
        return resultSearchExtension;
    }

}

