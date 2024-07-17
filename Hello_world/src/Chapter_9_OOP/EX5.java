package Chapter_9_OOP;
import java.util.*;

class Score {
    //Data fields
    int mathScore;
    int physicScore;
    int chemistryScore;

    //Constructor
    Score(int mathScore, int physicScore, int chemistryScore) {
        this.mathScore = mathScore;
        this.physicScore = physicScore;
        this.chemistryScore = chemistryScore;
    }

    //Method getTotal
    public int getTotal() {
        return mathScore + physicScore + chemistryScore;
    }
}

class Student {
    //Data fields
    String name;
    int id;
    Score score;

    //Constructor
    Student(String name, int id, Score score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public static Student readStudent(Scanner input) {
        System.out.print("Enter student's name: ");
        String name = input.nextLine().trim();
        System.out.print("Enter student's id: ");
        int id = input.nextInt();
        System.out.print("Enter student's math score: ");
        int mathScore = input.nextInt();
        System.out.print("Enter student's physics score: ");
        int physicScore = input.nextInt();
        System.out.print("Enter student's chemistry score: ");
        int chemistryScore = input.nextInt();
        Score score = new Score(mathScore, physicScore, chemistryScore);
        return new Student(name, id, score);
    }
}

// main function
public class EX5 {
    // main function
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();// ArrayList of Student objects
        // menu loop
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Delete student by id");
            System.out.println("3. Search student by id");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            // Switch case for menu options
            switch (choice) {
                case 1:
                    students.add(Student.readStudent(input));// Add student to ArrayList
                    break;
                case 2:
                    System.out.print("Enter student id to delete: ");
                    int idToDelete = input.nextInt();
                    boolean found = false;
                    for (int i = 0; i < students.size(); i++) {// Loop through ArrayList of Student objects
                        if (students.get(i).id == idToDelete) {// If student id matches idToDelete
                            students.remove(i);// Remove student from ArrayList
                            found = true;// Set found to true
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with id " + idToDelete + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student id to search: ");
                    int idToSearch = input.nextInt();
                    found = false;
                    for (Student student : students) {
                        if (student.id == idToSearch) {
                            System.out.println("Student found:");
                            System.out.println("Name: " + student.name);
                            System.out.println("ID: " + student.id);
                            System.out.println("Math Score: " + student.score.mathScore);
                            System.out.println("Physics Score: " + student.score.physicScore);
                            System.out.println("Chemistry Score: " + student.score.chemistryScore);
                            System.out.println("Total Score: " + student.score.getTotal());
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student with id " + idToSearch + " not found.");
                    }
                    break;
                case 4:
                    System.out.println("\nAll Students:");
                    System.out.println("+-------+-------+-------+-------+-------+-----------+");
                    System.out.println("| ID    | Name  | Math  | Phy   | Chem  | Total     |");
                    System.out.println("+-------+-------+-------+-------+-------+-----------+");
                    for (Student student : students) {
                        System.out.printf("| %-5d | %-5s | %-5d | %-5d | %-5d | %-10d |%n", student.id, student.name,
                                student.score.mathScore, student.score.physicScore, student.score.chemistryScore,
                                student.score.getTotal());
                    }
                    System.out.println("+-----------+-------+-------+-------+-------+-------+");
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
