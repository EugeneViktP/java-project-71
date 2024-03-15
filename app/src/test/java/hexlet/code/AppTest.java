package hexlet.code;

//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.assertj.core.api.Assertions.assertThat;
//import static hexlet.code.Differ.diffBuilder;
//import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

//    private static Path getPath(String fileName) {
//        return Paths.get("src", "test", "resources", "fixtures", fileName)
////        return Paths.get(fileName)
//                .toAbsolutePath().normalize();
//    }

//    private static String readPath(String fileName) throws Exception {
//        Path filePath = getPath(fileName);
//        return Files.readString(filePath).trim();
//    }

//    @BeforeAll
//    public static void beforeAll() throws Exception {
//        data1 = readPath("file1.json");
//        data2 = readPath("file2.json");
//    }

//    @BeforeAll
//    public static void beforeAll() throws Exception {
//        Path data1 = AppTest.getPath("file1.json");
//        Path data2 = AppTest.getPath("file2.json");
//    }

    @Test
    void testMain() throws Exception {
        String[] args = new String[]{"-h"};
        int helpLine = new CommandLine(new App()).execute(args);
        int expectedResults1 = 0;
        assertEquals(helpLine, expectedResults1);
    }
}
