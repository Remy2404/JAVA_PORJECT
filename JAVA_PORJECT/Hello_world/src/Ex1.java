import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {

//------- Set Variable Total To 0 -----------
        int total = 0;

//------- Set object To Input -------------
        Scanner input = new Scanner(System.in);

//------- Creat While loops while total less than or equal 50 ----------
        while(total<=50){

//------- Display the statment ---------
            System.out.printf("Enter a number  : ");

//------- Userinput with object input---------
            int UserInput = input.nextInt();

//------- Add Userinput with total number ---------
            total+= UserInput;// Add the userinput to the total number

//------- Display Total number --------
            System.out.println("The total is  : " + total);// Print the total number
        }


//------- Close object ---------
        input.close();

    }
}
