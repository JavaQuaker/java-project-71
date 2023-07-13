package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String formatName) throws IOException {
        Map<String, Object> dataPreparation = new LinkedHashMap<>();
        if (formatName.equals("json")) {
            ObjectMapper mapper = new ObjectMapper();

            new ObjectMapper().readValue(content, Map.class);
            dataPreparation = mapper.readValue(content, new TypeReference<Map<String, Object>>() {
            });

            return dataPreparation;
        }
        if (formatName.equals("yml")) {
            ObjectMapper mapper1 = new YAMLMapper();

            new ObjectMapper().readValue(content, Map.class);
            dataPreparation = mapper1.readValue(content, new TypeReference<Map<String, Object>>() {
            });
            return dataPreparation;
        }

        return dataPreparation;
    }

    public static Path defendingPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

}



