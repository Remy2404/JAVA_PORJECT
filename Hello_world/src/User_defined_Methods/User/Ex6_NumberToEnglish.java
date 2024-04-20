package User_defined_Methods.User;
import java.util.Scanner;

public class Ex6_NumberToEnglish {

    private static final String[] reay = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String[] teens = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static String verbose(int number) {
        if (number == 0) {
            return "zero";
        }
        if (number < 10) {
            return reay[number];
        } else if (number < 20) {
            return teens[number - 10];
        } else if (number < 100) {
            return tens[number / 10] + " " + reay[number % 10];
        } else if (number < 1000) {
            return reay[number / 100] + " hundred " + verbose(number % 100);
        } else if (number < 1000000) {
            return verbose(number / 1000) + " thousand " + verbose(number % 1000);
        } else if (number < 1000000000) {
            return verbose(number / 1000000) + " million " + verbose(number % 1000000);
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number less than 10^9: ");
        int number = scan.nextInt();

        if (number >= 0 && number < 1000000000) {
            System.out.println("Number in words: " + verbose(number));
        } else {
            System.out.println("Number must be less than 10^9.");
        }

        scan.close();
    }
}