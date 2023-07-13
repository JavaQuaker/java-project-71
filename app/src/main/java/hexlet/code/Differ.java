package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

public class Differ {
    public static String readingFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }
    public static String generate(String filePathFirst, String filePathSecond, String formatName) throws IOException {

        Map<String, Object> fileOne = new LinkedHashMap<>(Parser.parsingToString(Differ.readingFile(filePathFirst),
                lookingForAnExtension(filePathFirst)));

        Map<String, Object> fileTwo = new LinkedHashMap<>(Parser.parsingToString(Differ.readingFile(filePathSecond),
                lookingForAnExtension(filePathSecond)));

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
