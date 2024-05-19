package Chapter_7_ArrayList;

import java.util.ArrayList;

public class EX4_removeInt {
    // Create a method
    static void removeInt(int target ,ArrayList <Integer> List_Int) {
List_Int.removeIf(s->s.equals(target));
//A lambda expression is a short block of code which takes in parameters
// and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(5);
        nums.add(8);
        nums.add(4);
        nums.add(13);
        /* nums.forEach(n->{System.out.println(n);});
        for (int num : nums) {
            System.out.println(num);
        } */
        System.out.println("Before remove : " +nums);
        removeInt(5, nums);

        System.out.println("After remove : " + nums);
    }
}
