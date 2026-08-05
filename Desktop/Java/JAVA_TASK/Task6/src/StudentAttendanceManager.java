import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAttendanceManager {
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Create HashMap to store Student ID and Attendance Days
        HashMap<Integer, Integer> attendanceMap = new HashMap<>();

        // Declare variables
        int numberOfStudents;
        int studentId;
        int attendanceDays;
        int choice;

        // Ask the user to enter the number of student records
        System.out.print("Enter the number of student records: ");
        numberOfStudents = input.nextInt();

        // Check if the number of students is valid
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {

            // Read student records
            for (int i = 1; i <= numberOfStudents; i++) {

                System.out.println("Student Record " + i);

                System.out.print("Enter Student ID: ");
                studentId = input.nextInt();

                // Check if the student ID already exists
                if (attendanceMap.containsKey(studentId)) {
                    System.out.println("Student ID already exists. Record not added.");
                } else {
                    System.out.print("Enter Number of Attended Days: ");
                    attendanceDays = input.nextInt();

                    // Add the student record
                    attendanceMap.put(studentId, attendanceDays);
                }
            }

            // Display menu until the user chooses Exit
            do {

                System.out.println("===== Student Attendance Management Menu =====");
                System.out.println("1. Add Student Record");
                System.out.println("2. Search Student Attendance");
                System.out.println("3. Update Attendance");
                System.out.println("4. Remove Student Record");
                System.out.println("5. Display All Attendance Records");
                System.out.println("6. Display Attendance Statistics");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                // Process the user's choice
                switch (choice) {

                    case 1:
                        // Add a new student record
                        System.out.print("Enter Student ID: ");
                        studentId = input.nextInt();

                        if (attendanceMap.containsKey(studentId)) {
                            System.out.println("Student ID already exists. Record not added.");
                        } else {
                            System.out.print("Enter Number of Attended Days: ");
                            attendanceDays = input.nextInt();

                            attendanceMap.put(studentId, attendanceDays);
                            System.out.println("Student record added successfully.");
                        }
                        break;

                    case 2:
                        // Search for a student's attendance
                        System.out.print("Enter Student ID to search: ");
                        studentId = input.nextInt();

                        if (attendanceMap.containsKey(studentId)) {
                            System.out.println("Attendance Days: " + attendanceMap.get(studentId));
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 3:
                        // Update attendance using replace()
                        System.out.print("Enter Student ID to update: ");
                        studentId = input.nextInt();

                        if (attendanceMap.containsKey(studentId)) {
                            System.out.print("Enter New Attendance Days: ");
                            attendanceDays = input.nextInt();

                            attendanceMap.replace(studentId, attendanceDays);
                            System.out.println("Attendance updated successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        // Remove a student record
                        System.out.print("Enter Student ID to remove: ");
                        studentId = input.nextInt();

                        if (attendanceMap.containsKey(studentId)) {
                            attendanceMap.remove(studentId);
                            System.out.println("Student record removed successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 5:
                        // Display all attendance records
                        if (attendanceMap.isEmpty()) {
                            System.out.println("No attendance records available.");
                        } else {
                            System.out.println("Student Attendance Records");
                            System.out.println("---------------------------");

                            for (Map.Entry<Integer, Integer> entry : attendanceMap.entrySet()) {
                                System.out.println("Student ID: " + entry.getKey()
                                        + " | Attendance Days: " + entry.getValue());
                            }
                        }
                        break;

                    case 6:
                        // Display attendance statistics
                        if (attendanceMap.isEmpty()) {
                            System.out.println("No attendance records available.");
                        } else {

                            int totalStudents = attendanceMap.size();
                            int totalAttendance = 0;

                            int highestStudentId = 0;
                            int highestAttendance = Integer.MIN_VALUE;

                            int lowestStudentId = 0;
                            int lowestAttendance = Integer.MAX_VALUE;

                            // Calculate total attendance using values()
                            for (int days : attendanceMap.values()) {
                                totalAttendance += days;
                            }

                            // Find highest and lowest attendance using entrySet()
                            for (Map.Entry<Integer, Integer> entry : attendanceMap.entrySet()) {

                                if (entry.getValue() > highestAttendance) {
                                    highestAttendance = entry.getValue();
                                    highestStudentId = entry.getKey();
                                }

                                if (entry.getValue() < lowestAttendance) {
                                    lowestAttendance = entry.getValue();
                                    lowestStudentId = entry.getKey();
                                }
                            }

                            double averageAttendance =
                                    (double) totalAttendance / totalStudents;

                            System.out.println("Attendance Statistics");
                            System.out.println("----------------------");
                            System.out.println("Total Number of Students: " + totalStudents);
                            System.out.println("Total Attendance Days: " + totalAttendance);
                            System.out.printf("Average Attendance: %.2f%n", averageAttendance);
                            System.out.println("Highest Attendance: Student ID "
                                    + highestStudentId + " (" + highestAttendance + " days)");
                            System.out.println("Lowest Attendance: Student ID "
                                    + lowestStudentId + " (" + lowestAttendance + " days)");

                            // Display all student IDs using keySet()
                            System.out.println("Registered Student IDs:");
                            for (int id : attendanceMap.keySet()) {
                                System.out.println(id);
                            }
                        }
                        break;

                    case 7:
                        // Exit the program
                        System.out.println("Exiting the program...");
                        break;

                    default:
                        // Handle invalid menu choices
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 7);
        }

        // Close the Scanner
        input.close();
    }
}

