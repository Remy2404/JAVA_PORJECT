package Multi_dimensional;

public class Ex_3_inerate {

    public static void main(String[] args) {
        int rows = 4;
        int columns = 4;
        int[][] array = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16} 
        };

        // Iterating through left diagonal
        for (int k = rows - 1; k >= 0; k--) {
            for (int i = k, j = 0; i < rows; i++, j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        //

        // Iterating through lower diagonals
        for (int k = 1; k < columns; k++) {
            for (int i = rows - 1, j = k; j < columns; i--, j++) {
                System.out.print(array[i][j] + " ");
                
            }
            System.out.println();
        }
    }
}
/* 
 key point : Let'swith the given array:
```
 1  2  3  4
 5  6  7  8
 9 10 11 12
13 14 15 16

// Iterating through left diagonal
for (int k = rows - 1; k >= 0; k--) {
    for (int i = k, j = 0; i < rows; i++, j++) {
        System.out.print(array[i][j] + " ");
    }
    System.out.println();
}
```

**Step-by-Step Breakdown:**

**Outer Loop (`k`)**

* **Iteration 1 (k = 3):** 
   * **Inner Loop:**
      * `i = 3`, `j = 0` :  Prints `array[3][0]` (value = 13)

* **Iteration 2 (k = 2):** 
   * **Inner Loop:**
      * `i = 2`, `j = 0`:  Prints `array[2][0]` (value = 9) 
      * `i = 3 `, `j = 1`: Prints `array[3][1]` (value = 14)

* **Iteration 3 (k = 1):**
   * **Inner Loop:**
      * `i = 1`, `j = 0`: Prints `array[1][0]`  (value = 5)
      * `i = 2`, `j = 1`: Prints `array[2][1]` (value = 10)
      * `i = 3`, `j = 2`: Prints `array[3][2]` (value = 15)  

* **Iteration 4 (k = 0):**
   * **Inner Loop:**
     * `i = 0`, `j = 0`: Prints `array[0][0]` (value = 1)
     * `i = 1`, `j = 1`: Prints `array[1][1]` (value = 6)
     * `i = 2`, `j = 2`: Prints `array[2][2]` (value = 11)
     * `i = 3`, `j = 3`: Prints `array[3][3]` (value = 16)

**Output**

The complete output from the left diagonal loop is:

```
13 
9 14 
5 10 15 
1 6 11 16 
```

**Key Points**

* **Outer Loop:** Controls the starting row of each diagonal.
* **Inner Loop:** Iterates through the elements of the current diagonal, moving upwards and to the right. 

terating through the lower diagonals:

The outer loop (for (int k = 1; k < columns; k++)) starts from the second column (k = 1) and goes up to the last column (k = 3).
The inner loop (for (int i = rows - 1, j = k; j < columns; i--, j++)) initializes i to the last row (rows - 1) and j to the current column k. It then iterates through the rows (i) and columns (j) such that i decreases by 1 and j increases by 1 in each iteration.
For each iteration, it prints the value at array[i][j].
Output of this loop:
2 7 12 
3 8 
4 

```
 */