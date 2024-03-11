//-------------------- Group 4 ------------------------//
package Mymain;

import java.util.Scanner;

public class Ex4PalindromeChecker {
    public static void main(String[] args) {
        try (// Create a Scanner object to read input from the keyboard.
        Scanner Input = new Scanner(System.in)) {
            System.out.print("Enter a word: ");// user input the String words
            String word = Input.nextLine(); // create a vaiable word to store the user input
            String reversedWord = reverse(word);
            //  use method equalsIgnoreCase to compare two String , that return type as a boolean values which defines true or false.
            if (word.equalsIgnoreCase(reversedWord)) {
                System.out.println(word + " is a palindrome.");
            } else {
                System.out.println(word + " is not a palindrome.");
            }
        }
    }
    // Create function of String reverse , cus it ez to call anywhere that you want ! 
     private static String reverse(String word) {
        StringBuilder sb_Input = new StringBuilder(word);
        return sb_Input.reverse().toString();// use the toString() method to get the string value
        /*
         *  why we need to use reverse method cus it help you reverse word like example :
         *  wellcome to emocllew it mean forword to backword
         */
        
    }
    //StringBuilder class is used to create mutable strings,
    //which means that you can change the contents of the string without creating a new object every time. 
}