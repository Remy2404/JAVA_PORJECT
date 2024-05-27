package Chapter_7_ArrayList;

import java.util.ArrayList;

public class EX6_Random_integer {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            int random = 1 + (int)(Math.random() * 10);
            list.add(random);
        }
        System.out.print("Random list: ");
        for (int number : list) {
            System.out.print(number + " ");
        }
        System.out.println();

        boolean[] present = new boolean[10];

        // Mark the numbers present in the list
        for (int number : list) {
            present[number - 1] = true;
        }

        // Display the missing numbers
        System.out.print("The missing number(s) is/are: ");
        for (int i = 0; i < 10; i++) {
            if (!present[i]) {
                System.out.print((i+1) + " ");
            }
        }
        System.out.println();
    }
}
