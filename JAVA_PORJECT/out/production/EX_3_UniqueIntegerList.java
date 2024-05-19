package Chapter_7_ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class EX_3_UniqueIntegerList {
    public static void main(String[] args) {
        // Create an ArrayList to store integers
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Read integers from the user until 0 is entered
        while (true) {
            System.out.print("Enter an integer (0 to stop): ");
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }

            // Add the number to the list if it's not already there
             else if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }

        // Close the scanner
        scanner.close();

        // Display the ArrayList without duplicates
        System.out.println("ArrayList without duplicates: " + numbers);
    }
}
