package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static Path expected1;
    private static Path expected2;
    private static Path expected3;
    private static String expectedResults1;
    private static String expectedResults2;
    private static String expectedResults3;



    private static Path getPath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }
    @BeforeAll
    static void definePath() throws Exception {
        expected1 = Paths.get("src", "test", "resources", "fixtures", "resultStylish.txt");
        expected2 = Paths.get("src", "test", "resources", "fixtures", "resultPlain.txt");
        expected3 = Paths.get("src", "test", "resources", "fixtures", "resultJson.txt");
        expectedResults1 = Files.readString(expected1);
        expectedResults2 = Files.readString(expected2);
        expectedResults3 = Files.readString(expected3);

    }
    @Test
    void testDifferGenerate1() throws Exception {
        String file1 = getPath("file1.json").toString();
        String file2 = getPath("file2.json").toString();
        String result1 = Differ.generate(file1, file2);
        assertEquals(expectedResults1, result1);

        String result2 = Differ.generate(file1, file2, "stylish");
        assertEquals(expectedResults1, result2);

        String result3 = Differ.generate(file1, file2, "plain");
        assertEquals(expectedResults2, result3);

        String result4 = Differ.generate(file1, file2, "json");
        assertEquals(expectedResults3, result4);

    }

    @Test
    void testDifferGenerate2() throws Exception {
        String file3 = getPath("file1.yml").toString();
        String file4 = getPath("file2.yml").toString();
        String result1 = Differ.generate(file3, file4);
        assertEquals(expectedResults1, result1);

        String result2 = Differ.generate(file3, file4, "stylish");
        assertEquals(expectedResults1, result2);

        String result3 = Differ.generate(file3, file4, "plain");
        assertEquals(expectedResults2, result3);

        String result4 = Differ.generate(file3, file4, "json");
        assertEquals(expectedResults3, result4);
    }
}
