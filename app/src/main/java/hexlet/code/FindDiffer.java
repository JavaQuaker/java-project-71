package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.LinkedHashMap;

public class FindDiffer {
        public static void main(String[] args) throws IOException {
        String file1 = "app/src/test/resources/jsonFile_1.json";
        String file2 = "app/src/test/resources/jsonFile_2.json";
//            String file1 = "app/src/test/resources/Test_1yaml.yml";
//            String file2 = "app/src/test/resources/Test_yaml_2.yml";
        System.out.println(Differ.generate(file1, file2, "stylish"));
//            System.out.println(Differ.content(file1));

    }
    public static List<Map<String, Object>> diffGenerate(
            Map<String, Object> filePathOne, Map<String, Object> filePathTwo) throws IOException {
        List<Map<String, Object>> treeOfDifference = new ArrayList<>();

        TreeSet<String> treeSet = new TreeSet<>(filePathOne.keySet());
        treeSet.addAll(filePathTwo.keySet());
        treeOfDifference.clear();

        for (String key : treeSet) {
            Map<String, Object> map = new LinkedHashMap<>();
            Object value1 = filePathOne.get(key);
            Object value2 = filePathTwo.get(key);
            map.put("key", key);

            if (!filePathTwo.containsKey(key)) {
                map.put("type", "deleted");
                map.put("value", value1);
            } else if (!filePathOne.containsKey(key)) {
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
            treeOfDifference.add(map);
        }

        return treeOfDifference;
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
}

