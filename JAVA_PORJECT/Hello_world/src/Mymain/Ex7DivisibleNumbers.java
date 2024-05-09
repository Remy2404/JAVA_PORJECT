package Mymain;

public class Ex7DivisibleNumbers {
    public static void main(String[] args) {
        int count = 0;  // Count the numbers printed
        for (int num = 100; num <= 200; num++) {
            // Check if divisible by 5 or 6, but not both
            if ((num % 5 == 0 || num % 6 == 0) && !(num % 5 == 0 && num % 6 == 0)) {
                if (count % 10 == 0) {  // Start a new line after every 10 numbers
                    System.out.println();
                }
                System.out.print(num + " ");  // Print the number with a space
                count++;// Increment the count
            }
        }
    }
}
