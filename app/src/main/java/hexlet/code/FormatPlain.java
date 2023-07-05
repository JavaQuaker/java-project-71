package hexlet.code;
import java.util.Map;
import java.util.List;


public class FormatPlain {
    public static String formatPlain(List<Map<String, Object>> list, String formatName) {
        StringBuilder builder = new StringBuilder();
        if (formatName.equals("plain")) {
            for (Map<String, Object> result : list) {
                String value1 = result.get("key").toString();
                if (result.get("type").equals("deleted")) {
                    builder.append("Property '" + value1 + "'" + " " + "was removed");
                    builder.append("\n");

                }
                if (result.get("type").equals("added")) {
                    builder.append("Property '" + value1 + "'" + " " + "was added with" + " " + "value"
                            + ": " + nameVariable(result.get("value")));
                    builder.append("\n");

                }
                if (result.get("type").equals("changed")) {
                    builder.append("Property '" + value1 + "'" + " " + "was updated. From "
                            + nameVariable(result.get("value1"))
                            + " to " + nameVariable(result.get("value2")));
                    builder.append("\n");
                }

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








