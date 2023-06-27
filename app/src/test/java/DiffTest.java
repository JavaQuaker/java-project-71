

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
    String resultJsonTest;
    String resultYamlTest;


    @Test
        public void testDifferJson() throws IOException {
        file1 = "src/test/resources/jsonFile_1.json";
        file2 = "src/test/resources/jsonFile_2.json";
        resultJsonTest = Files.readString(Paths.get("src/test/resources/Test.txt"));
        String expected = "{" + "\n" + Differ.generate(file1, file2) + "}";
        assertThat(resultJsonTest).isEqualTo(expected);
    }

    @Test
    public void testDifferYaml() throws IOException {
        file3 = "src/test/resources/Test_1yaml.yaml";
        file4 = "src/test/resources/Test_yaml_2.yaml";
        resultYamlTest = Files.readString(Paths.get("src/test/resources/Test_yaml.txt"));
        String expected = "{" + "\n" + Differ.generate(file3, file4) + "}";
        assertThat(resultYamlTest).isEqualTo(expected);
    }
}

