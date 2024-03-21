
import java.util.Scanner;

public class EX_10_Number_to_English {


    private static final String[] ONES = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] TEENS = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static final String[] TENS = {
        "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter an integer (0-999): ");
            int number = scanner.nextInt();

            if (number < 0 || number > 999) {
                System.out.println("Invalid input. Number must be within [0, 999].");
            } else {
                System.out.println(convertNumberToWords(number));
            }
        }
    }
    private static String convertNumberToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        StringBuilder result = new StringBuilder();

        if (number >= 100) {
            result.append(ONES[number / 100]).append(" hundred ");
            number %= 100;
        }

        if (number >= 20) {
            result.append(TENS[number / 10]).append(" ");
            number %= 10;
        }

        if (number >= 10) {
            result.append(TEENS[number - 10]).append(" "); 
        } else if (number > 0) {
            result.append(ONES[number]).append(" ");
        }

        return result.toString().trim();
    }

}
