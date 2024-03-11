
// library
import java.util.Scanner;

public class Ex3Main {
    public  static void main (String[] args){
        // create Scanner object
        Scanner In = new Scanner(System.in);
        /* add data type */
        int total =0;
        String answer = "y";
        // loop until the ans is "y"
        while (answer.equalsIgnoreCase("y")){
            // prompt user input
         System.out.println("Enter a number:  ");
         // read the number form user input:
         int num;
            num = In.nextInt();
            // add the number to the todal amount
         total += num;
            System.out.println("Do you want to add another number? (y/n)"); // ask the user if they want to add another number
            answer = In.next();// read the answer from the user
        }
        // ask user to add the number when user input "y" to add num and user input "!=y" it matters "no or cancel the prompt ":
        System.out.println("The toal amount is : "+ total);
        // close the Scanner object
        In.close();
    }
}