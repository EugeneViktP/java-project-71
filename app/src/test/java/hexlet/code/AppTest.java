package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

//    private static Path data1;
//    private static Path data2;

    private static Path getPath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readPath(String fileName) throws Exception {
        Path filePath = getPath(fileName);
        return Files.readString(filePath).trim();
    }

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
    void testDifferGenerate() throws Exception {
        String result1 = Differ.generate("file1.json", "file2.json");
        System.out.println(result1);
        Path expected1 = AppTest.getPath("jsonCompRes.txt");
        String expRes = Files.readString(expected1);
        System.out.println(expRes);
        assertEquals(result1, expRes);
    }

    @Test
    void testDifferGenerate2() throws Exception {
        String result1 = Differ.generate("file1.yml", "file2.yml");
        System.out.println(result1);
        Path expected1 = AppTest.getPath("ymlCompRes.txt");
        String expRes = Files.readString(expected1);
        System.out.println(expRes);
        assertEquals(result1, expRes);
    }
}
