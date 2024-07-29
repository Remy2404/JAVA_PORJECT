package Chapter_10_Exception_Handling;

public class EX6 {

    public static void main() {
        try {
            System.out.println(hex2Binary("1A3F")); // Valid hex string
            System.out.println(hex2Binary("GHIJ")); // Invalid hex string
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String hex2Binary(String hex) {
        if (hex == null || !hex.matches("[0-9A-Fa-f]+")) {
            throw new NumberFormatException(STR."Invalid hexadecimal string: \{hex}");
        }

        StringBuilder binary = new StringBuilder();
        for (char hexChar : hex.toCharArray()) {
            int decimal = Integer.parseInt(String.valueOf(hexChar), 16);
            String binaryString = Integer.toBinaryString(decimal);
            binary.append(String.format("%4s", binaryString).replace(' ', '0'));
        }

        return binary.toString();
    }
}

