import java.util.Scanner;
//------ Class ------//
public class Ex6CLass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//------ Input ------//
        int positiveCount = 0;
        int negativeCount = 0;
        int total = 0;
        int  number;
        int count = 0;

        System.out.println("Enter integers (enter 0 to end):");

        do {
            number = scanner.nextInt(); // user input from keyboard
//----------- set conditions  -----------//
            if (number > 0) {
                positiveCount++;
                total += number;
            } else if (number < 0) {
                negativeCount++;
                total += number;
            }

            if (number != 0) {
                count++; // count the number of numbers entered
            }

        } while (number != 0);// end of do while loop

        scanner.close();// close the scanner

        if (count == 0) {
            System.out.println("No numbers entered.");// if no numbers entered
        } else {
            double average = (double) total / count;// calculate the average using the total and count variables
//---------------- print results ----------------//
            System.out.println("Total positive numbers: " + positiveCount);
            System.out.println("Total negative numbers: " + negativeCount);
            System.out.println("Total: " + total);
            System.out.println("Average: " + average);
        }
    }
}
