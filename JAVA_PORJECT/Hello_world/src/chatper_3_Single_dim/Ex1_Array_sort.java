package chatper_3_Single_dim;

public class Ex1_Array_sort
{
    public static class ArraySortingChecker {

        public static boolean isSortedAscending(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1])
                {
                    return false; // Not sorted
                }
            }

            // If we reach here, the array is sorted
            return true;
        }
        void main() {
            int[] array1 = {1, 3, 5, 7};
            int[] array2 = {2, 4, 1, 8};

            System.out.println(isSortedAscending(array1)); // Output: true
            System.out.println(isSortedAscending(array2)); // Output: false
        }
    }
}
//Deep understanding : flowchart:
/*
                       +-----------------+
                       | Start           |
                       +-----------------+
                                 |
                                 v
                       +-----------------+
                       | Initialize i = 0|
                       +-----------------+
                                 |
                                 v
                       +-----------------+
           +---------->| i < arr.length |
           |           +-----------------+
           |                     |
           |  +------------------+
           |  | arr[i] > arr[i+1]|
           |  +------------------+
           |           | false     |
           |           v           |
           |    +-----------------+
           |    | Return false    |
           |    +-----------------+
           |           |
           |           v
           |    +-------------------+
           |    | Increment i       |
           |    +-------------------+
           |           |
           |           v
           |   +------------------+
           |   | End Loop         |
           |   +------------------+
           |           |
           |           v
           |   +------------------+
           |   | Return true      |-----
           |   +------------------+
           |
           v
+-----------------------------+
| End                         |
+-----------------------------+
*/
