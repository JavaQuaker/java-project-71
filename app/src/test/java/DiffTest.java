

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
    String resultJsonTest;
    String resultYamlTest;
    String resultYamlNested;
    String formatName;


//    @Test
//    public void testDifferJson() throws IOException {
//        file1 = "src/test/resources/jsonFile_1.json";
//        file2 = "src/test/resources/jsonFile_2.json";
//        formatName = "yml";
//        resultJsonTest = Files.readString(Paths.get("src/test/resources/Test.txt"));
//        String expected1 = "{" + "\n" + Differ.generate(file1, file2, formatName) + "}";
//        assertThat(resultJsonTest).isEqualTo(expected1);
//    }


    //    @Test
//    public void testDifferYaml() throws IOException {
//        file3 = "src/test/resources/Test_1yaml.yml";
//        file4 = "src/test/resources/Test_yaml_2.yml";
//        formatName = "yml";
//        resultYamlTest = Files.readString(Paths.get("src/test/resources/Test_yaml.txt"));
//        String expected2 = "{" + "\n" + Differ.generate(file3, file4, formatName) + "}";
//        assertThat(resultYamlTest).isEqualTo(expected2);
//    }
    @Test
    public void testDifferYamlNested() throws IOException {
        file5 = "src/test/resources/testAttachFile_1.yml";
        file6 = "src/test/resources/testAttachFile_2.yml";
        formatName = "stylish";
        resultYamlNested = Files.readString(Paths.get("src/test/resources/testAttachFileResult.txt"));
        String expected3 = "{" + "\n" + Differ.generate(file5, file6, formatName) + "}";
        assertThat(resultYamlNested).isEqualTo(expected3);
    }
}


