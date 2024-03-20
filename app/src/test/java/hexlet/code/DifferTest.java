package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DifferTest {
    private static String expectedResults1;
    private static String expectedResults2;
    private static String expectedResults3;

    private static Path getPath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }
    @BeforeAll
    static void definePath() throws Exception {
        Path expected1 = getPath("resultStylish.txt");
        Path expected2 = getPath("resultPlain.txt");
        Path expected3 = getPath("resultJson.txt");
        expectedResults1 = Files.readString(expected1);
        expectedResults2 = Files.readString(expected2);
        expectedResults3 = Files.readString(expected3);
    }

    @ParameterizedTest
    @CsvSource({"file1.json, file2.json", "file1.yml, file2.yml"})
    void testDifferGenerate1(String firstFile, String secondFile) throws Exception {
        String file1 = getPath(firstFile).toString();
        String file2 = getPath(secondFile).toString();
        String result1 = Differ.generate(file1, file2);
        assertEquals(expectedResults1, result1);

        String result2 = Differ.generate(file1, file2, "stylish");
        assertEquals(expectedResults1, result2);

        String result3 = Differ.generate(file1, file2, "plain");
        assertEquals(expectedResults2, result3);

        String result4 = Differ.generate(file1, file2, "json");
        assertEquals(expectedResults3, result4);
    }
}
