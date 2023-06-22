package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Map;

import static hexlet.code.Differ.map1;

public class Parser {
        // метод преобразования фалов в мапу
        public static void converting(String filePath1, String filePath2) throws IOException {

            if (searchExtension(filePath1).equals("json")) {
                ObjectMapper mapper = new ObjectMapper();
                 Map<String, Object> map1 = mapper.readValue(filePath1, new TypeReference<Map<String, Object>>() {
                 });
                 Map<String, Object> map2 = mapper.readValue(filePath2, new TypeReference<Map<String, Object>>() {
                 });
            }

            if (searchExtension(filePath1).equals("yml") || (searchExtension(filePath1).equals("yaml"))) {
                Yaml yaml = new Yaml();
                Map<String, Object> map1 = yaml.load(filePath1);
                Map<String, Object> map2 = yaml.load(filePath2);
            }
        }
        // метод поиска расширения
        public static String searchExtension(String filePath) {
            String[] extension = filePath.split("\\.");
            String resultSearchExtension = extension[extension.length - 1];
            return resultSearchExtension;
        }
    }


