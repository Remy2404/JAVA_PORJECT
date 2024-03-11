package Mymain;
import java.util.Scanner;

public class Ex2 {
//    Write a program that reads a number from the user.
        public static void main(String[] args){
            int number = 0;

            Scanner scanner = new Scanner(System.in);
            while (number <=5){
                System.out.print("Please enter a number : ");
                number=scanner.nextInt();
                System.out.println();
            }
            System.out.println("The last number you entered was a : "+number);
            scanner.close();
        }
    }
