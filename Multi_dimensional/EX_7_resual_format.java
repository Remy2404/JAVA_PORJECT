package Multi_dimensional;

import java.util.Scanner;

public class EX_7_resual_format {

  
    public static void main(String[] args) {
       
       Scanner input = new Scanner(System.in);
        // celar console screen
        System.out.print("\033[H\033[2J");  
        System.out.flush();

        int[][] scores = new int[4][3];

        // Get student scores from the user
        for (int student = 0; student < 4; student++) {
            System.out.println("Subject (1-3)->|  Math | Physics | Chemistry |");
            System.out.println("Enter scores for Student " + (student + 1) + ":");
            for (int subject = 0; subject < 3; subject++) {
                System.out.println();
                System.out.print("Enter score for Subject " + (subject + 1) + ": ");
                scores[student][subject] = validateInput(input);
            }
        }
   

        // Display results
        displayScores(scores);

       input.close();
    }

    // Method to validate input as integer
    private static int validateInput(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number.");
            input.next(); // Clear invalid input
        }
        return input.nextInt();
    }

    // Method to display scores in table format
    private static void displayScores(int[][] scores) {
        System.out.println("\nStudent Scores:");
        System.out.println("+-------------+---------+------------+---------+");
        System.out.println("|     Math    | Physics | Chemistry  | Total   |");
        System.out.println("+-------------+---------+------------+---------+");
        int totalScore = 0;
        for (int student = 0; student < 4; student++) {
            int studentTotal = 0;
            System.out.printf("| Student %d ", (student + 1));
            for (int subject = 0; subject < 3; subject++) {
                System.out.printf("|   %3d   ", scores[student][subject]);
                studentTotal = studentTotal+ scores[student][subject];
                totalScore += scores[student][subject];
            }
            System.out.printf("|   %3d  |\n", studentTotal);
        }
        System.out.println("+---------+---------+----------+-------+");
        System.out.println("Total Score: " + totalScore);
    }

    @Override
    public String toString() {
        return "EX_7_resual_format []";
    }
}
