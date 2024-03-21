package Random;
import java.util.Random;
public class EX_9_simulation {
    public static void main(String[] args) {
        int[] players = new int[6];
        int rounds = 1000;
        Random random = new Random();

        for (int i = 0; i < rounds; i++) {
            int[] bullets = new int[6];
            for (int j = 0; j < 5; j++) {
                bullets[j] = 1;
            }// Load bullets into the barrel
            for (int j = 0; j < 6; j++) {
                int turn = random.nextInt(6);
                if (bullets[turn] == 1) {
                    players[turn]++;
                    bullets[turn] = 0;
                }
            }
        }

        System.out.println("Number of times each player gets shot:");
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + players[i]);
        }
    }
}