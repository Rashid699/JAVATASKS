import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class HospitalPatientManager {

    public static void main() {

        //Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        //Create Queue to Patient names waiting for treatment
        Queue<String> patientQueue = new LinkedList<>();

        //Create Stack to store Completed patient treatments
        Stack<String> patientStack = new Stack<>();

        int numberOfpatient;
        String patientname;
        int choice;


        System.out.println("Enter number of patient: ");
        numberOfpatient = input.nextInt();
        input.nextLine();


        // Check if the entered number is valid
        if (numberOfpatient <= 0){
            System.out.println("Invalid number of patients.");
        }else {
            for (int i=1; i<= numberOfpatient; i++ ){
                System.out.println("patients"+ i + "name:");
                patientname = input.nextLine();

                patientQueue.offer(patientname);
            }

            // Display menu
            do {
                System.out.println("========== Hospital Patient Management System ==========");
                System.out.println("1. Add Patient");
                System.out.println("2. Treat Patient");
                System.out.println("3. View Next Patient");
                System.out.println("4. Undo Last Treatment");
                System.out.println("5. Search Patient");
                System.out.println("6. Display Waiting Patients");
                System.out.println("7. Display Treated Patients");
                System.out.println("8. Display Hospital Statistics");
                System.out.println("9. Exit");
                System.out.print("Enter your choice: ");

                choice = input.nextInt();
                input.nextLine();

                switch (choice){

                    // Add Patient
                    case 1:

                        System.out.println("Enter patients name : ");
                        patientname = input.nextLine();
                        patientQueue.offer(patientname);

                        System.out.println("Patient added successfully.");

                        break;

                    // Treat Patient
                    case 2:

                        if ( patientQueue.isEmpty()){
                            System.out.println("No patients waiting for treatment.");
                        } else {
                            patientname= patientQueue.poll();
                            patientStack.push(patientname);

                            System.out.println("Patient treatment completed successfully.");
                        }

                        break;

                        //View Next Patient
                    case 3:

                        if (patientQueue.isEmpty()){
                            System.out.println("No patients available.");
                        }else {
                            patientQueue.peek();
                        }

                        break;

                        //Undo Last Treatment
                    case 4:

                        if (patientStack.isEmpty()){
                            System.out.println("No completed treatments available.");
                        }else {
                            patientname = patientStack.pop();
                            System.out.println("Patient: " + patientname);
                        }
                        break;

                        //Search Patient
                    case 5:

                        System.out.println("Enter name to search:");
                        patientname = input.nextLine();

                        if (patientQueue.contains(patientname)){
                            System.out.println("Patient is waiting for treatment.");
                        } else if (patientStack.search(patientname) != -1) {
                            System.out.println("Patient treatment completed.");
                        }else {
                            System.out.println("Patient not found.");
                        }


                        break;

                        //Display Waiting Patients
                    case 6:

                        if (patientQueue.isEmpty()) {
                            System.out.println("No waiting patients.");
                        } else {
                            System.out.println("Waiting Patients:");
                            for (String patient : patientQueue) {
                                System.out.println(patient);
                            }
                        }
                        break;

                    // Display Treated Patients
                    case 7:
                        if (patientStack.isEmpty()) {
                            System.out.println("No treated patients.");
                        } else {
                            System.out.println("Treated Patients:");
                            for (String patient : patientStack) {
                                System.out.println(patient);
                            }
                        }
                        break;

                    case 8:
                        System.out.println("========== Hospital Statistics ==========");
                        System.out.println("Total waiting patients: " + patientQueue.size());
                        System.out.println("Total treated patients: " + patientStack.size());

                        if (patientQueue.isEmpty()) {
                            System.out.println("Next patient waiting: None");
                        } else {
                            System.out.println("Next patient waiting: " + patientQueue.peek());
                        }

                        if (patientStack.isEmpty()) {
                            System.out.println("Last treated patient: None");
                        } else {
                            System.out.println("Last treated patient: " + patientStack.peek());
                        }

                        System.out.println("Is queue empty? " + patientQueue.isEmpty());
                        System.out.println("Is stack empty? " + patientStack.isEmpty());
                        break;

                    // Exit
                    case 9:
                        System.out.println("Exiting Hospital Patient Management System...");
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


