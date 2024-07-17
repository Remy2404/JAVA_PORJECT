package Chapter_9_OOP;

class Salary {
    private double basicSalary;
    private double bonus;

    // Constructor
    public Salary(double basicSalary, double bonus) {
        this.basicSalary = basicSalary;
        this.bonus = bonus;
    }

    // Method to increase salary by 10%
    public void increaseSalary() {
        basicSalary *= 1.10;  // Increase by 10%
    }

    // Method to return total salary
    public double getSalary() {
        return basicSalary + bonus;
    }

    // Method to display salary
    public void displaySalary() {
        System.out.println("Basic Salary: $" + String.format("%.2f", basicSalary));
        System.out.println("Bonus: $" + String.format("%.2f", bonus));
        System.out.println("Total Salary: $" + String.format("%.2f", getSalary()));
    }
}

public class EX7 {
    /**
     * The main entry point of the program, which demonstrates the usage of the
     * `Salary` class.
     * 
     * This code creates a `Salary` object, displays the initial salary details,
     * increases the salary by 10%, and then displays the updated salary details.
     */
    public static void main(String[] args) {
        // Create a salary object
        Salary employeeSalary = new Salary(50000, 5000);

        // Display initial salary
        System.out.println("Initial Salary Details:");
        employeeSalary.displaySalary();

        // Increase salary
        employeeSalary.increaseSalary();

        // Display updated salary
        System.out.println("\nSalary Details After 10% Increase:");
        employeeSalary.displaySalary();
    }
}

