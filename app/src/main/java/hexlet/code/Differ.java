package hexlet.code;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.TreeSet;


public class Differ {

//    static String filePath1 = "app/src/test/resources/jsonFile_1.json";
//    static String getFilePath2 = "app/src/test/resources/jsonFile_2.json";

//    static String filePath1 = "app/src/test/resources/testAttachFile_1.yml";
//    static String getFilePath2 = "app/src/test/resources/testAttachFile_2.yml";

//    static String filePath1 = "app/src/test/resources/Test_1yaml.yml";
//    static String getFilePath2 = "app/src/test/resources/Test_yaml_2.yml";
    static List<Map<String, Object>> listMap1 = new ArrayList<>();
    static Map<String, Object> map1;
    static Map<String, Object> map2;

//    public static void main(String[] args) throws IOException {
//        System.out.println(generate(filePath1, getFilePath2, "yml"));
//    }

    public static List<Map<String, Object>> generate(String filePath1, String filePath2) throws IOException {

        map1 = Parser.parse(filePath1);
        map2 = Parser.parse(filePath2);

        TreeSet<String> treeSet = new TreeSet<>(map1.keySet());
        treeSet.addAll(map2.keySet());
        listMap1.clear();
        for (String key : treeSet) {
            if (map1.containsKey(key) & map2.containsKey(key)) {
                Object value1 = map1.get(key);
                Object value2 = map2.get(key);
                Map<String, Object> map = new LinkedHashMap<>();
                if (value1 != null) {
                    if (value1.equals(value2)) {
                        map.put("    " + key, value1);
                    } else {
                        map.put("  " + "-" + " " + key, value1);
                    }
                } else {
                    map.put("  " + "-" + " " + key, map1.get(key));
                    map.put("  " + "+" + " " + key, map2.get(key));
                }
                listMap1.add(map);
            }
            if (map1.containsKey(key) & (!map2.containsKey(key))) {
                Map<String, Object> map = new LinkedHashMap<>();
                Object value1 = map1.get(key);
                map.put("  " + "-" + " " + key, value1);
                listMap1.add(map);
            }
            if (map2.containsKey(key) & (!map1.containsKey(key))) {
                Map<String, Object> map = new LinkedHashMap<>();
                Object value2 = map2.get(key);
                map.put("  " + "+" + " " + key, value2);
                listMap1.add(map);
            }
            if (map1.containsKey(key) & (map2.containsKey(key))) {
                Map<String, Object> map = new LinkedHashMap<>();
                Object value1 = map1.get(key);
                Object value2 = map2.get(key);
                if (value1 != null) {
                    if (!value1.equals(value2)) {
                        map.put("  " + "+" + " " + key, map2.get(key));
                        listMap1.add(map);
                    }
                }
            }
        }

        return listMap1;

    }
    public static String generate(String filePath1, String filePath2, String formatName) throws IOException {

        return Formatter.formatting(Differ.generate(filePath1, filePath2), formatName);
    }


    public static String toString(List<Map<String, Object>> list) {
        StringBuilder builder = new StringBuilder();
        System.out.println("{");
        for (Map<String, Object> result : list) {
            for (String key : result.keySet()) {
                Object value = result.get(key);
                builder.append(key).append(": " + "").append(value).append("\n");
            }
        }
        System.out.println(builder.toString().replaceAll("\\s+$", ""));
        System.out.println("}");
        return builder.toString();
    }
}

