package Mymain;

import java.util.Scanner;

public class HexadecimalChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a value: ");
        String value = scanner.nextLine();

        boolean isHexadecimal = isHexadecimal(value);

        if (isHexadecimal) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isHexadecimal(String value) {
        value = value.toUpperCase();
if (value.startsWith("0"))
{
    return false;
}
        // Check if all characters are valid hexadecimal digits (0-9, A-F)
        return value.matches("[0-9A-F]+\\.[0-9A-F]?");
    }
    // matches method use for regular expression which return value true or false , as return type boolean values
}

