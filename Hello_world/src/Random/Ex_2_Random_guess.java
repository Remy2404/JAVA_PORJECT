package Random;

/*
 * 2. Randomly choose a number between 1 and 6. Ask the user to pick a number. If they guess correctly, 
display the message “Well done”, otherwise, tell them if they are too high or too low and ask them to 
pick a second number. If they guess correctly on their second guess, display “Correct”, otherwise 
display “You lose. The correct number is [random] when user complete the correct guess!=random”
 */
import java.util.Scanner;

public class Ex_2_Random_guess {
    public static void main(String[] args) {
        // Range : 1-6
        int random = 1 + (int)(Math.random() * 6);

        // Create a Scanner object
        Scanner scan = new Scanner(System.in);
        
        boolean correctGuess = false;
        
        while (!correctGuess) {
            System.out.println("Pick a number between 1 and 6, or enter 'stop' to end the game: ");
            String input = scan.next();
            
            if (input.equalsIgnoreCase("stop")) {
                System.out.println("Game ended. The correct number was: " + random);
                break;
            }
            
            int guess = Integer.parseInt(input);
            
            
            if (guess == random) {
                System.out.println("Well done! You guessed correctly.");
                correctGuess = true;
            } else {
                System.out.println("Too " + (guess > random ? "high" : "low") + ". Guess again.");
            }
        }

        scan.close();
    }
}