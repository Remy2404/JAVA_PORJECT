package Multi_dimensional;
import java.util.Arrays;
public class Ex_6_points_farthest {
  // Function to calculate distance 
    public static double distance(double x1, double y1, double x2, double y2) {
        // formula Rule
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
 // Function to find Farthest points 
    public static int[] findFarthestPoints(double[][] points) {
        double maxDistance = 0; // Define max_Distnace to max of points
        int index1 = 0; //base on arc x  
        int index2 = 0; // bse on arc y

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double currentDistance = distance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (currentDistance > maxDistance) {
                    maxDistance = currentDistance;
                    index1 = i;
                    index2 = j;
                }
            }
        }
        return new int[] {index1, index2};
    }
    // main methods
    public static void main(String[] args) {
        final double[][] points = {{-1, 0}, {-1, -1}, {4, 1}, {2, 0.5}, {3.5, 2}, {3, 1.5}, {-0.15, 4}, {5.5, 4}};
        int[] farthestIndices = findFarthestPoints(points); // call function 
       // use DeepToString to display all current points
       System.out.println("The Original of points  : ");
        System.out.println(Arrays.deepToString(points));
        System.out.println("________________________________________");
        System.out.println("The farthest points are: " + Arrays.toString(points[farthestIndices[0]]) 
                           + " and " + Arrays.toString(points[farthestIndices[1]]));
                           System.out.println("_____________________________________");
        System.out.println("The indices are: " + farthestIndices[0] + ", " + farthestIndices[1]); 
        System.out.println("The length is: " + points.length);
    }
}
