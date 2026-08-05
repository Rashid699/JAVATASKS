import java.util.HashSet;
import java.util.Scanner;

public class StudentSetManager {
    public static void main(String[] args) {

        // Create a HashSet to store unique student IDs

        HashSet<Integer> studentsIdSet = new HashSet<>();
        // Create Scanner to read input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students");
        int idStudent = sc.nextInt();
        int sa = 0;
        String classification = "";



        if (idStudent <= 0) {
            System.out.println("Invalid number of students");
        } else {
            for (int i = 1; i <= idStudent; i++) {
                System.out.println(" Enter student id to add:");
                int se = sc.nextInt();
                  sa = se;
                // Check if the student ID is valid

                if (se > 0 && studentsIdSet.add(se) == false) {
                    System.out.println("id exists");
                    i = i - 1;


                    // Create a String to store the classification

                } else if (sa < 5) {
                    classification = "Small Registration";
                }
                if (sa >= 5 && sa <= 10) {
                    classification = "Medium Registration";
                }
                if (sa > 10) {
                    classification = "Large Registration";
                }
            }



                System.out.println("Current elements in Set: " + studentsIdSet);


        }
        System.out.println(studentsIdSet);
        System.out.println("Total IDs entered:" +idStudent);
        System.out.println("Total unique student IDs:" + idStudent);
        System.out.println("All unique student IDs:" + studentsIdSet);
        System.out.println("Registration classification:" + classification);
        // Close the Scanner
        sc.close();
    }

}