package techi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pact {

    public static int getTotalLines(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int totalLines = 0;
            while (reader.readLine() != null) {
                totalLines++;
            }
            return totalLines;
        }
    }

    public static int getLinesOfCode(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int linesOfCode = 0;
            String line;
            boolean inCommentBlock = false;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                
                if (line.isEmpty()) {
                    continue;
                }

                
                if (line.startsWith("//")) {
                    continue;
                }

              
                if (line.startsWith("/*")) {
                    inCommentBlock = true;
                    continue;
                }

              
                if (line.endsWith("*/")) {
                    inCommentBlock = false;
                    continue;
                }

                
                if (inCommentBlock) {
                    continue;
                }

                linesOfCode++;
            }
            return linesOfCode;
        }
    }

    public static void main(String[] args) {
        try {
            String filePath = "src/techi/Name.java";

            int totalLines = getTotalLines(filePath);
            int linesOfCode = getLinesOfCode(filePath);

            System.out.println("Total Lines: " + totalLines);
            System.out.println("Lines of Code: " + linesOfCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
