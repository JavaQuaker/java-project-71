package hexlet.code;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;


import java.util.LinkedHashMap;
import java.util.Map;


public class Differ {
    public static String content(String filePath) throws IOException {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws IOException {

        Map<String, Object> fileOne = new LinkedHashMap<>(Parser.parse(Differ.content(filePath1), formatName));
        Map<String, Object> fileTwo = new LinkedHashMap<>(Parser.parse(Differ.content(filePath2), formatName));
        return Formatter.formatting(FindDiffer.diffGenerate(fileOne, fileTwo), formatName);
    }
    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

}

