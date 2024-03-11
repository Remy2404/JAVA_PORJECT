package Multi_dimensional;
import java.util.Arrays;
import java.util.Comparator;

public class Ex_5_PointSort {
    public static void main(String[] args) {
        int[][] points = {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {3, 1}, {4, 1}};
        
        // Sort using a custom comparator based on y-coordinates
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
        //(point -> point[1]): This is a lambda expression. It represents a function that takes an element (point) 
        //of your array and extracts the second value within it (point[1]) – assuming this is the 'y' coordinate.

        System.out.println(Arrays.deepToString(points)); 
    }
}
