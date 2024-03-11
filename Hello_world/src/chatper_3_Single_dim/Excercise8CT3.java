package chatper_3_Single_dim;

public class Excercise8CT3 {
    public static void main(String[] args) {
        int numLockers = 50;
        boolean[] lockers = new boolean[numLockers];

        // Set all lockers as closed
        for (int i = 0; i < numLockers; i++) {
            lockers[i] = false;
        }

        // Start the game
        for (int player = 1; player <= numLockers; player++) {
            for (int locker = player - 1; locker < numLockers; locker += player) {
                lockers[locker] = !lockers[locker]; // Toggle the locker
            }
        }

        // Print open locker numbers
        System.out.print("Open lockers:");
        int openCount = 0;
        for (int i = 0; i < numLockers; i++) {
            if (lockers[i]) {
                System.out.print((i + 1) + " ");
                openCount++;
            }
        }
        System.out.println();

        // Print total number of open lockers
        System.out.println("Total number of open lockers: " + openCount);
    }
}
