package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static Path getPath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }
    @Test
    void testDifferGenerate1() throws Exception {
        String result1 = Differ.generate("file1.json", "file2.json", "stylish");
        Path expected1 = DifferTest.getPath("jsonStylish.txt");
        String expectedResults = Files.readString(expected1);
        assertEquals(result1, expectedResults);
    }
    void testDifferGenerate2() throws Exception {
        String result1 = Differ.generate("file1.yml", "file2.yml", "stylish");
        Path expected1 = DifferTest.getPath("ymlStylish.txt");
        String expectedResults = Files.readString(expected1);
        assertEquals(result1, expectedResults);
    }
}
