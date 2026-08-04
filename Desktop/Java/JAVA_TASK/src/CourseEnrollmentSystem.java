import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class CourseEnrollmentSystem {
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create a HashSet to store unique student IDs
        HashSet<Integer> studentIds = new HashSet<>();

        // Create a HashMap to store student ID and course name
        HashMap<Integer, String> studentCourses = new HashMap<>();

        // Declare variables
        int numberOfStudents;
        int studentId;
        int updateStudentId;
        String courseName;
        String newCourse;
        String enrollmentClassification;

        // Prompt user to enter the number of students
        System.out.print("Enter the number of students: ");
        numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Check if the number of students is valid
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {

            // Read student records using a for loop
            for (int i = 1; i <= numberOfStudents; i++) {

                System.out.println("Student " + i);

                System.out.print("Enter Student ID: ");
                studentId = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Course Name: ");
                courseName = scanner.nextLine();

                // Check for duplicate student ID
                if (studentIds.contains(studentId)) {
                    System.out.println("Student ID already exists. Record not added.");
                    i = i - 1;
                } else {
                    // Add student ID to HashSet
                    studentIds.add(studentId);

                    // Add student ID and course to HashMap
                    studentCourses.put(studentId, courseName);
                }
            }

            // Prompt user to update a student's course
            System.out.print("\nEnter Student ID to update: ");
            updateStudentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Check if student ID exists
            if (studentCourses.containsKey(updateStudentId)) {

                System.out.print("Enter the new course name: ");
                newCourse = scanner.nextLine();

                // Update course using replace()
                studentCourses.replace(updateStudentId, newCourse);

                System.out.println("Course updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }

            // Classify enrollment size
            if (studentIds.size() < 5) {
                enrollmentClassification = "Small Enrollment";
            } else if (studentIds.size() <= 15) {
                enrollmentClassification = "Medium Enrollment";
            } else {
                enrollmentClassification = "Large Enrollment";
            }

            // Display results
            System.out.println("===== Enrollment Summary =====");
            System.out.println("Total student : " + numberOfStudents);

            System.out.println("Total unique students: " + studentIds.size());
            System.out.println("All student IDs: " + studentIds);
            System.out.println("Student IDs with their enrolled courses:" + studentCourses);
            System.out.println("Enrollment Classification: " + enrollmentClassification);

        }

        scanner.close();
    }

}



