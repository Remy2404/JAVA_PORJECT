package Chapter_10_Exception_Handling;
import java.util.Scanner;

public class EX1 {
    public static void main() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter a number: ");
            int number = input.nextInt();
            if (isPalindrome(number)) {
                System.out.println(number + " is a palindrome");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            input.close();
        }
    }
    public static boolean isPalindrome(int number) throws Exception {
        String numberString = String.valueOf(number);
        for (int i = 0; i < numberString.length() / 2; i++) {
            if (numberString.charAt(i) != numberString.charAt(numberString.length() - 1 - i)) {
                throw new Exception(number + " is not a palindrome");
            }
        }
        return true;
    }

}
