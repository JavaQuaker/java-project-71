

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import hexlet.code.Differ;


import java.nio.file.Paths;

import java.io.IOException;
import java.nio.file.Files;

public class DiffTest {
    String file1;
    String file2;
    String file3;
    String file4;
    String file5;
    String file6;
    String file7;
    String file8;
    String file9;
    String file10;
    String file11;
    String file12;
    String resultJsonTest;
    String resultYamlTest;

    String formatName;

    @Test
    public void testDifferJsonStylish() throws IOException {
        file1 = "src/test/resources/jsonFile_1.json";
        file2 = "src/test/resources/jsonFile_2.json";
        formatName = "stylish";
        resultJsonTest = Files.readString(Paths.get("src/test/resources/Test.txt"));
        String expected1 = /*"{" + "\n" + */Differ.generate(file1, file2, formatName) /*+ "}"*/;
        assertThat(resultJsonTest).isEqualTo(expected1);
    }
    @Test
    public void testDifferJsonPlain() throws IOException {
        file3 = "src/test/resources/jsonFile_1.json";
        file4 = "src/test/resources/jsonFile_2.json";
        formatName = "plain";
        resultJsonTest = Files.readString(Paths.get("src/test/resources/TestJsonPlain.txt"));
        String expected1 = /*"{" + "\n" + */Differ.generate(file3, file4, formatName) /*+ "}"*/;
        assertThat(resultJsonTest).isEqualTo(expected1);
    }
    @Test
    public void testDifferJsonJson() throws IOException {
        file5 = "src/test/resources/jsonFile_1.json";
        file6 = "src/test/resources/jsonFile_2.json";
        formatName = "json";
        resultJsonTest = Files.readString(Paths.get("src/test/resources/TestJsonJson.txt"));
        String expected1 = /*"{" + "\n" + */Differ.generate(file5, file6, formatName) /*+ "}"*/;
        assertThat(resultJsonTest).isEqualTo(expected1);
    }

//    @Test
//    public void testDifferJsonDefault() throws IOException {
//        file1 = "src/test/resources/jsonFile_1.json";
//        file2 = "src/test/resources/jsonFile_2.json";
//
//        resultJsonTest = Files.readString(Paths.get("src/test/resources/TestJsonJson.txt"));
//        String expected1 = /*"{" + "\n" + */Differ.generate(file1, file2) /*+ "}"*/;
//        assertThat(resultJsonTest).isEqualTo(expected1);
//    }

    @Test
    public void testDifferYamlStylish() throws IOException {
        file7 = "src/test/resources/Test_1yaml.yml";
        file8 = "src/test/resources/Test_yaml_2.yml";
        formatName = "stylish";
        resultYamlTest = Files.readString(Paths.get("src/test/resources/Test_yaml.txt"));
        String expected2 = /*"{" + "\n" + */Differ.generate(file7, file8, formatName)/* + "}"*/;
        assertThat(resultYamlTest).isEqualTo(expected2);
    }
    @Test
    public void testDifferYamlPlain() throws IOException {
        file9 = "src/test/resources/Test_1yaml.yml";
        file10 = "src/test/resources/Test_yaml_2.yml";
        formatName = "plain";
        resultYamlTest = Files.readString(Paths.get("src/test/resources/TestYamlPlain.txt"));
        String expected2 = /*"{" + "\n" + */Differ.generate(file9, file10, formatName)/* + "}"*/;
        assertThat(resultYamlTest).isEqualTo(expected2);
    }
    @Test
    public void testDifferYamlJson() throws IOException {
        file11 = "src/test/resources/Test_1yaml.yml";
        file12 = "src/test/resources/Test_yaml_2.yml";
        formatName = "json";
        resultYamlTest = Files.readString(Paths.get("src/test/resources/TestYamlJson.txt"));
        String expected2 = /*"{" + "\n" + */Differ.generate(file11, file12, formatName)/* + "}"*/;
        assertThat(resultYamlTest).isEqualTo(expected2);
    }
}


