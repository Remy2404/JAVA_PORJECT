package Chapter_7_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class EX7_generateEmirp {

    // Method to generate a list of emirp numbers up to n
    public static ArrayList<Integer> generateEmirp(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isEmirp(i)) {
                list.add(i);
            }
        }
        return list;
    }

    // Method to check if a number is an emirp
    public static boolean isEmirp(int num) {
        int reversedNum = reverseNumber(num);

        return num != reversedNum && isPrime(num) && isPrime(reversedNum);
    }

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method to reverse a number
    public static int reverseNumber(int num) {
        int reversedNum = 0;
        while (num != 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        return reversedNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();

        ArrayList<Integer> list = generateEmirp(n);
        System.out.println("Emirp numbers: " + list);
    }
}
