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
    File file1;
    File file2;

    
    @BeforeEach
   public void beforeEach() {
        file1 = new File("resources/Test_1.txt");
        file2 = new File("resources/Test_2.txt");

    }
        @Test
        public void Test1() throws IOException {

               String result = Files.readString(Paths.get("src/test/resources/AppTest.txt"));
                String expected = "{" + "\n" + Differ.generate(file1, file2) + "}";
                assertThat(result).isEqualTo(expected);
        }
    }

