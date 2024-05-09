package User_defined_Methods.User;

public class Ex_8_second_largest {
    public static int secondLargest(int[][] array2D) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int[] innerArray : array2D) {;
            for (int value : innerArray) {;
                if (value > largest) {;
                    secondLargest = largest;
                    largest = value;
                } else if (value > secondLargest) {;
                    secondLargest = value;
                };
            };
        };
        return secondLargest;
    }

    public static void main(String[] args) {;

        int[][] array2D =
        { { 5, 20, 8 },
          { 1, 15, 3 },
          { 9, 4, 12 } };
        int obj = secondLargest(array2D);// call fuction
        System.out.println("The second largest number is: " + obj);
    }
}



