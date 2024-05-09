package User_defined_Methods.User;

/**
 * Ex_7_getIntersection
 * Write a method getIntersection that accepts two arrays of characters, and
 * returns the intersection
 * between the two arrays. Write a test program that randomly generates two arrays
 * of size 10 that
 * contain characters (A to Z) and displays the intersection between the two arrays.
 */
public class Ex_7_getIntersection {
    static char[] getIntersection(char[] arr1, char[] arr2) {
        char[] arr3 = new char[10];
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    arr3[count] = arr1[i];
                    count++;
                    break; // Exit inner loop once a match is found
                }
            }
        }

        return arr3;
    }

    public static void main(String[] args) {
        char[] arr1 = new char[10];// create size 10 array1
        char[] arr2 = new char[10];// create size 10 array2
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (char) (Math.random() * 26 + 65);
            System.out.print(arr1[i] + " ");
            arr2[i] = (char) (Math.random() * 26 + 65);
            System.out.println(arr2[i] + " ");
        }

        // intersection between the two arrays
        char[] arr3 = getIntersection(arr1, arr2);
        System.out.println("Intersection between the two arrays: ");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
