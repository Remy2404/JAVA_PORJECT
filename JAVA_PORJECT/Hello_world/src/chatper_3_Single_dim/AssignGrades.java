package chatper_3_Single_dim;
import java.util.Scanner;

public class AssignGrades {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter five scores separated by a space: ");
    String input = scanner.nextLine();

    String[] scoresStr = input.split(" ");
    int[] scores = new int[scoresStr.length];

    for (int i = 0; i < scores.length; i++) {
      scores[i] = Integer.parseInt(scoresStr[i]);
    }

    for (int i = 0; i < scores.length; i++) {
      char grade;
      if (scores[i] >= 90) {
        grade = 'A';
      } else if (scores[i] >= 80) {
        grade = 'B';
      } else if (scores[i] >= 70) {
        grade = 'C';
      } else if (scores[i] >= 60) {
        grade = 'D';
      } else {
        grade = 'F';
      }

      System.out.println("Score " + (i + 1) + " is " + scores[i] + " and grade is " + grade);
    }
  }
}
