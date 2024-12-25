
import java.util.Scanner;
public class studentgradecalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = sc.nextInt();

        // Array to store marks
        int[] marks = new int[numberOfSubjects];

        // Input marks for each subject
        System.out.println("Enter the marks obtained in each subject out of 100:");
        int totalMarks = 0;
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determine grade
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}

