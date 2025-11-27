import countries.CountryLIst;
import countries.CountryProcessor;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Main class for the Country Information application.
 * This class provides a command-line menu for users to interact with country and capital data.
 * It allows users to display a list of countries, process country data, and search for countries.
 * @author stephan knappstein A01208242
 * @version 1.0
 */
public class Main {

    /**
     * The main entry point for the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        doSearches();
    }// end of main method

    /**
     * Displays the main menu and handles user input to navigate through the application's features.
     */
    public static void doSearches(){
        Scanner scanner = new Scanner(System.in);
        boolean mainMenu = true;

        while (mainMenu) {
            System.out.println("Assignment 2");
            System.out.println("Stephan Knappstein A01208242");
            System.out.println("===========================");
            System.out.println("1.Countries and Capitals");
            System.out.println("2.Countries Info");
            System.out.println("3.All Countries that start with");
            System.out.println("4.Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (option == 1)      {displayCountryList(); }
            else if (option == 2) {processCountries();}
            else if (option == 3) {allCountriesThatStartWith();}
            else if (option == 4) {
                mainMenu = false;
                System.out.println("Goodbye for now!");
                scanner.close();
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }//end of while loop
    }// end of doSearches()

    /**
     * Displays the list of countries and capitals in a GUI window.
     */
    public static void displayCountryList(){
        System.out.println("1.Countries and Capitals");
        CountryLIst countryList= new CountryLIst();
    }

    /**
     * Processes and displays various statistics about the countries,
     * such as the total number, the longest capital city name, and the shortest country name.
     */
    public static void processCountries(){
        System.out.println("2.Countries Info");
        CountryProcessor countryProcessor = new CountryProcessor();
        System.out.println("===========================");
        countryProcessor.printNumberOfCountries();
        System.out.println("===========================");
        countryProcessor.printLongestCapitalCity();
        System.out.println("===========================");
        countryProcessor.printShortestCountryName();
        System.out.println("===========================\n");
    }

    /**
     * Prompts the user for a letter and then prints all countries that start with that letter.
     */
    public static void allCountriesThatStartWith(){
        System.out.println("3.Please input letter to start search for All Countries that start with that letter: ");
        CountryProcessor countryProcessor = new CountryProcessor();
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine();
        countryProcessor.printAllCountriesThatStartWith(letter);
        System.out.println("===========================\n");
    }
}// end of Main class