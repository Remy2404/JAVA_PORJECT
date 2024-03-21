package Random;

import java.util.Scanner;

public class Ex7_Repeat_addtion {
    public static void main(String[] args) {
        int guess = (int) (Math.random() * 10);
        int guess2 = (int) (Math.random() * 10);
        int sum = guess + guess2; 
        

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("What is " + guess + " + " + guess2 + " ?");
            int input = scan.nextInt();
            int dupicate = input;
           

            while (input != sum) {
                System.out.println("Incorrect. Please try again.");
                input = scan.nextInt();
                if (input==sum) {
                    System.out.println("");
                }else{
                    System.out.println("You already enter bro ! " + input);
                }
            }
            System.out.println("You got it bro !");  
            }
         
    }
    
}