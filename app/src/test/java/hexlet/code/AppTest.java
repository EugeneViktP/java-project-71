package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import static org.assertj.core.api.Assertions.assertThat;
//import static hexlet.code.Differ.diffBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private static Path getPath(String fileName) {
//        return Paths.get("src", "test", "resources", "fixtures", fileName)
        return Paths.get(fileName)
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
    void testDifferGenerate1() throws Exception {
        String result1 = Differ.generate("file1.json", "file2.json", "stylish");
        Path expected1 = AppTest.getPath("jsonStylish.txt");
        String expectedResults = Files.readString(expected1);
        assertEquals(result1, expectedResults);
    }

    @Test
    void testDifferGenerate2() throws Exception {
        String result1 = Differ.generate("file1.yml", "file2.yml", "stylish");
        Path expected1 = AppTest.getPath("ymlStylish.txt");
        String expectedResults = Files.readString(expected1);
        assertEquals(result1, expectedResults);
    }

    @Test
    void testDifferGenerate3() throws Exception {
        String result1 = Differ.generate("file3.yml", "file4.yml", "stylish");
        Path expected1 = AppTest.getPath("ymlNestedStylish.txt");
        String expectedResults = Files.readString(expected1);
        assertEquals(result1, expectedResults);
    }

    @Test
    void testDifferGenerate4() throws Exception {
        String result1 = Differ.generate("file3.yml", "file4.yml", "plain");
        Path expected1 = AppTest.getPath("ymlNestePlain.txt");
        String expectedResults = Files.readString(expected1);
        assertEquals(result1, expectedResults);
    }

    @Test
    void testDifferGenerate5() throws Exception {
        String result1 = Differ.generate("file1.json", "file2.json", "json");
        Path expected1 = AppTest.getPath("formatJson.txt");
        String expectedResults = Files.readString(expected1);
        assertEquals(result1, expectedResults);
    }


}
