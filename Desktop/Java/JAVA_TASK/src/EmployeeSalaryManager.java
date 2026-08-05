import java.util.HashMap;
import java.util.Scanner;

public class EmployeeSalaryManager {

    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Create HashMap to store employee ID and salary
        HashMap<Integer, Double> employeeSalaries = new HashMap<>();

        // Declare variables
        int numberOfEmployees;
        int employeeId;
        double salary;
        int choice;

        // Prompt user to enter the number of employees
        System.out.print("Enter the number of employees: ");
        numberOfEmployees = input.nextInt();

        // Check if the number of employees is valid
        if (numberOfEmployees <= 0) {
            System.out.println("Invalid number of employees.");
        } else {

            // Read employee IDs and salaries
            for (int i = 1; i <= numberOfEmployees; i++) {

                System.out.println("Employee " + i);

                System.out.print("Enter Employee ID: ");
                employeeId = input.nextInt();

                // Check if employee ID already exists
                if (employeeSalaries.containsKey(employeeId)) {
                    System.out.println("Employee ID already exists. Record not added.");
                } else {
                    System.out.print("Enter Salary: ");
                    salary = input.nextDouble();

                    // Store employee record
                    employeeSalaries.put(employeeId, salary);
                }
            }

            // Menu loop
            do {

                System.out.println("========== Employee Salary Management ==========");
                System.out.println("1. Add Employee");
                System.out.println("2. Search Employee");
                System.out.println("3. Update Salary");
                System.out.println("4. Remove Employee");
                System.out.println("5. Display All Employees");
                System.out.println("6. Display Salary Statistics");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                // Process user's choice
                switch (choice) {

                    case 1:
                        // Add Employee
                        System.out.print("Enter Employee ID: ");
                        employeeId = input.nextInt();

                        if (employeeSalaries.containsKey(employeeId)) {
                            System.out.println("Employee ID already exists. Record not added.");
                        } else {
                            System.out.print("Enter Salary: ");
                            salary = input.nextDouble();

                            employeeSalaries.put(employeeId, salary);
                            System.out.println("Employee added successfully.");
                        }
                        break;

                    case 2:
                        // Search Employee
                        System.out.print("Enter Employee ID to search: ");
                        employeeId = input.nextInt();

                        if (employeeSalaries.containsKey(employeeId)) {
                            System.out.println("Employee ID: " + employeeId);
                            System.out.println("Salary: " + employeeSalaries.get(employeeId));
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 3:
                        // Update Salary
                        System.out.print("Enter Employee ID to update: ");
                        employeeId = input.nextInt();

                        if (employeeSalaries.containsKey(employeeId)) {
                            System.out.print("Enter New Salary: ");
                            salary = input.nextDouble();

                            employeeSalaries.replace(employeeId, salary);
                            System.out.println("Salary updated successfully.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 4:
                        // Remove Employee
                        System.out.print("Enter Employee ID to remove: ");
                        employeeId = input.nextInt();

                        if (employeeSalaries.containsKey(employeeId)) {
                            employeeSalaries.remove(employeeId);
                            System.out.println("Employee removed successfully.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 5:
                        // Display all employees
                        if (employeeSalaries.size() == 0) {
                            System.out.println("No employee records available.");
                        } else {
                            System.out.println("Employee Records:");

                            for (Integer id : employeeSalaries.keySet()) {
                                System.out.println("Employee ID: " + id
                                        + " | Salary: " + employeeSalaries.get(id));
                            }
                        }
                        break;

                    case 6:
                        // Display salary statistics
                        if (employeeSalaries.size() == 0) {
                            System.out.println("No employee records available.");
                        } else {

                            double highestSalary = Double.MIN_VALUE;
                            double lowestSalary = Double.MAX_VALUE;
                            double totalPayroll = 0;

                            for (double currentSalary : employeeSalaries.values()) {

                                if (currentSalary > highestSalary) {
                                    highestSalary = currentSalary;
                                }

                                if (currentSalary < lowestSalary) {
                                    lowestSalary = currentSalary;
                                }

                                totalPayroll += currentSalary;
                            }

                            double averageSalary = totalPayroll / employeeSalaries.size();

                            System.out.println("Salary Statistics");
                            System.out.println("----------------------------");
                            System.out.println("Highest Salary : " + highestSalary);
                            System.out.println("Lowest Salary  : " + lowestSalary);
                            System.out.println("Average Salary : " + averageSalary);
                            System.out.println("Total Payroll  : " + totalPayroll);
                        }
                        break;

                    case 7:
                        // Exit program
                        System.out.println("Exiting program...");
                        break;

                    default:
                        // Invalid menu option
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 7);
        }

        // Close the Scanner
        input.close();
    }
}