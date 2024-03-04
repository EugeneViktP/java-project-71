package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
//import picocli.CommandLine;
import picocli.CommandLine.Option;
//import picocli.CommandLine.Parameters;

//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Files;
import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;
    @Option(names = {"-f", "--format"}, paramLabel = "format", description = "output format [default: stylish]")
    private String format;


    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Override
    public Integer call() throws Exception {
        Path pathOne = Utils.getPath(filepath1);
        Path pathTwo = Utils.getPath(filepath2);
        var differ = Differ.generate(pathOne, pathTwo);
        System.out.println(differ);
        return 0;
    }
}
