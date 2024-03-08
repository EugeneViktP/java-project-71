package hexlet.code;
//import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static Path getPath(String fileName) {
        return Paths.get("src", "main", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    public static String getFileExtension(String filename) throws Exception {
        String fileExtension = "";
        int index = filename.lastIndexOf('.');
        if (index > 0) {
            fileExtension = filename.substring(index + 1);
        }
        return fileExtension;
    }
}
