
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import hexlet.code.Differ;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/* "host": "hexlet.io",
  "timeout": 50,
  "proxy": "123.234.53.22",
  "follow": false,
  "test": 50
*/

/*      "timeout": 20,
        "verbose": true,
        "host": "hexlet.io"
*/
public class DiffTest {
    String filePath1;
    String filePath2;
    String formatName;
    String result;
    @BeforeEach
   public void beforeEach() throws IOException {
        filePath1 = "src/test/resources/jsonFile_1.json";
        filePath2 = "src/test/resources/jsonFile_2.json";
//        File jsonFile1 = new File("src/test/resources/jsonFile_1.json");
//        File jsonFile2 = new File("src/test/resources/jsonFile_2.json");
//
//        File yamlFile1 = new File("src/test/resources/Test_1yaml.yml");
//        File yamlFile2 = new File("src/test/resources/Test_yaml_2.yml");

    }
    @Test
        public void testDiffer() throws IOException {
        result = Files.readString(Paths.get("src/test/resources/Test.txt"));
        String expected = "{" + "\n" + Differ.generate(filePath1, filePath2) + "}";
        assertThat(result).isEqualTo(expected);
    }
//    @Test
//    public void testParser() throws IOException {
//        result = Files.readString(Paths.get("src/test/resources/Test_yaml.txt"));
//        String expected = "{" + "\n" + Parser.compareYamlFile(file3, file4) + "}";
//        assertThat(result).isEqualTo(expected);
//    }

//    @Test
//    public void testAttachFile() throws IOException {
//        result = Files.readString(Paths.get("src/test/resources/testAttachFileResult.txt"));
//        String expected = "{" + "\n" + Differ.generate(file1, file2) + "}";
//        assertThat(result).isEqualTo(expected);
//    }
}

