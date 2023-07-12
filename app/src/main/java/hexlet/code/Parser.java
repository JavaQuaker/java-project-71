package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filePath) throws IOException {
        Map<String, Object> dataPreparation = null;
        if (lookingForAnExtension(filePath).equals("json")) {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(filePath);
            dataPreparation = mapper.readValue(file, new TypeReference<Map<String, Object>>() {
            });
            return dataPreparation;
        }
        if (lookingForAnExtension(filePath).equals("yml")) {
            ObjectMapper mapper1 = new YAMLMapper();

            File file = new File(filePath);
            dataPreparation = mapper1.readValue(file, new TypeReference<Map<String, Object>>() {
            });
            return dataPreparation;
        }

        return dataPreparation;
    }
    public static String lookingForAnExtension(String filePath) {
        String[] extension = filePath.split("\\.");
        String resultSearchExtension = extension[extension.length - 1];
        return resultSearchExtension;
    }
    public static Path defendingPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

}



