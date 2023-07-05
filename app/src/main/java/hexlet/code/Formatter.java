package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatting(List<Map<String, Object>> list, String formatName) throws JsonProcessingException {
        if (Parser.searchExtension(formatName).equals("stylish")) {
            return FormatStylish.formatting(list, formatName);
        } else if (Parser.searchExtension(formatName).equals("plain")) {
            return FormatPlain.formatPlain(list, formatName);
        } else if (Parser.searchExtension(formatName).equals("json")) {
            return FormatJson.formatJson(list, formatName);
        }
        return FormatStylish.formatting(list, formatName);
    }
}

