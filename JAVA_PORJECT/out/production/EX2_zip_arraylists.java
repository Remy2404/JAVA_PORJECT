package Chapter_7_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//main method
public class EX2_zip_arraylists {
    public static void main(String[] args) {
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(1, 3));
        list1.add(Arrays.asList(5, 7));
        list1.add(Arrays.asList(9, 11));

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Arrays.asList(2, 4));
        list2.add(Arrays.asList(6, 8));
        list2.add(Arrays.asList(10, 12, 14));

        List<List<Integer>> zippedList = zip(list1, list2);

        System.out.println("Zipped list: " + zippedList);
    }
   // method
    public static List<List<Integer>> zip(List<List<Integer>> list1, List<List<Integer>> list2) {
        List<List<Integer>> zipped = new ArrayList<>();
        
        int index = 0;
        for (List<Integer> sublist1 : list1) {
            List<Integer> combined = new ArrayList<>(sublist1);
            combined.addAll(list2.get(index));
            zipped.add(combined);
            index++;
        }

        return zipped;
    }
}

