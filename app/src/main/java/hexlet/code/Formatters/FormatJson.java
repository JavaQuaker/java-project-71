package hexlet.code.Formatters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.List;

public class FormatJson {
    public static String formatJson(List<Map<String, Object>> treeDiff) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(treeDiff).trim();
    }
}
