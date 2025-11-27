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


/**
 * A JFrame application that displays a list of countries and their capitals.
 * The data is read from a text file, and the list is displayed in a scrollable JList.
 * The list is sorted alphabetically by country name.
 * @author stephan Knappstein A01208242
 * @version 1.0
 */
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


    /**
     * Constructs the GUI for the application.
     * Initializes the frame, panels, button, and list.
     * The list is made scrollable and placed at the bottom of the frame.
     */
    public CountryLIst() {
       File file = new File("resources"+File.separator+"countries-and-capitals.txt");
        setLayout(new BorderLayout());

        topPanel = new JPanel();
        centerPanel = new JPanel();

        // Create the label
        label = new JLabel("Click the button to display the file contents");

        // Create the button
        button = new JButton("Read File and Display Contents");
        list = new JList<String>();
      // add Action listener here
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String[] countriesAndCapitals = getCountryAndCapitalList(readFile(file)).toArray(new String[0]);
                 list.setListData(countriesAndCapitals);
            }});
        topPanel.add(label);
        centerPanel.add(button);
        //Add the panel to the top of the frame



        //frame.setSize(400,400); --> not necessary. JFrame is being extended n
        setSize(400, 250);
        setLocation(500,500);
        add( topPanel , BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, BorderLayout.SOUTH);
        setVisible(true);
    }// end of constructor


    /**
     * Reads a file containing countries and their capitals, separated by a comma.
     * It validates the data to ensure that neither the country nor the capital is blank.
     *
     * @param file The file to read from.
     * @return A map where the key is the country and the value is the capital.
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


    /**
     * Converts a map of countries and capitals into a sorted list of strings.
     * The list is sorted alphabetically by country name.
     *
     * @param countryAndCapitalMap A map of countries and their capitals.
     * @return A sorted list of strings, where each string is in the format "Country : Capital".
     */
     public List<String> getCountryAndCapitalList(Map<String, String> countryAndCapitalMap){
        return countryAndCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .collect(Collectors.toList());
     }// end of getCountryAndCapitalList

}// end of class
