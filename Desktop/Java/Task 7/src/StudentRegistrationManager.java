import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StudentRegistrationManager {
    public static void main(String[] args){

        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Create Queue to store students waiting for registration
        Queue<String> registrationQueue = new LinkedList<>();

        // Create Stack to store completed registrations
        Stack<String> registrationStack = new Stack<>();

        // Declare variables
        int numberOfStudents;
        int choice;
        String studentName;

        // Ask user for the number of students
        System.out.print("Enter the number of students waiting for registration: ");
        numberOfStudents = input.nextInt();
        input.nextLine(); // Clear buffer


        // Check if the entered number is valid
        if (numberOfStudents <= 0) {
            System.out.println("Invalid number of students.");
        } else {
            // Read student names and add them to the queue
            for (int i = 1; i <= numberOfStudents; i++) {
                System.out.print("Enter student " + i + " name: ");
                studentName = input.nextLine();
                registrationQueue.add(studentName);
        }

            // Display menu until user chooses Exit
            do {
                System.out.println("========== Student Registration System ==========");
                System.out.println("1. Add Student to Queue");
                System.out.println("2. Process Student Registration");
                System.out.println("3. View Next Student");
                System.out.println("4. Undo Last Registration");
                System.out.println("5. Search Student");
                System.out.println("6. Display Waiting Students");
                System.out.println("7. Display Registered Students");
                System.out.println("8. Display Statistics");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");


                choice = input.nextInt();
                input.nextLine();

                switch (choice){

                    // Add student to queue
                    case 1:

                        System.out.println("Enter student name:");
                        studentName = input.nextLine();


                        registrationQueue.add(studentName);

                        System.out.println("Student added to registration queue successfully.");
                        break;

                    // Process student registration
                    case 2:
                        if (registrationQueue.isEmpty()) {
                            System.out.println("No students waiting for registration.");
                        } else {
                            studentName = registrationQueue.remove();
                            registrationStack.push(studentName);

                            System.out.println("Student registration completed.");
                            System.out.println("Registered Student: " + studentName);
                        }
                        break;

                    // View next student
                    case 3:

                        if (registrationQueue.isEmpty()){

                            System.out.println("No students in the queue.");
                        } else {
                            System.out.println("Next student :"+ registrationQueue.element());
                        }

                        break;

                    // Undo last registration
                    case 4:

                        if (registrationStack.isEmpty()){
                            System.out.println("No registrations to undo.");
                        }else {
                            studentName = registrationStack.pop();
                            System.out.println("last registered undone");
                            System.out.println("Removed Student :"+ studentName);

                        }

                        break;

                    // Search student
                    case 5:

                        System.out.println("Enter student name to search :");
                        studentName = input.nextLine();

                        if (registrationQueue.contains(studentName)){
                            System.out.println(studentName + " is waiting for registration.");
                        } else if (registrationStack.search(studentName)!= -1) {
                            System.out.println(studentName + " is already registered.");
                        }else {
                            System.out.println(studentName + "not found.");
                        }

                        break;

                    // Display waiting students
                    case 6:

                        if (registrationQueue.isEmpty()){
                            System.out.println("No waiting students.");
                        }else {
                            System.out.println("waiting students:");
                            for ( String students : registrationQueue ){
                                System.out.println(students);
                            }

                        }
                        break;

                    // Display registered students
                    case 7:
                        if ( registrationStack.isEmpty()){
                            System.out.println("No registered students.");
                        }else {
                            System.out.println("Registered Students:");
                            for ( String students : registrationStack){
                                System.out.println(students);
                            }
                        }

                        break;

                    // Display statistics
                    case 8:

                        System.out.println("========== Statistics ==========");
                        System.out.println("Total waiting students: " + registrationQueue.size());
                        System.out.println("Total registered students: " + registrationStack.size());

                        if (registrationQueue.isEmpty()) {
                            System.out.println("Next student waiting: None");
                        } else {
                            System.out.println("Next student waiting: " + registrationQueue.element());
                        }

                        if (registrationStack.isEmpty()) {
                            System.out.println("Last registered student: None");
                        } else {
                            System.out.println("Last registered student: " + registrationStack.peek());
                        }

                        System.out.println("Is queue empty? " + registrationQueue.isEmpty());
                        System.out.println("Is stack empty? " + registrationStack.isEmpty());
                        break;

                    // Exit program
                    case 9:
                        System.out.println("Exiting Student Registration System...");
                        break;

                    // Invalid choice
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 9);
        }

        // Close Scanner
        input.close();
    }
}


