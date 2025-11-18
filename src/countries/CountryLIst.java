package countries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;




public class CountryLIst extends JFrame {







    /**
     * Reads the contents of a file and returns them as a list of strings.
     *
     * @param file The file to read.
     * @return A list of strings, where each string is a line from the file.
     */
    public Map<String, String>  readFile(File file ) {
        Map<String, String> countryMap = new HashMap<>();
        String filePath = "resources"+File.separator+"countries-and-capitals.txt";
         file = new File(filePath);
        if (!file.exists()) {
            System.out.println("The file was not found.");
            System.exit(0);
        }

        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String oneLine = fileScanner.nextLine();
                String[] parts = oneLine.split(",",2 );
                if(parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    countryMap.put(key, value);
                } else { System.out.println("Ignoring malformed line: " + oneLine);}

            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        finally{
            if (fileScanner != null) {
                fileScanner.close();
            }
        }



        return countryMap;  }// end of readFile
    
    
     public List<String> getCountryAndCapitalList(Map<String, String> countryAndCapitalMap){
        return countryAndCapitalMap.entrySet().stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.toList());
     }// end of getCountryAndCapitalList

                           

    

}// end of class
