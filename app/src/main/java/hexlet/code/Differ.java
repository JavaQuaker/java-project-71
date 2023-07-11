package hexlet.code;
import java.io.IOException;


import java.util.Map;


public class Differ {
    public static Map<String, Object> fileOne;
    public static Map<String, Object> fileTwo;
    public static String generate(String filePath1, String filePath2, String formatName) throws IOException {

        fileOne = Parser.parse(filePath1);
        fileTwo = Parser.parse(filePath2);
        return Formatter.formatting(FindDiffer.diffGenerate(fileOne, fileTwo), formatName);
    }
    public static String generate(String filePath1, String filePath2) throws IOException {
        return Formatter.formatting(FindDiffer.diffGenerate(fileOne, fileTwo), "stylish");
    }

}

