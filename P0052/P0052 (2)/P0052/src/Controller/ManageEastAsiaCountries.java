
package Controller;

import Model.*;
import View.Validation;
import java.util.*;

public class ManageEastAsiaCountries {

    private ArrayList<DevelopCountry> lc;

    public ManageEastAsiaCountries(ArrayList<DevelopCountry> lc) {
        this.lc = lc;
    }

    public void inputCountry(ArrayList<DevelopCountry> lc) {
        while (lc.size() < 12 || Validation.checkInputYN("Do you want to continue (Y/N): ")) {
            String countryCode = Validation.checkInputString("Enter country code: ");
            if (!Validation.checkCountryExist(lc, countryCode)) {
                System.out.println("Country existed");
                continue;
            }
            String countryName = Validation.checkCountryName("Enter Country Name: ");
            float countryArea = Validation.checkInputFloat("Enter total area: ");
            String countryTerrain = Validation.checkInputString("Enter country terrain: ");
            lc.add(new DevelopCountry(countryCode, countryName, countryArea, countryTerrain));
            System.err.println("Add successful!");
        }
    }

    private EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        if (lc.isEmpty()) {
            throw new Exception("No recently entered information.");
        }
        return lc.get(lc.size() - 1);
    }

    public void viewCountry() {
        try {
            EastAsiaCountries recentCountry = getRecentlyEnteredInformation();
            System.out.println("Recently Entered Country Information:");
            displayCountryInformation(Arrays.asList(recentCountry));
        } catch (Exception e) {
            System.out.println("No recently entered information.");
        }
    }

    public void displayCountryInformation(List<EastAsiaCountries> countries) {
        System.out.printf("%-10s%-15s%-15s%-15s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountries country : countries) {
            System.out.println(country);
        }
    }

    public void viewSortCountry() {
        Collections.sort(lc, Comparator.comparing(DevelopCountry::getCountryName));
        System.out.printf("%-10s%-15s%-15s%-15s\n", "ID", "Name",
                "Total Area", "Terrain");
        for (DevelopCountry a : lc) {
            System.out.print(a);
        }
    }

    public void search() {
        String countryName = Validation.checkCountryName("Enter Country Name: ");

        DevelopCountry foundCountry = null;

        for (DevelopCountry country : lc) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                foundCountry = country;
                break;
            }
        }

        if (foundCountry != null) {
            System.out.printf("%-10s%-15s%-15s%-15s\n", "ID", "Name", "Total Area", "Terrain");
            System.out.print(foundCountry);
        } else {
            System.out.println("Country not found!");
        }
    }

    public void generation() {
        lc.add(new DevelopCountry("Vn", "VietNam", 2343332, "nice"));
        lc.add(new DevelopCountry("cn", "China", 233533, "bad"));
        lc.add(new DevelopCountry("an", "EngLand", 23333, "bad"));
        lc.add(new DevelopCountry("bn", "Russia", 2323333, "average"));
        lc.add(new DevelopCountry("dn", "America", 2332333, "good"));
        lc.add(new DevelopCountry("en", "Canada", 2333233, "worse"));
        lc.add(new DevelopCountry("fn", "Mexico", 2333356, "bad"));
        lc.add(new DevelopCountry("gn", "Korea", 2333378, "bad"));
        lc.add(new DevelopCountry("hn", "Japan", 2333398, "nice"));
        lc.add(new DevelopCountry("ln", "Thailand", 2334333, "nice"));
        lc.add(new DevelopCountry("kn", "Malaysia", 2333673, "nice"));

    }

}
