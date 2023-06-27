package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;

import java.io.IOException;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashMap;

//import static hexlet.code.App.listMap;


public class Differ {
//    static String filePath1 = "app/src/test/resources/jsonFile_1.json";
//    static String getFilePath2 = "app/src/test/resources/jsonFile_2.json";

//    static String filePath1 = "app/src/test/resources/Test_1yaml.yaml";
//    static String getFilePath2 = "app/src/test/resources/Test_yaml_2.yaml";
    static List<Map<String, Object>> listMap1;
    static List<Map<String, Object>> listMap2;
    static Map<String, Object> map1;
    static Map<String, Object> map2;



//    public static void main(String[] args) throws IOException {
//        generate(filePath1, getFilePath2);
//    }

    public static String generate(String filePath1, String filePath2) throws IOException {

        File file1 = new File(filePath1);
        File file2 = new File(filePath2);

        if (Parser.searchExtension(filePath1).equals("json")) {
            listMap1 = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            map1 = mapper.readValue(file1, new TypeReference<Map<String, Object>>() {
            });
            map2 = mapper.readValue(file2, new TypeReference<Map<String, Object>>() {
            });
            TreeSet<String> treeSet = new TreeSet<String>(map1.keySet());
            treeSet.addAll(map2.keySet());

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


        if (Parser.searchExtension(filePath1).equals("yaml")) {
            listMap2 = new ArrayList<>();
            ObjectMapper mapper = new YAMLMapper();
            map1 = mapper.readValue(file1, new TypeReference<Map<String, Object>>() {
            });
            map2 = mapper.readValue(file2, new TypeReference<Map<String, Object>>() {
            });
            Object value1;
            String key1 = null;
            Object value2;
            String key2 = null;

            List<Object> list = new ArrayList<>();

            for (Map.Entry<String, Object> result : map1.entrySet()) {
                key1 = result.getKey();
                value1 = result.getValue();
                list.add(value1);

            }
            for (Map.Entry<String, Object> result : map2.entrySet()) {
                key2 = result.getKey();
                value2 = result.getValue();
                list.add(value2);
            }
            Map<String, Object> newMap1 = (Map<String, Object>) map1.get(key1);
            Map<String, Object> newMap2 = (Map<String, Object>) map2.get(key2);

            TreeSet<String> treeSet = new TreeSet<>(newMap1.keySet());
            treeSet.addAll(newMap2.keySet());

            for (String key : treeSet) {

                if (newMap1.containsKey(key) & newMap2.containsKey(key)) {
                    Object valueMap1 = newMap1.get(key);
                    Object valueMap2 = newMap2.get(key);

                    Map<String, Object> map = new HashMap<>();
                    if (valueMap1 != null) {
                        if (valueMap1.equals(valueMap2)) {
                            map.put("    " + key, valueMap1);
                        } else {
                            map.put("  " + "-" + " " + key, valueMap1);
                        }

                    } else {
                        map.put("  " + "-" + " " + key, valueMap1);
                        map.put("  " + "+" + " " + key, valueMap2);
                    }
                    listMap2.add(map);
                }

                if (newMap1.containsKey(key) & (!newMap2.containsKey(key))) {
                    Map<String, Object> map = new HashMap<>();
                    Object valueMap1 = newMap1.get(key);
                    map.put("  " + "-" + " " + key, valueMap1);
                    listMap2.add(map);
                }

                if (newMap2.containsKey(key) & (!newMap1.containsKey(key))) {
                    Map<String, Object> map = new HashMap<>();
                    Object valueMap2 = newMap2.get(key);
                    map.put("  " + "+" + " " + key, valueMap2);
                    listMap2.add(map);
                }
                if (newMap1.containsKey(key) & (newMap2.containsKey(key))) {
                    Object valueMap1 = newMap1.get(key);
                    Object valueMap2 = newMap2.get(key);
                    Map<String, Object> map = new HashMap<>();
                    if (valueMap1 != null) {
                        if (!valueMap1.equals(valueMap2)) {
                            map.put("  " + "+" + " " + key, valueMap2);
                            listMap2.add(map);
                        }
                    }
                }
            }

        }
        return toString(listMap2);
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


