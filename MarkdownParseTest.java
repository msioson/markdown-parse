import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("./test-file2.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile3() throws IOException {
        String contents= Files.readString(Path.of("./test-file3.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile4() throws IOException {
        String contents= Files.readString(Path.of("./test-file4.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile5() throws IOException {
        String contents= Files.readString(Path.of("./test-file5.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile6() throws IOException {
        String contents= Files.readString(Path.of("./test-file6.md"));
        List<String> expect = List.of("page.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile7() throws IOException {
        String contents= Files.readString(Path.of("./test-file7.md"));
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile8() throws IOException {
        String contents= Files.readString(Path.of("./test-file8.md"));
        List<String> expect = List.of("a link on the first line");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    } 

    @Test
    public void testMyLinkFile() throws IOException {
        String contents= Files.readString(Path.of("./my-link-file.md"));
        List<String> expect = List.of("another-some-page.html", "test-this-link/something-(2022).html", "test-this-link/something-(2022).html", "[([]()[]())[][][]([][]())()()]", "");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    } 
}
