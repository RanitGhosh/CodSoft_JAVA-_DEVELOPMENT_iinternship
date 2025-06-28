

// TASK 5
// STUDENT MANAGEMENT SYSTEM : 

// 1. Create a Student class to represent individual students. Include attributes such as name, roll number, grade, and any other relevant details.
// 2. Implement a StudentManagementSystem class to manage the collection of students. Include methods to add a student, remove a student, search for a student, and display all students.
// 3 . Design the user interface for the Student Management System. This can be a console-based interface or a graphical user interface (GUI) using libraries like Swing or JavaFX.
// 4. Implement methods to read and write student data to a storage medium, such as a file or a database.
// 5. Allow users to interact with the Student Management System by providing options such as adding a new student, editing an existing student's information, searching for a student, displaying all students, and exiting the application.
// 6. Implement input validation to ensure that required fields are not left empty and that the student data is in the correct format


import java.util.*;

// Student class
class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

// Student management logic
class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(int rollNumber) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getRollNumber() == rollNumber) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students); // Return a copy to prevent direct modification
    }
}

// Main application
public class StudentManagementSystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    if (sms.removeStudent(rollToRemove)) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student foundStudent = sms.searchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println(" Student not found.");
                    }
                    break;

                case 4:
                    List<Student> allStudents = sms.getAllStudents();
                    if (allStudents.isEmpty()) {
                        System.out.println("No students in the system.");
                    } else {
                        System.out.println("=== List of All Students ===");
                        for (Student student : allStudents) {
                            System.out.println(student);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println(" Invalid choice. Please select from 1 to 5.");
            }
        }
    }
}
