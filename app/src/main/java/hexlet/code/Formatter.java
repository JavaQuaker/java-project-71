package hexlet.code;
import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.Formatters.FormatJson;
import hexlet.code.Formatters.FormatPlain;
import hexlet.code.Formatters.FormatStylish;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatting(List<Map<String, Object>> treeDiff, String formatName)
            throws JsonProcessingException {
        if (formatName.equals("stylish")) {
            return FormatStylish.formattingStylish(treeDiff);
        } else if (formatName.equals("plain")) {
            return FormatPlain.formatPlain(treeDiff);
        } else if (formatName.equals("json")) {
            return FormatJson.formatJson(treeDiff);
        }
        throw new RuntimeException("");
    }
}

