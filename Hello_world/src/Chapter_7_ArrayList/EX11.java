package Chapter_7_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class EX11 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // Add elements to the list
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(8);
        list.add(32);
        list.add(21);
        list.add(31);

        Integer max = max(list);
        if (max != null) {
            System.out.println("Maximum element in the list is: " + max);
        } else {
            System.out.println("The list is empty or null.");
        }
    }

    public static Integer max(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        return Collections.max(list);
    }
}
