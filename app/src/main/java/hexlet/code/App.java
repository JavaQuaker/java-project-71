package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App  implements Runnable {
    @CommandLine.Parameters(index = "0", description = "path to first file")
    private File filepath1;
    @CommandLine.Parameters(index = "1", description = "path to second file")
    private File filepath2;
    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String algorithm;
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public void run() {

    }
    static File resultFile1 = new File("app/src/test/resources/Test_1.txt");
    static File resultFile2 = new File("app/src/test/resources/Test_2.txt");
    static List<Map<String, Object>> listMap = new ArrayList<>();
}
