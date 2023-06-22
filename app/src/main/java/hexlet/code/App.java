package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.concurrent.Callable;

import static hexlet.code.Differ.resultFormat;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App  implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "path to first file")
    private File filepath1;
    @CommandLine.Parameters(index = "1", description = "path to second file")
    private File filepath2;
    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String algorithm;
    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() {

        try {
            String formattedDiff = Differ.generate(filepath1, filepath2, resultFormat);
            System.out.println(formattedDiff);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }

        return SUCCESS_EXIT_CODE;
    }
}
