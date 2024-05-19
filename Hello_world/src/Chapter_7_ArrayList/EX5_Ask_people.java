package Chapter_7_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class EX5_Ask_people {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> invitedPeople = new ArrayList<>();

        // Ask user to enter names of three people
        System.out.print("Enter the names of three people: ");
        for (int i = 0; i < 3; i++) {
            invitedPeople.add(scanner.nextLine());
        }

        // Ask if they want to add more names
        String answer;
        do {
            System.out.print("Would you like to invite another person? ");
            answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                System.out.print("Enter the person's name: ");
                invitedPeople.add(scanner.nextLine());
            }
        } while (answer.equalsIgnoreCase("yes"));

        // Display the number of people invited and their names
        System.out.println("You have invited " + invitedPeople.size() + " people to the party. They are:");
        for (String name : invitedPeople) {
            System.out.println(name);
        }
    }
}
