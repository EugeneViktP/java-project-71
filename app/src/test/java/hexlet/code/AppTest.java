package hexlet.code;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testMain() throws Exception {
        String[] args = new String[]{"-h"};
        int helpLine = new CommandLine(new App()).execute(args);
        int expectedResults1 = 0;
        assertEquals(helpLine, expectedResults1);
    }
}
