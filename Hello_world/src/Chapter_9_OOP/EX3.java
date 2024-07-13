package Chapter_9_OOP;

class MyPoint {
    // Data fields
    private int x;
    private int y;

    // No-arg constructor
    MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor with specified coordinates
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    // Method to calculate distance from this point to another MyPoint object
    public double distance(MyPoint another) {
        int xDiff = this.x - another.x;
        int yDiff = this.y - another.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // Method to calculate distance from this point to a point with specified coordinates
    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    // Static method to calculate distance between two MyPoint objects
    public static double distance(MyPoint p1, MyPoint p2) {
        int xDiff = p1.x - p2.x;
        int yDiff = p1.y - p2.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}

public class EX3 {
    public static void main(String[] args) {
        // Create MyPoint objects
        MyPoint p1 = new MyPoint(1, 2);
        MyPoint p2 = new MyPoint(4, 6);
        //Get X and Y coordinates of p1
        int p1X = p1.getX();
        int p1Y = p1.getY();
        System.out.println("Coordinates of p1: " + p1X + ", " + p1Y);

        // Get X and Y coordinates of p2
        int p2X = p2.getX();
        int p2Y = p2.getY();
        System.out.println("Coordinates of p2: " + p2X + ", " + p2Y);

        // Calculate distances
        System.out.println("Distance between p1 and p2: " + p1.distance(p2));
        System.out.println("Distance between p1 and (5, 7): " + p1.distance(5, 7));
        System.out.println("Distance between p1 and p2 (static method): " + MyPoint.distance(p1, p2));
    }
}

