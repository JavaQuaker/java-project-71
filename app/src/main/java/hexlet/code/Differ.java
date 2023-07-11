package hexlet.code;
import java.io.IOException;


import java.util.LinkedHashMap;
import java.util.Map;


public class Differ {

    public static String generate(String filePath1, String filePath2, String formatName) throws IOException {

        Map<String, Object> fileOne = new LinkedHashMap<>(Parser.parse(filePath1));
        Map<String, Object> fileTwo = new LinkedHashMap<>(Parser.parse(filePath2));
        return Formatter.formatting(FindDiffer.diffGenerate(fileOne, fileTwo), formatName);
    }
    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

}

