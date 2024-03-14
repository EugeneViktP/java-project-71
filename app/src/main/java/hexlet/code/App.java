package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
//import picocli.CommandLine.Parameters;

//import java.nio.file.Path;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
    private String filepath2;
    @Option(names = {"-f", "--format"}, paramLabel = "format", defaultValue = "stylish",
            description = "output format [default: what is it ${DEFAULT-VALUE}]")
    private String format;


    public static void main(String[] args) {

        new CommandLine(new App()).execute(args);
    }

    @Override
    public Integer call() throws Exception {
//        default filepath
//        ./build/install/app/bin/app file3.yml file4.yml
//        ./build/install/app/bin/app -f plain file3.yml file4.yml
//        ./build/install/app/bin/app -f json file3.yml file4.yml
        var differ = Differ.generate(filepath1, filepath2, format);
        System.out.println(differ);
        return 0;
    }
}
