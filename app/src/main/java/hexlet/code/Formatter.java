package hexlet.code;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String formatting(List<Map<String, Object>> list, String formatName) {
        StringBuilder builder = new StringBuilder();
        if ((formatName.equals("stylish"))) {

            System.out.println("{");
            for (Map<String, Object> result : list) {
                for (String key : result.keySet()) {
                    Object value = result.get(key);
                    builder.append(key).append(": " + "").append(value).append("\n");
                }
            }
            System.out.println(builder.toString().replaceAll("\\s+$", ""));
            System.out.println("}");

        }
        return builder.toString();
    }
}
