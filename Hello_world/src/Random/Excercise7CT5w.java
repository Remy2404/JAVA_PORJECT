package Random;

import java.util.Scanner;

public class Excercise7CT5w {
    public static void main(String[] args) {
        int r_num1 = (int)(Math.random() * 50);
        int r_num2 = (int)(Math.random() * 50);
        int result = r_num1 + r_num2;
        Scanner input = new Scanner(System.in);
        System.out.println("What is " + r_num1 + " + " + r_num2 + " = ");
        int answer = input.nextInt();
        int duplicate = answer;
        for (int i=0 ; i < duplicate ; i++){
            if (answer==duplicate) {
                System.out.println("You've already entered " + duplicate + " Please try again!");
                System.out.println("What is " + r_num1 + " + " + r_num2 + " = " );
                answer = input.nextInt();

            }
            duplicate++;

        }

        while (answer != result) {
            if(answer != result){
                System.out.println("Wrong answer! Please try again!");
                System.out.println("What is " + r_num1 + " + " + r_num2 + " = " );
                answer = input.nextInt();
            }            
            if(answer == duplicate){
                System.out.println("You've already entered " + duplicate + " Please try again!");
                System.out.println("What is " + r_num1 + " + " + r_num2 + " = " );
                answer = input.nextInt();
            }
        }
        
        System.out.println("Excellent job! " + r_num1 + " + " + r_num2 + " = " + result);
        input.close();
    }
}