package hexlet.code;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashMap;

public class Differ {

//    static String filePath1 = "app/src/test/resources/jsonFile_1.json";
//    static String getFilePath2 = "app/src/test/resources/jsonFile_2.json";

        //        static String filePath1 = "app/src/test/resources/Test_1yaml.yaml";
//    static String getFilePath2 = "app/src/test/resources/Test_yaml_2.yaml";
//    static String filePath1 = "app/src/test/resources/Test_1yaml.yml";
//    static String getFilePath2 = "app/src/test/resources/Test_yaml_2.yml";
    static List<Map<String, Object>> listMap1 = new ArrayList<>();
    static List<Map<String, Object>> listMap2;
    static Map<String, Object> map1;
    static Map<String, Object> map2;

//    public static void main(String[] args) throws IOException {
//        generate(filePath1, getFilePath2);
//    }

    public static String generate(String filePath1, String filePath2) throws IOException {

        map1 = Parser.parse(filePath1);
        map2 = Parser.parse(filePath2);

        TreeSet<String> treeSet = new TreeSet<>(map1.keySet());
        treeSet.addAll(map2.keySet());
        listMap1.clear();
        for (String key : treeSet) {
            if (map1.containsKey(key) & map2.containsKey(key)) {
                Object value1 = map1.get(key);
                Object value2 = map2.get(key);

                Map<String, Object> map = new HashMap<>();
                if (value1.equals(value2)) {
                    map.put("    " + key, value1);
                } else {
                    map.put("  " + "-" + " " + key, value1);
                }
                listMap1.add(map);
            }
            if (map1.containsKey(key) & (!map2.containsKey(key))) {
                Map<String, Object> map = new HashMap<>();
                Object value1 = map1.get(key);
                map.put("  " + "-" + " " + key, value1);
                listMap1.add(map);
            }
            if (map2.containsKey(key) & (!map1.containsKey(key))) {
                Map<String, Object> map = new HashMap<>();
                Object value2 = map2.get(key);
                map.put("  " + "+" + " " + key, value2);
                listMap1.add(map);
            }
            if (map1.containsKey(key) & (map2.containsKey(key))) {
                Map<String, Object> map = new HashMap<>();
                Object value1 = map1.get(key);
                Object value2 = map2.get(key);
                if (!value1.equals(value2)) {
                    map.put("  " + "+" + " " + key, map2.get(key));
                    listMap1.add(map);
                }
            }
        }
        return toString(listMap1);
    }


    public static String toString(List<Map<String, Object>> list) {
        StringBuilder builder = new StringBuilder();
        System.out.println("{");
        for (Map<String, Object> result : list) {
            for (String key : result.keySet()) {
                Object value = result.get(key);
                builder.append(key).append(": " + " ").append(value).append("\n");
            }
        }
        System.out.println(builder.toString().replaceAll("\\s+$", ""));
        System.out.println("}");
        return builder.toString();
    }
}

