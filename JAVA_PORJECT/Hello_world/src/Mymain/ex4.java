package Mymain;

import java.util.Scanner;

public class ex4 {
    public static void main(String[] args) {
        int computer_num = 50;
        int countAttempt = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            // Loop continuously until the user guesses correctly
            while (true) {
                countAttempt++;
                System.out.print("Guess the number: ");
                int userGuess = scanner.nextInt();

                //check if guess correct
                if (userGuess == computer_num) {
                    System.out.println("Well done, you took " + countAttempt + " attempts!");
                    break; // Exit the loop when the guess is correct

                    //print incorrect guess_message
                } else {
                    System.out.println("Incorrect guess. Try again.");
                
                }
            }
        }
    }
}
