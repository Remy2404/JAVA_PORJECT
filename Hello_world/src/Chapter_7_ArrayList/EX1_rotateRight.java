package Chapter_7_ArrayList;

import java.util.ArrayList;
import java.util.List;

public class EX1_rotateRight {
   public static ArrayList<Integer> rotateRight(ArrayList<Integer> list) {
      if (list.isEmpty()) {
         return list;
     }

     int size = list.size();
     int lastElement = list.get(size - 1);
     int secondLastElement = list.get(size - 2);

     list.remove(size - 1);
     list.remove(size - 2);
     list.add(0, lastElement);
     list.add(0, secondLastElement);
    System.out.println( "size :"+list.size());
     return list;
   }

   public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 3, 5 ,7 ));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(1, 2, 3 ));

        System.out.println("Original list 1: " + list1);
        System.out.println("Rotated list 1: " + rotateRight(list1));
        System.out.println("Original list 2: " + list2);
        System.out.println("Rotated list 2: " + rotateRight(list2));
   }
}
