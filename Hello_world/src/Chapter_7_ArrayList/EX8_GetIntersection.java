package Chapter_7_ArrayList;

import java.util.ArrayList;

/* Write a method getIntersection that accepts two ArrayLists of characters and returns the 
intersection between the two ArrayLists.
Write a test program that randomly generates two ArrayLists of characters (A to Z) and displays the 
intersection between the two ArrayLists */

public class EX8_GetIntersection {
    // method to get intersection
    public static ArrayList<Character> getIntersection(ArrayList<Character> list1, ArrayList<Character> list2) {
        ArrayList<Character> intersection = new ArrayList<Character>();
        for (Character c : list1) {
            if (list2.contains(c)) {
                intersection.add(c);
            }
        }
        return intersection;
    }
    public static void main(String[] args) {
        // randomly generates two ArrayLists of characters (A to Z)
        ArrayList<Character> list1 = new ArrayList<Character>();
        ArrayList<Character> list2 = new ArrayList<Character>();

        for (int i = 0; i < 10; i++) {
            int random1 = (int) (Math.random() * 26);
            int random2 = (int) (Math.random() * 26);
            list1.add((char) (random1 + 'A'));
            list2.add((char) (random2 + 'A'));
        }
        System.out.println("list1: " + list1);
        System.out.println("list2 : " + list2);
        // get intersection
        ArrayList<Character> intersection = getIntersection(list1, list2);
        System.out.println("Intersection: " + intersection);

    }
}
