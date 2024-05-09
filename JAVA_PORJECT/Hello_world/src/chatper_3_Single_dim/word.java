package chatper_3_Single_dim;
import java.util.Scanner;

public class word {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        String longestWord = "";
        int currentWordLength = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);

            // Check if current character is an alphabet
            if (Character.isAlphabetic(ch)) {
                currentWordLength++;
            } else {
                // Update longest word if current word is longer
                if (currentWordLength > longestWord.length()) {
                    longestWord = sentence.substring(i - currentWordLength, i);
                }
                currentWordLength = 0;
            }
        }

        // Check for the last word
        if (currentWordLength > longestWord.length()) {
            longestWord = sentence.substring(sentence.length() - currentWordLength);
        }
        //Remove special the character : ? , ! and @
        longestWord = longestWord.replaceAll("[?!,@]", "");
        longestWord = longestWord.replaceAll(" ", "");  
        longestWord = longestWord.toLowerCase();
        longestWord = longestWord.replaceAll("[aeiou]", "");

        System.out.println("The longest word is: " + longestWord);
        scanner.close();
    }
    
}