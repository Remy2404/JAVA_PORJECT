import java.util.Scanner;

public class Ex6test {
    public static void main(String[] args) {
        // set values to variables
        int positiveCount = 0;
        int negativeCount = 0;
        int number;
        int total;
        int count = 0;
        //Create an object of the Scanner class
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        do {
            number = input.nextInt();
            if (number > 0) {
                positiveCount++;

            } else if (number < 0) {
                negativeCount++;
            }
            if (number != 0) {
                count++;
            }
        } while (number != 0);
        input.close();
        if (count == 0) {
            System.out.println("No numbers entered.");
        } else {
            System.out.println("The number of numbers entered is " + count);
            total = positiveCount + negativeCount;
            double average = (double) total / count;
            System.out.println("The number of positive numbers is " + positiveCount);
            System.out.println("The number of negative numbers is " + negativeCount);
            System.out.println("The total is " + total);
            System.out.println("The average is " + average);
        }
    }
}

