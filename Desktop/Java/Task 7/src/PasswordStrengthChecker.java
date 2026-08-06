import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args){
// Create Scanner object
        Scanner input = new Scanner(System.in);

        // Declare variables
        String password = "";
        int choice;

        // Variables for password analysis
        int upperCaseCount;
        int lowerCaseCount;
        int digitCount;
        int specialCount;
        String strength;

        // Prompt user to enter the first password
        System.out.println("Enter password");
        password = input.nextLine();

        // Check if password is empty
        if (password.length() <= 0) {
            System.out.println("Invalid password.");
        } else {
            System.out.println("Password Security Information");
            System.out.println("Password Length: " + password.length());
            System.out.println("First Character: " + password.charAt(0));
            System.out.println("Last Character: " + password.charAt(password.length() - 1));
        }

        // Display menu until user exits
        do {

            System.out.println("===== Password Strength Checker =====");
            System.out.println("1. Enter Password");
            System.out.println("2. Check Password Length");
            System.out.println("3. Analyze Password Characters");
            System.out.println("4. Check Password Strength");
            System.out.println("5. Convert Password Format");
            System.out.println("6. Display Password Report");
            System.out.println("7. Exit");
            choice = input.nextInt();
            input.nextLine();


            switch (choice){

                // Enter new password
                case 1:
                    System.out.println("Enter new password");
                    password = input.nextLine();
                    System.out.println("Password saved successfully.");
                    break;

                // Check password length
                case 2:
                    System.out.println(password.length());

                    if (password.length() < 8){
                        System.out.println("Password is too short.");
                    }else {
                        System.out.println("Password length is acceptable.");
                    }

                    break;

                // Analyze password characters
                case 3:

                    if (password.length() <= 0) {
                        System.out.println("Invalid password.");
                    } else {

                        upperCaseCount = 0;
                        lowerCaseCount = 0;
                        digitCount = 0;
                        specialCount = 0;

                        // Analyze every character
                        for (int i=0; i < password.length(); i++){

                            char ch = password.charAt(i);

                            if (Character.isAlphabetic(ch)){
                                upperCaseCount++;
                            } else if (Character.isLowerCase(ch)) {
                                lowerCaseCount++;
                            } else if (Character.isDigit(ch)) {
                                digitCount++;
                            }else {
                                specialCount++;
                            }

                        }
                        System.out.println("Uppercase letters: " + upperCaseCount);
                        System.out.println("Lowercase letters: " + lowerCaseCount);
                        System.out.println("Digits: " + digitCount);
                        System.out.println("Special characters: " + specialCount);
                    }

                    break;

                // Check password strength
                case 4:
                    if (password.length() <= 0) {
                        System.out.println("Invalid password.");
                    } else {

                        upperCaseCount = 0;
                        lowerCaseCount = 0;
                        digitCount = 0;
                        specialCount = 0;

                        for (int i = 0; i < password.length(); i++) {

                            char ch = password.charAt(i);

                            if (Character.isUpperCase(ch))
                                upperCaseCount++;
                            else if (Character.isLowerCase(ch))
                                lowerCaseCount++;
                            else if (Character.isDigit(ch))
                                digitCount++;
                            else
                                specialCount++;
                        }
                        if (password.length() > 8 &&
                                upperCaseCount > 0 &&
                                lowerCaseCount > 0 &&
                                digitCount > 0 &&
                                specialCount > 0) {
                            strength = "Strong Password";
                        } else if (password.length() > 6 &&
                                upperCaseCount > 0 &&
                                lowerCaseCount > 0 &&
                                digitCount > 0) {
                            strength = "Medium Password";
                        } else {
                            strength = "Weak Password";
                        }

                        System.out.println(strength);
                    }
                    break;

                // Convert password format
                case 5:
                    if (password.length() <= 0) {
                        System.out.println("Invalid password.");
                    } else {

                        System.out.println("Uppercase: " + password.toUpperCase());
                        System.out.println(" Lowercase: " + password.toLowerCase());
                    }
                    break;

                // Display password report
                case 6:

                    if (password.length() <= 0) {
                        System.out.println("Invalid password.");
                    } else {

                        upperCaseCount = 0;
                        lowerCaseCount = 0;
                        digitCount = 0;
                        specialCount = 0;

                        for (int i = 0; i < password.length(); i++) {

                            char ch = password.charAt(i);

                            if (Character.isUpperCase(ch))
                                upperCaseCount++;
                            else if (Character.isLowerCase(ch))
                                lowerCaseCount++;
                            else if (Character.isDigit(ch))
                                digitCount++;
                            else
                                specialCount++;
                        }

                        if (password.length() >= 8 &&
                                upperCaseCount > 0 &&
                                lowerCaseCount > 0 &&
                                digitCount > 0 &&
                                specialCount > 0) {

                            strength = "Strong Password";

                        } else if (password.length() >= 6 &&
                                upperCaseCount > 0 &&
                                lowerCaseCount > 0 &&
                                digitCount > 0) {

                            strength = "Medium Password";

                        } else {

                            strength = "Weak Password";
                        }
                        System.out.println("===== Password Report =====");
                        System.out.println("Password Length: " + password.length());
                        System.out.println("First Character: " + password.charAt(0));
                        System.out.println("Last Character: " + password.charAt(password.length() - 1));
                        System.out.println("Uppercase Letters: " + upperCaseCount);
                        System.out.println("Lowercase Letters: " + lowerCaseCount);
                        System.out.println("Digits: " + digitCount);
                        System.out.println("Special Characters: " + specialCount);
                        System.out.println("Password Strength: " + strength);
                    }

                    break;

                // Exit
                case 7:
                    System.out.println("Program Ended.");
                    break;

                // Invalid choice
                default:
                    System.out.println("Invalid menu choice.");

            }

        } while (choice != 7);

        // Close Scanner
        input.close();
    }
}
