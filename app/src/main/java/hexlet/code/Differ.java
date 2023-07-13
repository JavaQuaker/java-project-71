package hexlet.code;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;


public class Differ {
    public static String readFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws IOException {


        Map<String, Object> fileOne = new LinkedHashMap<>(Parser.parse(Differ.readFile(filePath1), formatName));


        Map<String, Object> fileTwo = new LinkedHashMap<>(Parser.parse(Differ.readFile(filePath2), formatName));



        return Formatter.formatting(FindDiffer.diffGenerate(fileOne, fileTwo), formatName);

    }
    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }
    public static String lookingForAnExtension(String filePath) {
        String[] extension = filePath.split("\\.");
        String resultSearchExtension = extension[extension.length - 1];
        return resultSearchExtension;
    }

}

