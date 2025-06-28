// TASK 2
// STUDENT GRADE CALCULATOR

// Input: Take marks obtained (out of 100) in each subject.
// Calculate Total Marks: Sum up the marks obtained in all subjects.
// Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
// average percentage.
// Grade Calculation: Assign grades based on the average percentage achieved.
// Display Results: Show the total marks, average percentage, and the corresponding grade to the user


import java.util.*;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*************** Student Grade Calculator ***************");

        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        // Validate number of subjects
        if (numSubjects <= 0) {
            System.out.println("Invalid number of subjects. Exiting...");
            return;
        }

        int totalMarks = 0;

        System.out.println("Enter the marks obtained in each subject (0 - 100):");
        for (int i = 1; i <= numSubjects; i++) {
            int marks;
            do {
                System.out.print("Subject " + i + ": ");
                marks = sc.nextInt();
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks. Please enter between 0 and 100.");
                }
            } while (marks < 0 || marks > 100);
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        String grade;

        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else if (averagePercentage >= 40) {
            grade = "E";
        } else {
            grade = "Fail (F)";
        }

        System.out.println("\n================== Result ==================");
        System.out.println("Total Marks       : " + totalMarks);
        System.out.printf("Average Percentage: %.2f %%\n", averagePercentage);
        System.out.println("Grade             : " + grade);
        System.out.println("============================================");

        sc.close();
    }
}
