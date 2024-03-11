package Multi_dimensional;
import java.util.Random;
import java.util.Scanner;

public class Ex_10_CapitalCityGuessingGame {
    public static void main(String[] args) {
        // celar console screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        String[][] data = {
                {"Cambodia", "Phnom Penh"},
                {"Thailand", "Bangkok"},
                {"China", "Beijing"},
                {"Japan", "Tokyo"},
                {"Malaysia", "Kuala Lumpur"}
        };

        // Randomly shuffle the data
        Random random = new Random();
        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = data.length - 1; i > 0; i--) {

            // Pick a random index from 0 to i
            int j = random.nextInt(i + 1);

            // Swap arr[i] with the element at random index
            String[] temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }

        int countCorrect = 0;

        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);

        for (String[] question : data) {
            String country = question[0];
            String capital = question[1];
            System.out.print("What is the capital of " + country + "? ");
            String userInput = scan.nextLine();

            // Compare user's answer (case-insensitive) with the correct capital
            if (userInput.equalsIgnoreCase(capital)) {
                String emoji = "U+1F60E";  // Represents the 😎 emoji
                System.out.println("Correct!"+emoji);
                countCorrect++;// incremet by next question
            } else {
                System.out.println("Incorrect! The capital of " + country + " is " + capital + ".");
            }
        }

        System.out.println("Total correct answers: " + countCorrect);
    }
}