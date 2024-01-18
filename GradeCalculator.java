import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------");
        System.out.println("\nEnter marks obtained in each subject (out of 100):");
        System.out.println("-----------------------------------------------------------------");

        int subjects = 0;
        int totalMarks = 0;

        while (true) {
            System.out.print("\nEnter marks for subject " + (subjects + 1) + " (or -1 to finish): ");
            int marks = scanner.nextInt();
            System.out.println("-----------------------------------------------------------------");

            if (marks == -1) {
                break;
            }

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid input. Marks should be between 0 and 100.");
                continue;
            }

            totalMarks += marks;
            subjects++;
        }

        System.out.println("      Exam Results");
        System.out.println("------------------------");
        System.out.println("Total Subjects: " + subjects);
        System.out.println("Total Marks: " + totalMarks);

        if (subjects > 0) 
        {
            double averagePercentage = (double) totalMarks / subjects;
            System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);

      
            String grade = calculateGrade(averagePercentage);
            System.out.println("Grade: " + grade);
        } 
        else 
        {
            System.out.println("No subjects entered. Exiting program.");
        }

        System.out.println("------------------------");

        scanner.close();
    }

   
    private static String calculateGrade(double averagePercentage) 
    {
        if (averagePercentage >= 90) {
            return "A+";
        } 
        else if (averagePercentage >= 80) {
            return "A";
        } 
        else if (averagePercentage >= 70) {
            return "B";
        } 
        else if (averagePercentage >= 60) {
            return "C";
        } 
        else if (averagePercentage >= 50) {
            return "D";
        } 
        else {
            return "F";
        }
    }
}
