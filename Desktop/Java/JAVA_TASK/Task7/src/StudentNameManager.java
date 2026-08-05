import java.util.Scanner;

public class StudentNameManager {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner cn = new Scanner(System.in);

        // Declare variables
        int numberOfStudents;
        int choice;
        int studentCount;
        String searchName;
        String existingName;
        String newName;
        String compareName1;
        String compareName2;
        boolean found;

        // Ask the user to enter the number of students
        System.out.print("Enter the number of students: ");
        numberOfStudents = cn.nextInt();
        cn.nextLine(); // Clear input buffer

        // Check if the number is valid
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            // Create String array
            String[] studentNames = new String[numberOfStudents + 20];
            studentCount = numberOfStudents;

            // Read student names
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter student name " + (i + 1) + ": ");
                studentNames[i] = cn.nextLine();
            }


            // Menu
            do {
                System.out.println("========== Student Name Management ==========");
                System.out.println("1.Add Student Name");
                System.out.println("2. Search Student Name");
                System.out.println("3. Update Student Name");
                System.out.println("4. Display All Student Names");
                System.out.println("5. Analyze Names");
                System.out.println("6. Compare Two Names");
                System.out.println("7. Exit");
                choice = cn.nextInt();
                cn.nextLine();

                switch (choice){

                    // Add Student Name
                    case 1:
                        if (studentCount == studentNames.length) {
                            System.out.println("No more space to add students.");
                            break;
                        }
                        System.out.print("Enter new student name: ");
                        newName = cn.nextLine();

                        found = false;

                        for( int i =0; i<studentCount; i++){
                           if(studentNames[i].equals(newName)){
                               found = true;
                               break;
                           }

                        }
                        if (found){
                            System.out.println("Student name already exists.");
                        } else {
                            studentNames[studentCount] = newName;
                            studentCount++;
                            System.out.println("Student name added successfully.");
                        }

                        break;

                    // Search Student Name
                    case 2:

                        System.out.print("Enter student name to search: ");
                        searchName = cn.nextLine();

                        found = false;

                        for ( int i=0; i<studentCount; i++){
                            if (studentNames[i].equals(searchName)) {
                                found = true;
                                break;
                        }
                        }
                        if (found) {
                            System.out.println("Student found.");
                        } else {
                            System.out.println("Student not found.");
                        }

                        break;

                    // Update Student Name
                    case 3:

                        System.out.println("Enter Existing student name");
                        existingName=cn.nextLine();

                        System.out.println("Enter New student name");
                        newName=cn.nextLine();

                        found = false;

                        for (int i = 0; i < studentCount; i++) {
                            if (studentNames[i].equals(existingName)) {
                                studentNames[i] = newName;
                                found = true;
                                break;
                            }
                        }

                        if (found) {
                            System.out.println("Student name updated successfully.");
                        } else {
                            System.out.println("Student not found.");
                        }

                        break;

                    // Display All Student Names
                    case 4:

                        System.out.println("Student Names:");

                        for (int i = 0; i < studentCount; i++) {
                            System.out.println((i + 1) + ". " + studentNames[i]);
                        }

                        break;

                    // Analyze Names
                    case 5:

                        String longestName = studentNames[0];
                        String shortestName = studentNames[0];
                        int totalCharacters = 0;
                        int startsWithA = 0;
                        int endsWithA = 0;

                        for (int i = 0; i < studentCount; i++) {

                            // Find longest name
                            if (studentNames[i].length() > longestName.length()) {
                                longestName = studentNames[i];
                            }

                            // Find shortest name
                            if (studentNames[i].length() < longestName.length() ){
                                shortestName = studentNames[i];
                            }
                            // Count total characters
                            totalCharacters += studentNames[i].length();

                            // Count names starting with A
                            if (studentNames[i].toUpperCase().startsWith("A")) {
                                startsWithA++;
                            }

                            // Count names ending with a
                            if (studentNames[i].toLowerCase().endsWith("a")) {
                                endsWithA++;
                            }
                        }

                        double averageLength = (double) totalCharacters / studentCount;

                        System.out.println("\n===== Name Analysis =====");
                        System.out.println("Total number of students : " + studentCount);
                        System.out.println("Longest student name     : " + longestName);
                        System.out.println("Shortest student name    : " + shortestName);
                        System.out.println("Total characters         : " + totalCharacters);
                        System.out.println("Average name length      : " + averageLength);
                        System.out.println("Names starting with A    : " + startsWithA);
                        System.out.println("Names ending with a      : " + endsWithA);

                        // Demonstrate charAt()
                        System.out.println("\nFirst character of each name:");

                        for (int i = 0; i < studentCount; i++) {
                            System.out.println(studentNames[i] + " -> " + studentNames[i].charAt(0));
                        }

                        // Demonstrate substring()
                        System.out.println("\nFirst three letters of each name:");

                        for (int i = 0; i < studentCount; i++) {

                            if (studentNames[i].length() >= 3) {
                                System.out.println(studentNames[i] + " -> "
                                        + studentNames[i].substring(0, 3));
                            } else {
                                System.out.println(studentNames[i] + " -> "
                                        + studentNames[i]);
                            }
                        }

                        break;

                    // Compare Two Names
                    case 6:

                        System.out.println("Enter student names:");
                        compareName1 = cn.nextLine();

                        System.out.print("Enter second student name: ");
                        compareName2 = cn.nextLine();

                        System.out.println("Comparison Results:");
                        System.out.println("equals(): "
                                + compareName1.equals(compareName2));

                        System.out.println("equalsIgnoreCase(): "
                                + compareName1.equalsIgnoreCase(compareName2));

                        System.out.println("compareTo(): "
                                + compareName1.compareTo(compareName2));

                        System.out.println("Uppercase First Name: "
                                + compareName1.toUpperCase());

                        System.out.println("Lowercase Second Name: "
                                + compareName2.toLowerCase());

                        break;

                    // Exit
                    case 7:
                        System.out.println("Program terminated.");
                        break;

                    // Invalid choice
                    default:
                        System.out.println("Invalid menu choice.");

                }

            } while (choice != 7);
        }

        // Close Scanner
        cn.close();
    }
}





