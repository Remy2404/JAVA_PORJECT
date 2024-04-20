package User_defined_Methods.User;

import java.util.Scanner;

public class EX_10_bin_packing {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter the weights of the objects: ");

      String weightsStr = scanner.nextLine();

      int containerCount = binPacking(weightsStr);

      System.out.println("\nTotal number of containers needed: " + containerCount);

      scanner.close();
   }

   public static int binPacking(String weightsStr) {
  int containerWeightLimit = 10;
  int containerCount = 0;
  int currentWeight = 0;
  String[] weights = weightsStr.split(" ");

  for (String weight : weights) {
     int currentObjWeight = Integer.parseInt(weight);

     if (currentWeight + currentObjWeight <= containerWeightLimit) {
        System.out.print("Container " + (containerCount + 1) + " contains object with weight " + currentObjWeight + ' ');
        currentWeight+= currentObjWeight;
     } else {
        containerCount++;
        System.out.println();
        System.out.print("Container " + (containerCount + 1) + " contains object with weight " + currentObjWeight + ' ');
        currentWeight = currentObjWeight;
     }
  }

  return containerCount;
}
}