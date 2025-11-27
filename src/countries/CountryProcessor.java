package countries;

import countries.CountryLIst;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;



public class CountryProcessor  {

    private Map<String, String> countryAndCapitalMap;

    public CountryProcessor() {

        CountryLIst countryListInstance = new CountryLIst();
        // The readFile method in CountryLIst creates its own File object,
        // so we can pass a dummy File object or null if the method handles it.
        // Looking at CountryLIst.java, readFile creates its own File object internally.
        // So, passing null or any File object will work, as it's overwritten.
        // For clarity, let's pass a new File object, though its path won't be used.
        this.countryAndCapitalMap = countryListInstance.readFile( new File("dummy.txt"));

        if (!validateCountryAndCapitalMap(this.countryAndCapitalMap)) {
            throw new IllegalStateException("Country and Capital map cannot be null or empty.");
        }
    }

    /**
     * Validates if the provided map of countries and capitals is not null and not empty.
     *
     * @param map The map to validate.
     * @return true if the map is not null and not empty, false otherwise.
     */
    private static boolean validateCountryAndCapitalMap(Map<String, String> map) {
        return map != null && !map.isEmpty();
    }






}// end of class
