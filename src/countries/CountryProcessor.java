package countries;

import countries.CountryLIst;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;



public class CountryProcessor  {

    private Map<String, String> countryAndCapitalMap;

    public CountryProcessor() {
        // The readFile method in CountryLIst is now static, so we can call it directly.
        // We still need to pass a File object, but its path is not used.
        this.countryAndCapitalMap = CountryLIst.readFile(new File("dummy.txt"));

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

// printNumberOfCountries
    public void printNumberOfCountries() {
        int numberOfCountries = countryAndCapitalMap.size();
        System.out.println("Number of countries: " + numberOfCountries);
    }// end of printNumberOfCountries

    /*public List<String> getCountryAndCapitalList(Map<String, String> countryAndCapitalMap){
        return countryAndCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.toList());
     }/ */
    public void printLongestCapitalCity(){
        String longestCapital = countryAndCapitalMap.values().stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("No capital cities found.");
        System.out.println("Longest capital city: " + longestCapital);
    }// end of method


    public void printShortestCountryName(){
        countryAndCapitalMap.keySet().stream()
                .min(Comparator.comparingInt(String::length))
                .ifPresent(shortestCountry -> System.out.println("Shortest country name: " + shortestCountry));
    }// end of method

   public void printAllCountriesThatStartWith(String letter){
        List<String> matchingCountries = countryAndCapitalMap.keySet().stream()
                .filter(country -> country.toLowerCase().startsWith(letter.toLowerCase()))
                .collect(Collectors.toList());

        matchingCountries.forEach(System.out::println);
   }// end of method



}// end of class
