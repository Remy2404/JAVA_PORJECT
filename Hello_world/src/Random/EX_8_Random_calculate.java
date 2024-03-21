package Random;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EX_8_Random_calculate {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        String[] questions = new String[5]; // Array to store question details

        for (int i = 0; i < 5; i++) {
            int num1 = 10 + (int)(Math.random() * 11);
            int num2 = 10 + (int)(Math.random() * 11);
            int op = (int)(Math.random() * 4);
            double answer = 0;
            String operator;
            switch (op) {
                case 0: answer = num1 + num2; operator = "+"; break;
                case 1: answer = num1 - num2; operator = "-"; break;
                case 2: answer = num1 * num2; operator = "*"; break;
                default: answer = (double) num1 / num2; operator = "/"; // case :3  
            }

            String question = "Question " + (i + 1) + ": What is " + num1 + " " + operator + " " + num2 + "?";
            System.out.println(question);
            double userAnswer = scan.nextDouble();

            // Store question details
            questions[i] = question + " = " + df.format(answer) + 
            (Math.abs(userAnswer - answer) < 0.01 ? " Correct." : " Incorrect.");        

            if (Math.abs(userAnswer - answer) < 0.01) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + df.format(answer));
            }
        }

        System.out.println("\nYou got " + score + " out of 5 questions correct!");
        System.out.println("The detail is below:"); // Header for details

        // Display detailed results
        for (String questionDetail : questions) {
            System.out.println(questionDetail);
        }

        scan.close();
    }
}
