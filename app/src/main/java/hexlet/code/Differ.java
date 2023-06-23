package hexlet.code;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.HashMap;


public class Differ {
    static File file;
    static File file2;


    static Map<String, Object> map1;
    static Map<String, Object> map2;
    static List<Map<String, Object>> listMap = new ArrayList<>();

    public static List<Map<String, Object>> generate(String filePath1, String filePath2) throws IOException {

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
        System.out.println(newMap1);
        System.out.println(newMap2);

        TreeSet<String> treeSet = new TreeSet<>(newMap1.keySet());
        treeSet.addAll(newMap2.keySet());
        System.out.println(treeSet);

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
                listMap.add(map);
            }

            if (newMap1.containsKey(key) & (!newMap2.containsKey(key))) {
                Map<String, Object> map = new HashMap<>();
                Object valueMap1 = newMap1.get(key);
                map.put("  " + "-" + " " + key, valueMap1);
                listMap.add(map);
            }

            if (newMap2.containsKey(key) & (!newMap1.containsKey(key))) {
                Map<String, Object> map = new HashMap<>();
                Object valueMap2 = newMap2.get(key);
                map.put("  " + "+" + " " + key, valueMap2);
                listMap.add(map);
            }
            if (newMap1.containsKey(key) & (newMap2.containsKey(key))) {
                Object valueMap1 = newMap1.get(key);
                Object valueMap2 = newMap2.get(key);
                Map<String, Object> map = new HashMap<>();
                if (valueMap1 != null) {
                    if (!valueMap1.equals(valueMap2)) {
                        map.put("  " + "+" + " " + key, valueMap2);
                        listMap.add(map);
                    }
                }
            }
        }
        return listMap;
    }
}




