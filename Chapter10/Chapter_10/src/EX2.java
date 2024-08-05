package Chapter10.Chapter_10.src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EX2 {
    public static void main(String[] args) {
        File file = new File("Chapter10\\Chapter_10\\input_EX2.txt"); 
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.replaceAll("\\s", "").length();
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getLocalizedMessage());
            return;
        }

        System.out.println("File: " + file);
        System.out.println("Characters (excluding whitespace): " + charCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Lines: " + lineCount);
    }
}