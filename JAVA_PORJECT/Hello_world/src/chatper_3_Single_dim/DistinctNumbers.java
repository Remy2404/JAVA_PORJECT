package chatper_3_Single_dim;

import java.util.Scanner;

public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ten numbers separated by space: ");
        String input = scanner.nextLine();

        // Split the input string into an array of numbers
        String[] numbersStr = input.split(" ");

        // Convert the string numbers to integers
        int[] numbersInt = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            numbersInt[i] = Integer.parseInt(numbersStr[i]);
        }

        // Create an array to store distinct numbers
        int[] distinctNumbers = new int[numbersInt.length];
        int distinctCount = 0;

        // Iterate through the input numbers
        for (int num : numbersInt) {
            boolean found = false;

            // Check if the number is already in the distinct array
            for (int i = 0; i < distinctCount; i++) {
                if (num == distinctNumbers[i]) {
                    found = true;
                    break;
                }
            }

            // If not found, add it to the distinct array
            if (!found) {
                distinctNumbers[distinctCount++] = num;
            }
        }

        // Print the distinct numbers
        System.out.print("The distinct numbers are: ");
        for (int i = 0; i < distinctCount; i++) {
            System.out.print(distinctNumbers[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
