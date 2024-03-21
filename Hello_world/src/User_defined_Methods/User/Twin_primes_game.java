package User_defined_Methods.User;

public class Twin_primes_game {

    // Method to check if a number is prime
    private static boolean CheckPrime(int num) {
        if (num <= 1) { 
            return false; 
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { // check is odd number we return false.
                return false; 
            }
        }
        return true;
    }

    // Class method to display twin primes
    public static void displayTwinPrimes() {
        System.out.println("The twin prime numbers which are less than 1200:");
        for (int i = 3; i < 1200; i++) {
            if (CheckPrime(i) && CheckPrime(i + 2)) {
                System.out.println(i + ", " + (i + 2));
            }
        }
    }

    public static void main(String[] args) {
        Twin_primes_game.displayTwinPrimes(); // Call the class method directly
    }
}
