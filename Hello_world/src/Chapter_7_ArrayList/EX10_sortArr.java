package Chapter_7_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class EX10_sortArr {
    //selection sort algorithm
    public static void sort(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (list.get(j) < list.get(min)) {
                    min = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
            System.out.println(list);
            System.out.println("min: " + min);
            System.out.println("i: " + i);
            System.out.println("temp: " + temp);
            System.out.println("list.get(i): " + list.get(i));
            System.out.println("list.get(min): " + list.get(min));
            System.out.println("---------------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter 5 numbers: ");
        for (int i = 0; i < 5; i++) {
            int number = scan.nextInt();
            list.add(number);
        }
        scan.close();
        sort(list); // Call the sort method to sort the list
        System.out.println("Sorted list: " + list); // Print the sorted list
    }
}
