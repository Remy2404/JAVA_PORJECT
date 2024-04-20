package User_defined_Methods.User;

public class EX9_displayLeaders {
    public static void displayLeaders(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isLeader = true;
            for (int j = i+1 ; j < array.length; j++) {
                if (array[i] < array[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + " ");
            
        }
        System.out.println();
        System.out.print("Leaders in the array: ");
        displayLeaders(array);

    }
}
