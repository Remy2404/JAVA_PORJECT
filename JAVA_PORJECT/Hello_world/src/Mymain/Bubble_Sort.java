package Mymain;

import java.util.Arrays;

public class Bubble_Sort {
// paramater  but no return 
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
// main method 
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90}; // declare the array to store data
        System.out.println("Unsorted array: " + Arrays.toString(arr));

        bubbleSort(arr); // call the class in main method --------------------------------- 

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
