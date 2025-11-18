package countries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;




public class CountryLIst extends JFrame {
    /** The label to display instructions. */
    private JLabel label;
    /** The button to trigger file reading. */
    private JButton button;
    /** The list to display the file contents. */
    private JList<String> list;


    /** The top panel containing the label. */
    private JPanel topPanel;
    /** The center panel containing the button. */
    private JPanel centerPanel;
    /** The bottom panel. */
    private JPanel bottomPanel;

// constructor to build GUI upon instantiation
    public CountryLIst() {

        setLayout(new BorderLayout());

        topPanel = new JPanel();
        centerPanel = new JPanel();

        // Create the label
        label = new JLabel("Click the button to display the file contents");

        // Create the button
        button = new JButton("Read File and Display Contents");
      // add Action listener here

    }// end of constructor






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
                    if (key.isBlank() || value.isBlank()) {
                        System.out.println("Ignoring entry with blank country or capital: " + oneLine);
                    } else {
                        countryMap.put(key, value);
                    }
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
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.toList());
     }// end of getCountryAndCapitalList

                           

    

}// end of class
