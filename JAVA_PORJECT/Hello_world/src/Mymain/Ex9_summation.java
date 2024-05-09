package Mymain;// package name
// import statement
public class Ex9_summation {
/*
(Summation) Write a program to compute the following summation.
1 / (1 + √2) + 1 / (√2 + √3) + 1 / (√3 + √4) + ... +  1 / (√624 + √625)
*/static double x_sum = 0;
// main method
public static void main(String[] args) {
		// declare the variable sum signed value of double to store the summation
		// we can use Math.sqrt(i) to get the square root of i and Math.sqrt(i+1) to get the square root of i+1
		for (double i = 1; i <= 624.0; i++) {
			// The line sum += 1; increments the sum variable by 1 each time through the loop
			// The line sum += 1 / (Math.sqrt(i) + Math.sqrt(i + 1)); adds the value of 1 divided by the square root of i and the square root of i + 1 to the sum variable
      x_sum =x_sum +  1 / (Math.sqrt(i) + Math.sqrt(i + 1));
       }
        System.out.println(x_sum); // print the output of the code                                
	}
}                               
       