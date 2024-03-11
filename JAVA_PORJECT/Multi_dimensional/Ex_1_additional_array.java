package Multi_dimensional;
import java.util.*;
/*
 Group 4 : 
 1. In order for two matrix to be be added , the matrix must have the same dimensinal
 and the same or compatible types of elements . Let c be the resulting matrix
 .for example , for two 3*3 matrix a and b,c is : 
 a+b=c Write a program that asks the user to enter two 3 x 3 matrices and add them together.
 */
public class Ex_1_additional_array {
    public static void main(String[] args) {
       /*
         double [][] a = {{1,2,3},{4,5,6},{7,8,9}};
        double [][] b = {{1,2,3},{4,5,6},{7,8,9}};
        double [][] c = new double[3][3];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        // print the resulting 
        System.out.println("The sum of the two matrix is : ");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j]+"  ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        */

  
    /*
           // Define the dimensions of the matrix
        int rows = 3, columns = 3;//+---------+
//                                  |        |
//                                  V        V
        int[][] matrixA = new int[rows][columns];
        int[][] matrixB = new int[rows][columns];
        int[][] resultMatrixC = new int[rows][columns];

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter elements of Matrix A (3x3) separated by spaces:");
            for (int i = 0; i < rows; i++) {
                String input = scanner.nextLine();
                String[] elements = input.trim().split("\\s+");
                for (int j = 0; j < columns; j++){     
                    matrixA[i][j] = Integer.parseInt(elements[j]);
                    
                }
            }
             // The user enters the elements of matrix B
            System.out.println("Enter elements of Matrix B (3x3) separated by spaces:");
            for (int i = 0; i < rows; i++) {
                String input = scanner.nextLine();
                String[] elements = input.trim().split("\\s+");
                for (int j = 0; j < columns; j++) {
                    matrixB[i][j] = Integer.parseInt(elements[j]);
                }
            }
            // calculate the sum of matrix C= A+B
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    resultMatrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            // Print the resulting of matrix C after addition
            System.out.println("The resulting matrix after addition:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(resultMatrixC[i][j] + " ");
                }
                System.out.println();
            }
            // Invaid Input 
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers.");
        }

    }
     */// define Matrix 
        int MatrixRow =3 , Matrixcol = 3;
        int[][] matrixA = new int[MatrixRow][Matrixcol];
        int[][] matrixB = new int[MatrixRow][Matrixcol];
        int[][] matrixC = new int[MatrixRow][Matrixcol];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter " + matrixA.length + " rows and " + 
        matrixA[0].length + " columns: ");
        // Input MatrixA 
        for (int row = 0; row < matrixA.length; row++) {
        for (int col = 0; col < matrixA[row].length; col++) {
        matrixA[row][col] = input.nextInt();
        }
        }
        // Input MatrixB
        System.out.println("Enter the Matrix B");
        for (int row = 0; row < matrixB.length; row++) {
            for (int col = 0; col < matrixB[row].length; col++) {
            matrixB[row][col] = input.nextInt();
            }
            }
        // resulting of MatrixC = MatrixA + MatrixB 
        for (int row =0 ; row < matrixC.length; row++) {
        for (int col = 0; col < matrixC[row].length; col++) {
        matrixC[row][col] = matrixA[row][col] + matrixB[row][col];
        }
        }
        // close Scanner (if used in the program)  
        input.close();
        System.out.println();
        //Display the array
        for (int row = 0; row < matrixC.length; row++) {
        for (int col = 0; col < matrixC[row].length; col++) {
        System.out.printf("%-3d ", matrixC[row][col]);
        }
        System.out.println();
        }
        }
}
