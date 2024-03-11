package chatper_3_Single_dim;

import java.util.Scanner;

public class Ex10_numbertoEnglish {
     //Final mean : the value can't be changed (shared by all obj of this class)
    private static final String[] ONES = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] TEENS = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };
// main method
    public static void main(String[] args) {
        // create an obj of Scanner class
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer (0-999): ");
        int number = scanner.nextInt();
// check if the enterd number is within the valid range of 0 to 999
        if (number < 0 || number > 999) {
            System.out.println("Invalid input. Number must be within [0, 999].");
        } else {
            System.out.println(convertNumberToWords(number));
        }

        scanner.close();
    }

    private static String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        }
//Creates a StringBuilder object to efficiently build the English word representation string.
        StringBuilder result = new StringBuilder();

        if (number >= 100) {
            result.append(ONES[number / 100]).append(" hundred ");
            number %= 100;
        }
        if (number >= 20) {
            result.append(TENS[number / 10]).append(" ");
            number %= 10;
        }

        if (number >= 10 && number <= 19) {
            result.append(TEENS[number - 10]).append(" "); 
        } else if (number > 0) {
            result.append(ONES[number]).append(" ");
        }

        return result.toString().trim();
}
}// key points : 
/*
 * Example: The user enters the number 456.
Check: The if condition is true because 456 is greater than 100.
Word Lookup: ONES[456 / 100] gives us "four", which is appended to the result.
Append "hundred": The text " hundred " is added to the result.
Remainder: 456 % 100 leaves 56, which is assigned back to the number variable
Next Steps: The remaining code blocks will subsequently handle the 56 to convert "fifty-six".
 */
  