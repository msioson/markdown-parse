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
        int currentIndex, bracketCount, parenthesesCount, closeParen, openParen, openBracket, closeBracket;
        currentIndex = bracketCount = parenthesesCount = closeParen = openParen = openBracket = closeBracket = 0;
        boolean preexistingBrackets = false;

        while(currentIndex < markdown.length()) {
            if(markdown.charAt(currentIndex) == '[') {
                //Make sure the brackets and parentheses are balanced
                if((bracketCount == 0) && (parenthesesCount == 0))
                    openBracket = currentIndex;
                bracketCount++;
            }
            if(markdown.charAt(currentIndex) == ']') {
                bracketCount--;
                if((bracketCount == 0) && (parenthesesCount == 0)){
                    closeBracket = currentIndex;
                    preexistingBrackets = true;
                }
            }
            if((markdown.charAt(currentIndex) == '(')) {
                if((parenthesesCount == 0) && (bracketCount == 0))
                    openParen = currentIndex;
                parenthesesCount++;
            }
            if((markdown.charAt(currentIndex) == ')')) {
                parenthesesCount--;
                if((parenthesesCount == 0) && (bracketCount == 0)) {
                    closeParen = currentIndex;
                    // Makes sure that there are brackets before the set of parentheses
                    if(closeBracket + 1 != openParen)
                        preexistingBrackets = false;
                    if(preexistingBrackets) {
                        toReturn.add(markdown.substring(openParen + 1, closeParen));
                        preexistingBrackets = false;
                    }
                }   
            }
            currentIndex++;
            /*
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;*/
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}