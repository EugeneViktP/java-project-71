package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private static String expectedResults1;
    private static String expectedResults2;
    public static Path expected1;
    public static Path expected2;

    private static Path getPath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }
    @BeforeAll
    static void definePath() throws Exception {
        expected1 = Paths.get("src", "test", "resources", "fixtures", "resultStylish.txt");
        expected2 = Paths.get("src", "test", "resources", "fixtures", "resultPlain.txt");
        expectedResults1 = Files.readString(expected1);
        expectedResults2 = Files.readString(expected2);

    }
    @Test
    void testDifferGenerate1() throws Exception {
        String file1 = getPath("file1.json").toString();
        String file2 = getPath("file2.json").toString();
        String result1 = Differ.generate(file1, file2);
//        Path expected1 = DifferTest.getPath("resultStylish.txt");
//        String expectedResults1 = Files.readString(expected1);
        assertEquals(expectedResults1, result1);

        String result2 = Differ.generate(file1, file2, "stylish");
//        Path expected2 = DifferTest.getPath("resultStylish.txt");
//        String expectedResults2 = Files.readString(expected2);
        assertEquals(expectedResults1, result2);

        String result3 = Differ.generate(file1, file2, "plain");
        Path expected3 = DifferTest.getPath("resultPlain.txt");
//        String expectedResults3 = Files.readString(expected3);
        assertEquals(expectedResults2, result3);

        String result4 = Differ.generate(file1, file2, "json");
        Path expected4 = DifferTest.getPath("resultJson.txt");
        String expectedResults4 = Files.readString(expected4);
        assertEquals(expectedResults4, result4);

    }

    @Test
    void testDifferGenerate2() throws Exception {
        String file3 = getPath("file1.yml").toString();
        String file4 = getPath("file2.yml").toString();
        String result1 = Differ.generate(file3, file4);
//        Path expected1 = DifferTest.getPath("resultStylish.txt");
//        String expectedResults1 = Files.readString(expected1);
        assertEquals(expectedResults1, result1);

        String result2 = Differ.generate(file3, file4, "stylish");
//        Path expected2 = DifferTest.getPath("resultStylish.txt");
//        String expectedResults2 = Files.readString(expected2);
        assertEquals(expectedResults1, result2);

        String result3 = Differ.generate(file3, file4, "plain");
        Path expected3 = DifferTest.getPath("resultPlain.txt");
        String expectedResults3 = Files.readString(expected3);
        assertEquals(result3, expectedResults3);

        String result4 = Differ.generate(file3, file4, "json");
        Path expected4 = DifferTest.getPath("resultJson.txt");
        String expectedResults4 = Files.readString(expected4);
        assertEquals(result4, expectedResults4);
    }
}
