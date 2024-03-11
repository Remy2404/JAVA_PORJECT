import java.util.Scanner;

public class method_Parameters {
    public static int CalculateSquare (int number) {
        int square =number*number;
        return square;
    }
    public static void main(String[] args) {
        // create  an object of Scanner
        Scanner scanner = new Scanner(System.in);
        // ask user to enter a number
        System.out.println( "Enter a number to calcuate it :");
        int promptInput = scanner.nextInt();// user intput
        // close the sys when user leak answer
        scanner.close();
        int result =CalculateSquare(promptInput);
        System.out.println("The square of " +promptInput +  " is" + result);
    }
}
