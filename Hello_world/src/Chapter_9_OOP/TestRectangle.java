package Chapter_9_OOP;

class Rectangle {
   //Data_Fields
    double width;
    double height;

    // Constructors
     Rectangle() {
        // Default Constructor values
        width = 1;
        height = 2;
    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Method to calculate area
    public double getArea() {
        return width * height;
    }

    // Method to calculate perimeter
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Getters for width and height
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
};

// TestRectangle.java
public class TestRectangle {
    public static void main(String[] args) {
        // Create two Rectangle objects
        Rectangle rect1 = new Rectangle(4, 40);
        Rectangle rect2 = new Rectangle(3.5, 35.7);

        // Display the properties of rect1
        // convert double to int
        System.out.println("Rectangle 1:");
        System.out.println("Width: " + (int) rect1.getWidth());
        System.out.println("Height: " +(int) rect1.getHeight());
        System.out.println("Area: " + (int) rect1.getArea());
        System.out.println("Perimeter: " +(int) rect1.getPerimeter());

        // Display the properties of rect2
        //format double to 2 decimal places
    System.out.println("\nRectangle 2:");
    System.out.printf("\n%-10s%-10s%-10s%-10s\n", "Width", "Height", "Area", "Perimeter");
    System.out.printf("%-10.2f%-10.2f%-10.2f%-10.2f\n", rect2.getWidth(), rect2.getHeight(), rect2.getArea(), rect2.getPerimeter());
    }
}