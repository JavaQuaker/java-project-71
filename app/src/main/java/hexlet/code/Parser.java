package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parsingToString(String content, String formatName) throws IOException {
        Map<String, Object> dataPreparation = new LinkedHashMap<>();
        if (formatName.equals("json")) {
            ObjectMapper mapperFileJson = new ObjectMapper();

            new ObjectMapper().readValue(content, Map.class);
            dataPreparation = mapperFileJson.readValue(content, new TypeReference<Map<String, Object>>() {
            });
            return dataPreparation;
        }
        if (formatName.equals("yml")) {

            ObjectMapper mapperFileYml = new YAMLMapper();

            dataPreparation = mapperFileYml.readValue(content, new TypeReference<Map<String, Object>>() {
            });

            return dataPreparation;
        }

        return dataPreparation;
    }
}





