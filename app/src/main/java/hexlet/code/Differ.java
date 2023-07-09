package hexlet.code;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.TreeSet;


public class Differ {

    static List<Map<String, Object>> listMap1 = new ArrayList<>();
    static Map<String, Object> map1;
    static Map<String, Object> map2;


    public static List<Map<String, Object>> diffGenerate(String filePath1, String filePath2) throws IOException {
        map1 = Parser.parse(filePath1);
        map2 = Parser.parse(filePath2);
        TreeSet<String> treeSet = new TreeSet<>(map1.keySet());
        treeSet.addAll(map2.keySet());
        listMap1.clear();

        for (String key : treeSet) {
            Map<String, Object> map = new LinkedHashMap<>();
            Object value1 = map1.get(key);
            Object value2 = map2.get(key);
            map.put("key", key);

            if (!map2.containsKey(key)) {
                map.put("type", "deleted");
                map.put("value", value1);
            } else if (!map1.containsKey(key)) {
                map.put("type", "added");
                map.put("value", value2);
            } else if (compare(value1, value2)) {
                map.put("type", "unchanged");
                map.put("value", value1);

            } else {
                map.put("type", "changed");
                map.put("value1", value1);
                map.put("value2", value2);
            }
            listMap1.add(map);
        }

        return listMap1;
    }
    public static boolean compare(Object object1, Object object2) {
        if ((object1 == null) && (object2 == null)) {
            return true;
        }
        if ((object1 == null) || (object2 == null)) {
            return false;
        }
        return object1.equals(object2);
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws IOException {

        return Formatter.formatting(Differ.diffGenerate(filePath1, filePath2), formatName);
    }
    public static String generate(String filePath1, String filePath2) throws IOException {
        return Formatter.formatting(Differ.diffGenerate(filePath1, filePath2), "stylish");
    }

}

