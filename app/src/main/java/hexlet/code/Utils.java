package hexlet.code;
//import java.nio.file.Files;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {

    public static Path getPath(String fileName) {
//        return Paths.get("src", "test", "resources", "fixtures", fileName)
        return Paths.get(fileName)
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

    public static File createInToParse(String filepath) {
        Path pathOne = Utils.getPath(filepath);
        File fileIn = new File(String.valueOf(pathOne));
        return fileIn;
    }
}
