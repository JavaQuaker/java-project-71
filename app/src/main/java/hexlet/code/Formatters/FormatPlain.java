package hexlet.code.Formatters;
import java.util.Map;
import java.util.List;


public class FormatPlain {
    public static String formatPlain(List<Map<String, Object>> treeDiff) {
        StringBuilder builder = new StringBuilder();

        for (Map<String, Object> result : treeDiff) {
            String value1 = result.get("key").toString();
            String type = result.get("type").toString();
            switch (type) {
                case "deleted":
                    builder.append("Property '" + value1 + "'" + " " + "was removed");
                    builder.append("\n");
                    break;

                case "added":
                    builder.append("Property '" + value1 + "'" + " " + "was added with" + " " + "value"
                            + ": " + nameVariable(result.get("value")));
                    builder.append("\n");
                    break;

                case "changed":
                    builder.append("Property '" + value1 + "'" + " " + "was updated. From "
                            + nameVariable(result.get("value1"))
                            + " to " + nameVariable(result.get("value2")));
                    builder.append("\n");
                default:
                    break;

            }

        }


        return builder.toString().trim();
    }
    public static String nameVariable(Object value) {

        if (value instanceof String) {
            return "'" + value + "'";
        }
        if ((value instanceof Map<?, ?>) || (value instanceof Iterable<?>)) {
            return "[complex value]";
        }
        if (value == null) {
            return null;
        }
        return value.toString();
    }
}








