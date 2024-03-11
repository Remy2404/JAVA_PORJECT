package Mymain;
import java.util.Scanner;

public class Ex10SentenceAnalysis {

    public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();

        int words = 0;
        int consonants = 0;
        int vowels = 0;
        int digits = 0;
        int specialChars = 0;

        sentence = sentence.toLowerCase(); // Convert to lowercase for easier checking

        for (char ch : sentence.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isWhitespace(ch)) {
                // Ignore spaces
            } else {
                specialChars++;
            }

            if (Character.isWhitespace(ch) || ch == '.') {
                words++;
            }
        }

        System.out.println("Words: " + words);
        System.out.println("Consonants: " + consonants);
        System.out.println("Vowels: " + vowels);
        System.out.println("Digits: " + digits);
        System.out.println("Special characters: " + specialChars);
    }
    }
    /* **key point :**

2. **`toLowerCase()` method:**
   - This method is called on the sentence string.
   - It converts all characters in the string to lowercase.
   - It's used to make character checking case-insensitive.

3. **`toCharArray()` method:**
   - This method is called on the sentence string.
   - It converts the string into an array of characters.
   - This allows the `for` loop to iterate through each character individually.

4. **`isLetter(ch)` method:**
   - This method is used within the loop to check if a character is a letter.
   - It's part of the `Character` class, not defined explicitly.

5. **`indexOf(ch)` method:**
   - This method is used to check if a character is a vowel.
   - It's called on the string "aeiou" to see if it contains the character.
   - It's not a custom method, but a method of the `String` class.

6. **`isDigit(ch)` method:**
   - This method is used within the loop to check if a character is a digit.
   - It's part of the `Character` class, not defined explicitly in your code.

7. **`isWhitespace(ch)` method:**
   - This method is used within the loop to check if a character is a whitespace character.
   - It's part of the `Character` class, not defined explicitly in your code.
    * */
}
