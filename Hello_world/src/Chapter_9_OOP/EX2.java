package Chapter_9_OOP;

import java.util.Scanner;

class calculator {
    // Data_Fields
    double num1;
    String opreator;
    double num2;
    

    // Constructor
    calculator(double num1, String opreator, double num2) {
        this.num1 = num1;
        this.opreator = opreator;
        this.num2 = num2;
    }

    // calculate method
    public Number calculate() {
        if (isIntegerOperands()) {
            return calculateInteger();
        } else {
            return calculateDouble();
        }
    }
    // check if integer or not 
    private boolean isIntegerOperands() {
        return num1 % 1 == 0 && num2 % 1 == 0;
    }

    private int calculateInteger() {
        switch (opreator) {
            case "+":
                return (int) (num1 + num2);
            case "-":
                return (int) (num1 - num2);
            case "*":
                return (int) (num1 * num2);
            case "/":
                return (int) (num1 / num2);
            case "^":
                return (int) Math.pow(num1, num2);
            case "%":
                return (int) (num1 % num2);
            default:
                System.out.println("Invalid operator");
                return 0; // Return 0 for invalid operator
        }
    }

    private double calculateDouble() {
        switch (opreator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    System.out.println("Can't divide by 0");
                    return 0;
                }
                return num1 / num2;
            case "^":
                return Math.pow(num1, num2);
            case "%":
                return num1 % num2;
            default:
                System.out.println("Invalid operator");
                return 0; // Return 0 for invalid operator
        }
    }
    

    // Method to calculate :
    // operators : +, -, *, /, ^, %

    public double add() {
        return num1 + num2;
    }

    public double sub() {
        return num1 - num2;
    }

    public double mul() {
        return num1 * num2;
    }

    public double div() {
        if (num2 == 0) {
            System.out.println("Can't divide by 0");
            return 0;
        }
        return num1 / num2;
    }

    public double pow() {
        return Math.pow(num1, num2);
    }

    // modulo method
    public double mod() {
        return num1 % num2;
    }
}

public class EX2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number1, operator, and number2 separated by a space: ");
        double num1 = scan.nextDouble();
        String operator = scan.next();
        double num2 = scan.nextDouble();
        calculator cal = new calculator(num1, operator, num2);
        Number result = cal.calculate();
        System.out.println("Result: " + result);
        scan.close();
    }
}


