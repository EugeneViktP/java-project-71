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
        String file1 = getPath("file1.json").toString();
        String file2 = getPath("file2.json").toString();
        String result1 = Differ.generate(file1, file2);
        Path expected1 = DifferTest.getPath("resultStylish.txt");
        String expectedResults1 = Files.readString(expected1);
        assertEquals(result1, expectedResults1);

        String result2 = Differ.generate(file1, file2, "stylish");
        Path expected2 = DifferTest.getPath("resultStylish.txt");
        String expectedResults2 = Files.readString(expected2);
        assertEquals(result2, expectedResults2);

        String result3 = Differ.generate(file1, file2, "plain");
        Path expected3 = DifferTest.getPath("resultPlain.txt");
        String expectedResults3 = Files.readString(expected3);
        assertEquals(result3, expectedResults3);

        String result4 = Differ.generate(file1, file2, "json");
        Path expected4 = DifferTest.getPath("resultJson.txt");
        String expectedResults = Files.readString(expected4);
        assertEquals(result4, expectedResults);
    }

    @Test
    void testDifferGenerate2() throws Exception {
        String file3 = getPath("file1.yml").toString();
        String file4 = getPath("file2.yml").toString();
        String result1 = Differ.generate(file3, file4);
        Path expected1 = DifferTest.getPath("resultStylish.txt");
        String expectedResults1 = Files.readString(expected1);
        assertEquals(result1, expectedResults1);

        String result2 = Differ.generate(file3, file4, "stylish");
        Path expected2 = DifferTest.getPath("resultStylish.txt");
        String expectedResults2 = Files.readString(expected2);
        assertEquals(result2, expectedResults2);

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
