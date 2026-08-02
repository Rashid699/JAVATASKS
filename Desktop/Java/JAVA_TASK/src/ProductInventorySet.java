import java.util.HashSet;
import java.util.Scanner;

public class ProductInventorySet {
    public static void main(String[] args) {

        HashSet<String> productSet = new HashSet<>();

        Scanner ce = new Scanner(System.in);

        int product;
        String productname = "";
        String namesearch;
        String resultsearch;
        String classification;

        System.out.println("Enter number of products:");
        product = ce.nextInt();
        ce.nextLine();

        if ( product <= 0){
            System.out.println("Invalid number of products.");
        } else {
            for (int i =1; i <= product; i++){

                System.out.println("Enter product name:");
                productname = ce.nextLine();
                if (!productSet.add(productname)){
                    System.out.println("Product already exists. Duplicate entries are not allowed");
                    i= i-1;
                }

            }
            System.out.println(" Enter a product name to search for");
            namesearch = ce.nextLine();
            if (productSet.contains(namesearch)){
                resultsearch = "Product found in inventory";
            }else {
                resultsearch = "Product not found in inventory.";
            }
            int totalUniqueproduct = productSet.size();
            if ( totalUniqueproduct < 5){
                classification = "Small Inventory";
            } else if ( totalUniqueproduct >= 5 && totalUniqueproduct < 10) {
                classification = " Medium Inventory";
            }else{
                classification = " Large Inventory";
            }
            System.out.println("Total products entered:"+ product);
            System.out.println("Total unique products:"+ productname);
            System.out.println("All products in the inventory:"+ productSet);
            System.out.println("Search result:"+ resultsearch);
            System.out.println("Inventory classification:"+ classification);

        }
        ce.close();
    }

    }
