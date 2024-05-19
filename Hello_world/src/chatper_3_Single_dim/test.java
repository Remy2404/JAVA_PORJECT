package chatper_3_Single_dim;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String args[]) {
        // Create and initilize a 2D ArrayList
        ArrayList<ArrayList<Character>> arrayList2D = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList('A', 'B')),
                        new ArrayList<>(Arrays.asList('C', 'D')),
                        new ArrayList<>(Arrays.asList('E', 'F'))));
        // Display the 2D arrayList
        System.out.println(arrayList2D.get(1));
    }
}