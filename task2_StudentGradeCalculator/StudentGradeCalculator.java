import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************************");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("**************************************");

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        if (numberOfSubjects <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            scanner.close();
            return;
        }

        int totalMarks = 0;

        for (int i = 1; i <= numberOfSubjects; i++) {

            int marks;

            while (true) {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");
                marks = scanner.nextInt();

                if (marks >= 0 && marks <= 100) {
                    break;
                }

                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
            }

            totalMarks += marks;
        }

        double averagePercentage =
                (double) totalMarks / numberOfSubjects;

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
        } else {
            grade = "F";
        }

        System.out.println("\n*************************************");
        System.out.println("             RESULT");
        System.out.println("**************************************");
        System.out.println("Student Name       : " + studentName);
        System.out.println("Total Marks        : " + totalMarks);
        System.out.printf("Average Percentage : %.2f%%\n", averagePercentage);
        System.out.println("Grade              : " + grade);
        System.out.println("======================================");

        scanner.close();
    }
}