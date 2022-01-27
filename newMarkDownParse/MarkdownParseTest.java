import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(5 + 10, 15);
    }

    @Test
    public void MarkdownParse() {
        assertEquals(MarkdownParse.getLinks("test-file.md"), List.of("https://something.com", "some-page.html"));
    }

}