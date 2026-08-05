import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class UniversityCourseRegistrationSystem {
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // HashSet to store unique student IDs
        HashSet<Integer> studentIds = new HashSet<>();

        // HashMap to store student ID and their registered courses
        HashMap<Integer, HashSet<String>> studentCourses = new HashMap<>();

        // Variables for statistics
        int numberOfStudents;
        int choice;

        // Ask user for the number of students
        System.out.print("Enter the number of students: ");
        numberOfStudents = input.nextInt();
        input.nextLine();

        // Check if the number of students is valid
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
            input.close();
            return;
        }

        // Enter student information
        for (int i = 1; i <= numberOfStudents; i++) {

            System.out.println("\nStudent " + i);

            System.out.print("Enter Student ID: ");
            int studentId = input.nextInt();
            input.nextLine();

            // Check for duplicate student ID
            if (studentIds.contains(studentId)) {
                System.out.println("Student ID already exists. Record skipped.");
                continue;
            }

            // Add student ID
            studentIds.add(studentId);

            // Create course set for the student
            HashSet<String> courses = new HashSet<>();

            System.out.print("Enter number of courses (Maximum 6): ");
            int numberOfCourses = input.nextInt();
            input.nextLine();

            // Prevent more than 6 courses
            if (numberOfCourses > 6) {
                numberOfCourses = 6;
                System.out.println("Only the first 6 courses will be accepted.");
            }

            // Read courses
            for (int j = 1; j <= numberOfCourses; j++) {
                System.out.print("Enter course " + j + ": ");
                String course = input.nextLine();

                if (courses.add(course)) {
                    System.out.println("Course added.");
                } else {
                    System.out.println("Duplicate course. Not added.");
                }
            }

            // Save courses in the HashMap
            studentCourses.put(studentId, courses);
        }

        // Menu loop
        do {

            System.out.println("========== UNIVERSITY COURSE REGISTRATION ==========");
            System.out.println("1. Search Student");
            System.out.println("2. Add Course to Student");
            System.out.println("3. Remove Course from Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Display Registration Statistics");
            System.out.println("6. Register New Student");
            System.out.println("7. Display Students in a Course");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                // Search Student
                case 1:

                    System.out.print("Enter Student ID: ");
                    int searchId = input.nextInt();
                    input.nextLine();

                    if (studentCourses.containsKey(searchId)) {
                        System.out.println("Registered Courses: " + studentCourses.get(searchId));
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                // Add Course
                case 2:

                    System.out.print("Enter Student ID: ");
                    int addId = input.nextInt();
                    input.nextLine();

                    if (studentCourses.containsKey(addId)) {

                        HashSet<String> courses = studentCourses.get(addId);

                        if (courses.size() >= 6) {
                            System.out.println("Student already has the maximum of 6 courses.");
                            break;
                        }

                        System.out.print("Enter Course Name: ");
                        String newCourse = input.nextLine();

                        if (courses.add(newCourse)) {
                            studentCourses.replace(addId, courses);
                            System.out.println("Course added successfully.");
                        } else {
                            System.out.println("Duplicate course registration.");
                        }

                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                // Remove Course
                case 3:

                    System.out.print("Enter Student ID: ");
                    int removeId = input.nextInt();
                    input.nextLine();

                    if (studentCourses.containsKey(removeId)) {

                        System.out.print("Enter Course Name: ");
                        String removeCourse = input.nextLine();

                        HashSet<String> courses = studentCourses.get(removeId);

                        if (courses.remove(removeCourse)) {
                            studentCourses.replace(removeId, courses);
                            System.out.println("Course removed successfully.");
                        } else {
                            System.out.println("Course not found.");
                        }

                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                // Display All Students
                case 4:

                    System.out.println("\n----- All Students -----");

                    // TreeSet sorts student IDs in ascending order
                    TreeSet<Integer> sortedIds = new TreeSet<>(studentCourses.keySet());

                    for (int id : sortedIds) {
                        System.out.println("Student ID: " + id);
                        System.out.println("Courses: " + studentCourses.get(id));
                        System.out.println();
                    }

                    break;

                // Display Statistics
                case 5:

                    int totalStudents = studentCourses.size();
                    int totalRegistrations = 0;

                    int highestStudent = -1;
                    int lowestStudent = -1;

                    int highestCourses = -1;
                    int lowestCourses = Integer.MAX_VALUE;

                    // Calculate statistics
                    for (int id : studentCourses.keySet()) {

                        int size = studentCourses.get(id).size();

                        totalRegistrations += size;

                        if (size > highestCourses) {
                            highestCourses = size;
                            highestStudent = id;
                        }

                        if (size < lowestCourses) {
                            lowestCourses = size;
                            lowestStudent = id;
                        }
                    }

                    double average = 0;

                    if (totalStudents > 0) {
                        average = (double) totalRegistrations / totalStudents;
                    }

                    System.out.println("\n----- Registration Statistics -----");
                    System.out.println("Total Students: " + totalStudents);
                    System.out.println("Total Course Registrations: " + totalRegistrations);

                    if (totalStudents > 0) {
                        System.out.println("Student with Highest Courses: " + highestStudent +
                                " (" + highestCourses + ")");
                        System.out.println("Student with Lowest Courses: " + lowestStudent +
                                " (" + lowestCourses + ")");
                    }

                    System.out.printf("Average Courses per Student: %.2f%n", average);

                    break;

                // Register New Student
                case 6:

                    System.out.print("Enter New Student ID: ");
                    int newStudentId = input.nextInt();
                    input.nextLine();

                    if (studentIds.contains(newStudentId)) {
                        System.out.println("Student ID already exists.");
                    } else {

                        studentIds.add(newStudentId);

                        HashSet<String> newCourses = new HashSet<>();

                        System.out.print("Enter number of courses (Maximum 6): ");
                        int count = input.nextInt();
                        input.nextLine();

                        if (count > 6)
                            count = 6;

                        for (int i = 1; i <= count; i++) {

                            System.out.print("Enter Course " + i + ": ");
                            String course = input.nextLine();

                            newCourses.add(course);
                        }

                        studentCourses.put(newStudentId, newCourses);

                        System.out.println("Student registered successfully.");
                    }

                    break;

                // Display students registered in a specific course
                case 7:

                    System.out.print("Enter Course Name: ");
                    String courseName = input.nextLine();

                    boolean found = false;

                    System.out.println("\nStudents registered in " + courseName + ":");

                    for (int id : studentCourses.keySet()) {

                        if (studentCourses.get(id).contains(courseName)) {
                            System.out.println("Student ID: " + id);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No students found for this course.");
                    }

                    break;

                // Exit
                case 8:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");

            }

        } while (choice != 8);

        // Display complete registration summary
        System.out.println("\n========== FINAL REGISTRATION SUMMARY ==========");

        TreeSet<Integer> sortedIds = new TreeSet<>(studentCourses.keySet());

        for (int id : sortedIds) {
            System.out.println("Student ID: " + id);
            System.out.println("Courses: " + studentCourses.get(id));
            System.out.println("--------------------------------");
        }

        // Close the Scanner
        input.close();
    }
}



