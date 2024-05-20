package Chapter_7_ArrayList;

import java.util.ArrayList;

public class EX6_Random_integer {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        // Generate the list of 10 random integers between 1 and 10
        for (int i = 0; i < 10; i++) {
            int random = 1 + (int)(Math.random() * 10);
            list.add(random);
        }

        // Display the generated list
        System.out.print("Random list: ");
        for (int number : list) {
            System.out.print(number + " ");
        }
        System.out.println();

        // Array to track the presence of numbers from 1 to 10
        boolean[] present = new boolean[10];

        // Mark the numbers present in the list
        for (int number : list) {
            present[number - 1] = true;
        }

        // Display the missing numbers
        System.out.print("The missing number(s) is/are: ");
        for (int i = 0; i < 10; i++) {
            if (!present[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}
