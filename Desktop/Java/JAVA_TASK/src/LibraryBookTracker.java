import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LibraryBookTracker {
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Declare variables
        int numberOfBooks;
        int bookId;
        int searchBookId;
        String bookTitle;

        // Create a HashSet to store unique book IDs
        HashSet<Integer> bookIds = new HashSet<>();

        // Create a HashMap to store book IDs and book titles
        HashMap<Integer, String> bookRecords = new HashMap<>();

        // Prompt the user to enter the number of books
        System.out.print("Enter the number of books: ");
        numberOfBooks = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Check if the entered number of books is valid
        if (numberOfBooks <= 0) {
            System.out.println("Invalid number of books.");
        } else {

            // Read book details using a for loop
            for (int i = 1; i <= numberOfBooks; i++) {
                System.out.println("Book " + i);

                System.out.print("Enter Book ID: ");
                bookId = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                System.out.print("Enter Book Title: ");
                bookTitle = scanner.nextLine();
                // Check if the book ID already exists
                if (bookIds.contains(bookId)) {
                    System.out.println("Duplicate Book ID. Record not added.");
                    i=i-1;
                } else {
                    // Add the unique book ID to the HashSet
                    bookIds.add(bookId);

                    // Add the book ID and title to the HashMap
                    bookRecords.put(bookId, bookTitle);
                }
            }
            // Prompt the user to search for a book
            System.out.print("Enter Book ID to search: ");
            searchBookId = scanner.nextInt();

            // Search for the book ID in the HashMap
            if (bookRecords.containsKey(searchBookId)) {
                System.out.println("Book ID: " + searchBookId);
                System.out.println("Book Title: " + bookRecords.get(searchBookId));
            } else {
                System.out.println("Book not found.");
            }

            // Classify the library based on the number of unique books
            String libraryClassification;

            if (bookRecords.size() < 5) {
                libraryClassification = "Small Library";
            } else if (bookRecords.size() <= 10) {
                libraryClassification = "Medium Library";
            } else {
                libraryClassification = "Large Library";
            }
            // Display the total number of records entered
            System.out.println("Total book records entered: " + numberOfBooks);

            // Display the total number of unique books
            System.out.println("Total unique books: " + bookIds.size());

            // Display all unique book IDs
            System.out.println("All Book IDs: " + bookIds);

            // Display all book IDs with their corresponding titles
            System.out.println("Book Records:"+ bookRecords);

            // Display the library classification
            System.out.println("Library Classification: " + libraryClassification);

        }

        scanner.close();

    }
}

