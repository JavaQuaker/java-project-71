package hexlet.code;

import hexlet.code.Formatters.FormatJson;
import hexlet.code.Formatters.FormatPlain;
import hexlet.code.Formatters.FormatStylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatting(List<Map<String, Object>> treeDiff, String formatName)
            throws IOException {
        switch (formatName) {
            case "stylish" -> {
                return FormatStylish.formattingStylish(treeDiff);
            }
            case "plain" -> {
                return FormatPlain.formatPlain(treeDiff);
            }
            case "json" -> {
                return FormatJson.formatJson(treeDiff);
            }
            default -> {
            }
        }
        throw new IOException("");
    }
}
