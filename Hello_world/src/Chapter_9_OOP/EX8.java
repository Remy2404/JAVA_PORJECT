package Chapter_9_OOP;


class Grade {
    // Data fileds
    int A;
    int B;
    int C;
    int D;
    int F;
    // Constructor
Grade(int A, int B, int C, int D, int F) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.F = F;
    }
    // Method that sets the number of each grade A,B, C , D and F
    public void setGrade(String grade, int number) {
        switch (grade) {
            case "A":
                A =(number);
                break;
            case "B":
                B =(number);
                break;
            case "C":
                C =(number);
                break;
            case "D":
                D =(number);
                break;
            case "F":
                F =(number);
                break;
        }
    }
// Method that retrun the total number of students
public int getTotal_Students() {
    return A+B+C+D+F;

}
// Method that retruns the percentage of each grade as a whole number between 0 and 100
public int getPercentage(String grade) {
    int total = getTotal_Students();
    int count;
    switch (grade) {
        case "A":
            count = A;
            break;
        case "B":
            count = B;
            break;
        case "C":
            count = C;
            break;
        case "D":
            count = D;
            break;
        case "F":
            count = F;
            break;
        default:
            return 0;
    }
    return (count * 100) / total;
}
// Method that draws a bar graph of the grade distribution
public void drawBarGraph() {
    System.out.println("Grade Distribution Bar Graph:");
    drawBar("A", getPercentage("A"));
    drawBar("B", getPercentage("B"));
    drawBar("C", getPercentage("C"));
    drawBar("D", getPercentage("D"));
    drawBar("F", getPercentage("F"));
}

private void drawBar(String grade, int percentage) {
    int asterisks = (percentage + 1) / 2; // One asterisk represents 2 percent
    System.out.print(grade + ": ");
    for (int i = 0; i < asterisks; i++) {
        System.out.print("*");
    }
    System.out.println(" (" + percentage + "%)");
}
}
public class EX8 {
    public static void main(String[] args) {
        Grade grades = new Grade(2, 4, 6, 2, 1);
        System.out.println("Total students: " + grades.getTotal_Students());
        System.out.println("Percentage of A: " + grades.getPercentage("A") + "%");
        System.out.println("Percentage of B: " + grades.getPercentage("B") + "%");
        System.out.println("Percentage of C: " + grades.getPercentage("C") + "%");
        System.out.println("Percentage of D: " + grades.getPercentage("D") + "%");
        System.out.println("Percentage of F: " + grades.getPercentage("F") + "%");
        grades.drawBarGraph();
    }
}

