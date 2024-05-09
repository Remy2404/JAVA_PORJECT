public class Ex5LargestEvenInt {
    // main method
    public static void main(String[] args) {
        /* The smallest number even integer */
        int n = 0;
        while (Math.pow(n, 3) < 10000) {
            n++;
        }
        // subtract 2 to get the largest even integer
        n = n - 2;
        System.out.println("The largest  even integer n such that n^3 is less than 10000 is " + n);
    }
}
//The largest even integer n such that n³ is less than 10000 is 20. This is because 20^3=8000<10000
//-----------------------------------------------------------------------------and 22^3=10648>10000