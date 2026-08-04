import java.util.HashMap;
import java.util.Scanner;

public class StudentGradesMap {
    public static void main(String[] args) {

        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Create a HashMap to store student IDs and grades
        HashMap<Integer, Double> Studentgrades = new HashMap<>();


        
        int updateStudentID;
        double newGrade;
        String classPerformance;


        // Ask the user to enter the number of students
        System.out.print("Enter the number of students: ");
        int studentnumber = sc.nextInt();

        // Check if the number of students is invalid
        if (studentnumber <= 0) {
            System.out.println("Invalid number of students.");
        } else {

            // Use a loop to enter each student's ID and grade
            for (int i = 0; i < studentnumber; i++) {

                // Ask the user to enter the student ID
                System.out.println("Enter student ID: ");
                int studentId = sc.nextInt();

                // Ask the user to enter the student's grade
                System.out.println("Enter student grade: ");
                double grade = sc.nextDouble();

                // Check if the student ID already exists
                if (Studentgrades.containsKey(studentId)) {
                    System.out.println("Student ID already exists. Record not added.");
                    i = i - 1;
                } else {
                    // Add the student ID and grade to the HashMap
                    Studentgrades.put(studentId, grade);
                }
            }
            // Ask the user to enter a student ID to update
            System.out.print("Enter student ID to update grade: ");
            updateStudentID = sc.nextInt();

            // Check if the student ID exists in the HashMap
            if (Studentgrades.containsKey(updateStudentID)) {

                // Ask the user to enter the new grade
                System.out.print("Enter the new grade: ");
                newGrade = sc.nextDouble();

                // Update the student's grade using replace()
                Studentgrades.replace(updateStudentID, newGrade);

                // Display a success message
                System.out.println("Grade updated successfully.");
            } else {
                // Display a message if the student ID is not found
                System.out.println("Student ID not found.");
            }
            // Calculate the total of all student grades
            double totalGrades = 0;

            for ( double grade : Studentgrades.values()){
                totalGrades += grade;
            }
            // Calculate the average grade
            double averageGrade = 0;

            if (!Studentgrades.isEmpty()) {
                averageGrade = totalGrades / Studentgrades.size();
            }
            // Classify the class performance based on the average grade

            if (averageGrade < 60) {
                classPerformance = "Needs Improvement";
            } else if (averageGrade <= 84) {
                classPerformance = "Good Performance";
            } else {
                classPerformance = "Excellent Performance";
            }
            System.out.println("Total student records: " + Studentgrades.size());
            System.out.println("All student IDs and grades:");
            for (Integer studentId : Studentgrades.keySet()) {
                System.out.println("Student ID: " + studentId
                        + ", Grade: " + Studentgrades.get(studentId));
            }
            System.out.println("Average grade: " + averageGrade);
            System.out.println("Class performance classification: " + classPerformance);
        }


        // Close the Scanner
        sc.close();
    }

}
