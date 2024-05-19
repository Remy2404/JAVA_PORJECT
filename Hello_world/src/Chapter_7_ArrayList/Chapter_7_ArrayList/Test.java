package Chapter_7_ArrayList.Chapter_7_ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args ) {
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(Arrays.asList(1,3));
        list1.add(Arrays.asList(5,7));
        list1.add(Arrays.asList(9,11));

        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Arrays.asList(2,4));
        list2.add(Arrays.asList(6,8));
        list2.add(Arrays.asList(10,12,14));
        
        // method call zip 
        List<List<Integer>> zippedList = zip(list1, list2);

        System.out.println("Zipped list: " + zippedList);

    }
    public static List<List<Integer>> zip(List<List<Integer>> list1, List<List<Integer>> list2) {
        
        List<List<Integer>> zipped = new ArrayList<>();
        int index =0;
        for (List<Integer> loop : list1) {
            List<Integer> combIntegers = new ArrayList<>(loop);
            combIntegers.addAll(list2.get(index));
            zipped.add(combIntegers);
            index++;

        }
        return zipped;

    }
}
