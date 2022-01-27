
import static org.junit.Assert.*;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(5 + 10, 15);
    }

    @Test
    public void testMarkDownParseTestFile() throws IOException {
        Path fileName = Path.of("D:/markdown-parse/newMarkDownParse/test-file.md");
        String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), List.of("https://something.com", "some-page.html"));
    }

}