import java.util.Scanner;
import java.util.TreeSet;

public class CityDirectorySet {
    public static void main(String[] args) {

        TreeSet<String> cityName = new TreeSet<>();
        Scanner se = new Scanner(System.in);

        int cities;
        String citiesname = "";
        String citySearch;
        String searchresult;
        String directoryClassification;


        System.out.println("Enter number of cities:");
        cities = se.nextInt();
        se.nextLine();

        if (cities <= 0) {
            System.out.println("Invalid number of cities.");
        }else {
            for (int i = 1; i <= cities; i++) {
                System.out.println("Enter city name:");
                citiesname = se.nextLine();
                if (!cityName.add(citiesname)) {
                    System.out.println("City already exists. Duplicate entries are not allowed.");
                    i = i - 1;

                }
            }
            System.out.println("Enter a city name to search for:");
            citySearch = se.nextLine();
            if (cityName.contains(citySearch)) {
                searchresult = "City found in the directory";

            } else {
                searchresult = "City not found in the directory";
            }

            int totalUniqueCities = cityName.size();

            if (totalUniqueCities < 5) {
                directoryClassification = "Small Directory";
            } else if (totalUniqueCities <= 10) {
                directoryClassification = "Medium Directory";
            } else {
                directoryClassification = "Large Directory";
            }
            System.out.println("Total cities entered:" + cities);
            System.out.println("Total unique cities:" + citiesname);
            System.out.println("All cities in alphabetical order:" + cityName);
            System.out.println("Search result :" + searchresult);
            System.out.println("Directory classification:" + directoryClassification);

        }


        se.close();


    }
}
