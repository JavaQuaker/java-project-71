package hexlet.code.Formatters;
import java.util.List;
import java.util.Map;
public class FormatStylish {
    public static String formattingStylish(List<Map<String, Object>> treeDiff) {
        StringBuilder builder = new StringBuilder("{\n");

        for (Map<String, Object> result : treeDiff) {
            String value1 = result.get("key").toString();
            String type = result.get("type").toString();
            switch (type) {
                case "deleted":
                    builder.append("  -" + " " + value1 + ": " + result.get("value"));
                    builder.append("\n");
                    break;
                case "unchanged":
                    builder.append("   " + " " + value1 + ": " + result.get("value"));
                    builder.append("\n");
                    break;
                case "added":
                    builder.append("  +" + " " + value1 + ": " + result.get("value"));
                    builder.append("\n");
                    break;
                case "changed":
                    builder.append("  -" + " " + value1 + ": " + result.get("value1"));
                    builder.append("\n");
                    builder.append("  +" + " " + value1 + ": " + result.get("value2"));
                    builder.append("\n");
                default:
                    break;

            }
        }

        return builder.append("}").toString();
    }
}



