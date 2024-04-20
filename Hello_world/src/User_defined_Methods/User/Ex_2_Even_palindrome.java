package User_defined_Methods.User;

import java.util.Scanner;

/*
 * (Even palindromes) A palindrome is a word, number, or other sequence of characters which reads 
the same backward as forward. Write a method called generateEvenNumeralPalindrome that 
asks the user how many even palindromes they want, then returns an array that contains those 
palindromes. Write a test program as below:
0 2 4 6 8 22 44 66 88 022
 */
public class Ex_2_Even_palindrome {
    // method to check if a number is palindrome or not
    static void  generateEvenNumeralPalindrome(){
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of even palindromes: ");
        int num = sc.nextInt();
        int[] palindromes = new int[num];
        for(int i=0; i<num; i++){
            palindromes[i] = generatePalindrome();
            System.out.print(palindromes[i]+" ");
        }
        
        
    }
    // Method to generate even palindrome number
    private static int generatePalindrome() {
		int num = (int)(Math.random() * 100); // Generate random 2 digit number
		while(num%2!=0 || !isPalindrome(num)) {
			num = (int)(Math.random() * 100); // Generate again if not even or palindrome
		}
		return num;
	}

	// Method to check if a number is palindrome
	private static boolean isPalindrome(int number) {
		int temp = number, reverse = 0, rem;
		while(temp != 0) {
			rem = temp%10;
			reverse = reverse*10 + rem;
			temp /= 10;
		}
		return (reverse == number);
	}
    
    public static void main(String[] args) {
        generateEvenNumeralPalindrome();
    }
}
