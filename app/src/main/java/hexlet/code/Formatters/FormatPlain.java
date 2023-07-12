package hexlet.code.Formatters;
import java.util.Map;
import java.util.List;


public class FormatPlain {
    public static String formatPlain(List<Map<String, Object>> treeDiff) {
        StringBuilder builder = new StringBuilder();

        for (Map<String, Object> result : treeDiff) {
            String valueOne = result.get("key").toString();
            String type = result.get("type").toString();
            switch (type) {
                case "deleted":
                    builder.append("Property '" + valueOne + "'" + " " + "was removed");
                    builder.append("\n");
                    break;

                case "added":
                    builder.append("Property '" + valueOne + "'" + " " + "was added with" + " " + "value"
                            + ": " + definitionNameVariable(result.get("value")));
                    builder.append("\n");
                    break;

                case "changed":
                    builder.append("Property '" + valueOne + "'" + " " + "was updated. From "
                            + definitionNameVariable(result.get("value1"))
                            + " to " + definitionNameVariable(result.get("value2")));
                    builder.append("\n");
                default:
                    break;

            }

        }


        return builder.toString().trim();
    }
    public static String definitionNameVariable(Object value) {

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








