import countries.CountryLIst;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        doSearches();
    }// end of main method
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
            // General queries will present the General Queries menu
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
    public static void displayCountryList(){
        System.out.println("1.Countries and Capitals");
        CountryLIst countryList= new CountryLIst();
        }
    public static void processCountries(){System.out.println("2.Countries Info");}
    public static void allCountriesThatStartWith(){System.out.println("3.All Countries that start with");}


}// end of Main class