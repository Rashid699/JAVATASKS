import java.util.HashMap;
import java.util.Scanner;

public class ProductPriceCatalog {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);

        // Create a HashMap to store products and price
        HashMap<String, Double> ProductsCatalog = new HashMap<>();
        String productsname = "";
        String searshresult="";
        double productprice;
        String classification;
        double newPrice = 0;

        // Ask the user to enter the number of products
        System.out.print("Enter the number of products: ");
        int productsnumber = sc.nextInt();
        sc.nextLine();


        // Check if the number of products is invalid
        if (productsnumber <= 0) {
            System.out.println("Invalid number of products.");
        } else {
            // Use a loop to enter each product and price
            for (int i = 1; i <= productsnumber; i++) {
                // Ask the user to enter the products name
                System.out.println("Enter product name: ");
                productsname = sc.nextLine();


                System.out.println("Enter product price: ");
                productprice = sc.nextDouble();
                sc.nextLine();

                // Check whether the product name already exists
                if (ProductsCatalog.containsKey(productsname)) {
                    System.out.println("Product already exists. Record not added");
                    i = i - 1;
                } else {

                    // Add the employee ID and name to the HashMap
                    ProductsCatalog.put(productsname, productprice);
                }
            }
            System.out.println("Enter a name to search for: ");
            String searshproduct = sc.nextLine();

            // Check whether the searched employee ID exists
            if (ProductsCatalog.containsKey(searshproduct)) {
                searshresult = "price: " + ProductsCatalog.get(searshproduct);
                // Ask the user if they want to update the price
                System.out.print("Do you want to update the price?");
                String updateChoice = sc.nextLine();

                // Check if the user selected Y
                if (updateChoice.equalsIgnoreCase("Y")) {
                    // Ask for the new price
                    System.out.print("Enter the new price: ");
                    newPrice = sc.nextDouble();
                    // Update the product price using replace()
                    ProductsCatalog.replace(searshproduct, newPrice);
                    // Display successful update message
                    System.out.println("Price updated successfully.");
                }
                // Display the updated price
                System.out.println("Search and update result: "
                        + searshproduct + " = " + ProductsCatalog.get(searshproduct));
            } else {
                // Display product not found message
                System.out.println("Product not found.");
            }
            // Classify the inventory based on the number of unique products
            if (ProductsCatalog.size() < 5) {
                classification = "Inventory classification: Small Inventory";
            } else if (ProductsCatalog.size() <= 10) {
                classification = "Inventory classification: Medium Inventory";
            } else {
                classification = "Inventory classification: Large Inventory";

            }

            System.out.println("Total products entered:"+ productsnumber);
            System.out.println("Total unique products"+ productsname);
            System.out.println("All product names and prices:"+ ProductsCatalog);
            System.out.println("Search and update result:"+ searshproduct + newPrice);
            System.out.println("Inventory classification:"+ classification);
        }
    }
}
