package hexlet.code;

//import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static Path getPath(String fileName) {
        return Paths.get("src", "main", "resources", fileName)
                .toAbsolutePath().normalize();
    }

//    private static String readPath(String fileName) throws Exception {
//        Path filePath = getPath(fileName);
//        return Files.readString(filePath).trim();
//    }
}
