package Random;
import java.util.Random;

public class EX10_PearlPickingGame {
    private static int survival_simulation(String[] division) {
        int survival_count = 0;
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int bowl = random.nextInt(2);
            int pearl = random.nextInt(division[bowl].length());
            if (division[bowl].charAt(pearl) == 'w') {
                survival_count++;
            }
        }
        return survival_count;
    }

    public static void main(String[] args) {
        String[][] divisions = {
            {"w", "w", "b", "b", "b", "b"},
            {"w", "b", "b", "w", "b", "b"},
            {"w", "b", "b", "b", "w", "b"},
            {"w", "b", "b", "b", "b", "w"},
            {"b", "w", "b", "b", "w", "b"},
            {"b", "w", "b", "w", "b", "b"},
            {"b", "b", "w", "b", "w", "b"},
            {"b", "b", "w", "w", "b", "b"}
        };
        
        for (String[] division : divisions) {
            int survival_count = survival_simulation(division);
            System.out.printf("Strategy: %s; Survival count: %d; Probability: %.2f%%%n",
                String.join(", ", division), survival_count, survival_count / 100.0 * 100);
        }
    }
}
