import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeeDirectoryMap {
    public static void main(String[] args) {
        // Create a HashMap to store employee IDs as keys and names as values

        HashMap<Integer, String> employeeDirection = new HashMap<>();
        // Create a Scanner object to read user input
        Scanner cn = new Scanner(System.in);

        // Declare variables for the number of employees and employee details
        int employeesnumber;
        int employeeID = 0;
        String employeename = "";
        int searshID;
        String searshresult;
        String classification;
        // Ask the user to enter the number of employees
        System.out.println("Enter number of employees:");
        employeesnumber = cn.nextInt();
        cn.nextLine();
        // Check whether the entered number of employees is valid
        if ( employeesnumber <= 0){
            System.out.println("Invalid number of employees");
        }else {
            // Use a for loop to enter each employee's information
            for (int i=1; i <= employeesnumber; i++){
                // Ask the user to enter the employee ID
                System.out.println("Enter employee ID:");
                employeeID = cn.nextInt();
                cn.nextLine();
                // Check whether the employee ID already exists
                if ( employeeDirection.containsKey(employeeID)){
                    System.out.println("Employee ID already exists. Please enter a unique ID.");
                    i=i-1;
                } else {
                    System.out.print("Enter employee name for employee:");
                    employeename = cn.nextLine();
                    // Add the employee ID and name to the HashMap
                    employeeDirection.put(employeeID, employeename);
                }
            }
            System.out.println("Enter an employee ID to search for: ");
            searshID = cn.nextInt();
            // Check whether the searched employee ID exists
            if ( employeeDirection.containsKey(searshID)){
                searshresult = "Employee Found: " + employeeDirection.get(searshID);
            }else {
                searshresult = "Employee ID not found.";
            }
            // Classify the company based on the number of unique employees
            int companyClassification = employeeDirection.size();
            if ( employeeDirection.size() < 5){
                classification = "small company";
            }else if ( employeeDirection.size() >= 5 && employeeDirection.size() <= 10){
                classification = "medium company";
            }else{
                classification = "large company";
            }
            System.out.println("Total employee records entered:"+ employeesnumber);
            System.out.println("Total unique employees:"+ employeeID);
            System.out.println("All employee IDs and names:"+ employeeID + employeename);
            System.out.println("Search result:"+ searshresult);
            System.out.println("Company classification:"+ classification);
        }
        // Close the Scanner before the program ends
        cn.close();


    }
}
