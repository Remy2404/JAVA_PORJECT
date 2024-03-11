package Mymain;

public class Ex1sordArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        if (isSorted(arr)) {
            System.out.println("Array is sorted in ascending order.");
        } else {
            System.out.println("Array is not sorted in ascending order.");
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
