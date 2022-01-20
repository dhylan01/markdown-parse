
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        int currentIndexChanges = 1;
        while (currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (markdown.substring(openParen + 1, closeParen).contains(".")
                    && !markdown.substring(openParen + 1, closeParen).contains(" ")) {
                System.out.println("condition is working");
                System.out.println(currentIndex);
                toReturn.add(markdown.substring(openParen + 1, closeParen));

            }
            currentIndex = closeParen + 1;
            currentIndexChanges++;
        }

        System.out.println("Current index changes this many times: " + currentIndexChanges);
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}