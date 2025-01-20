package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.nio.file.Paths;
import java.awt.Desktop;


public class csvWriter {
    public csvWriter() {
    }

    ArrayList<String[]> dataToBeWritten = new ArrayList<>();

    public String createOutputFilePath(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
        String formattedDate = currentDate.format(formatter); // get local date
        String currentFilePath = Paths.get("").toAbsolutePath().toString(); // get current file location

        return currentFilePath + "\\src\\main\\output\\" + formattedDate + ".csv";
    }

    private final String csvFile = createOutputFilePath();
    private String grade;


    public ArrayList<String[]> getCollectedData(){
        return dataToBeWritten;
    }

    public void collectData(){ // method used to consolidate webScraped data and put it into an arrayList to be written to csv file
        links FULinks = new links(); // instantiate my links
        LinkedList<String[]> links = FULinks.getList(); // create a local instance of frequently used links
        scraper myScraper; // declaring scraper and temp variables
        String[] tempArr;


        for(int i =0 ; i < links.size(); i++){
            if(links.get(i)[0].contains("pricecharting")){
                myScraper = new scraper(links.get(i)[0], links.get(i)[1]);
            }
            else {
                myScraper = new scraper(links.get(i)[0]); // new scraper object with current link
            }
            tempArr = myScraper.getInfo(); // get array for current url
            System.out.println(Arrays.toString(tempArr) + " " + myScraper.getTotalPrice()); // remove later, checking if getting data
            dataToBeWritten.add(tempArr); //
        }

    }

    public void writeToCSV(){
        collectData();

        // if list is empty
        if(dataToBeWritten.isEmpty()){
            System.out.println("data to be written is empty");
            return;
        }

        try(FileWriter writer = new FileWriter(csvFile)){
            writer.append("productName,productPrice,grade\n");

            for(String[] row : dataToBeWritten){
                writer.append(String.join(",", row));
                writer.append("\n");
            }
            scraper tempScraper = new scraper();
            writer.append("total price: $").append(String.valueOf(tempScraper.getTotalPrice()));

            System.out.println("successfully written to file");
            if(Desktop.isDesktopSupported()){
                Desktop.getDesktop().open(new File(csvFile));
            }
        }catch (IOException e){
            System.out.println("Failed to write to file. " + e.getMessage());
        }




    }
}
