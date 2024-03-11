package chatper_3_Single_dim;

import java.util.Scanner;

public class Ex5CountOccurrences {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter 10 integers between 1 and 100 separated by a space: ");
    String input = scanner.nextLine();

    int[] counts = new int[100];

    String[] numbersStr = input.split(" ");
    for (String numberStr : numbersStr) {
      int number = Integer.parseInt(numberStr);
      if (number >= 1 && number <= 100) {
        counts[number - 1]++;
      } else {
        System.err.println("Warning: Number " + number + " is out of range (1-100). Ignoring...");
      }
    }

    for (int i = 0; i < 100; i++) {
      if (counts[i] > 0) {
        System.out.println((i + 1) + " occurs " + counts[i] + " " + (counts[i] > 1 ? "times" : "time"));
      }
    }
  }
}
