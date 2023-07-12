package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;


import java.util.concurrent.Callable;




@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public final class App  implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "path to first file")
    private String filepathOne;
    @CommandLine.Parameters(index = "1", description = "path to second file")
    private String filepathTwo;

    @CommandLine.Option(names = {"-f", "--format"}, defaultValue = "stylish",
            description = "output format [default: stylish]")
    private String formatName;
    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public Integer call() {

        try {
            System.out.println(Differ.generate(filepathOne, filepathTwo, formatName));

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }
        return SUCCESS_EXIT_CODE;
    }
}
