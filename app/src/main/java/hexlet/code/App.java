package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;


import java.util.concurrent.Callable;




@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App  implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1", description = "path to second file")
    private String filepath2;
//    @CommandLine.Parameters(index = "2", description = "formatter")
//    private File formatName;
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
            String formattedDiff = Differ.generate(filepath1, filepath2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }
        return SUCCESS_EXIT_CODE;
    }
}
