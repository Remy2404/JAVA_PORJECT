package Chapter10.Chapter_10.src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EX5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        //Create a File object with the user-provided filename
       File file = new File(input.nextLine());

        int[] counts = new int[26]; // Array to store count of each letter

        try {
            Scanner fileScanner = new Scanner(file);//Create a Scanner to read the file

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().toLowerCase();
                for (char ch : line.toCharArray()) {
                    if (ch >= 'a' && ch <= 'z') {
                        counts[ch - 'a']++;
                    }
                }
            }
            fileScanner.close();

            // Display the results
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    System.out.println("Number of " + (char)('A' + i) + "s: " + counts[i]);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file);
        }

        input.close();
    }
}