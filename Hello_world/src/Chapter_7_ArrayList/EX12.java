package Chapter_7_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class EX12 {
    public static void main(String[] args) {
        // Create a scanner object
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter 10 integers: ");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(input.nextInt());
            }
            // Call the removeDuplicate method to remove duplicate integers from the list
            removeDuplicate(list);
            System.out.print("The distinct integers are ");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
// Method to remove duplicate integers from the list
    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!temp.contains(list.get(i))) {
                temp.add(list.get(i));
            }
        }
        list.clear();//
        for (int i = 0; i < temp.size(); i++) {
            list.add(temp.get(i));
        }
    }
}
