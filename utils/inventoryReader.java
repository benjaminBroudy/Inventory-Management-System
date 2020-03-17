package utils;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class inventoryReader {

    private File file;

    public String[][] accounts;

    public String[][] inventory;

    private Scanner reader;

    public static String raw;

    public static String editedRaw;

    // the base path for the json files will be home/lvuser/deploy/autopaths
    // then add /filename.json to the end
    public inventoryReader (String filePath) {

        // creates a blank raw string for later safety
        raw = "";

        // attempts to find the file and create a scanner to read it,
        try {

            file = new File(filePath);

            reader = new Scanner(file); 

            while(reader.hasNextLine()) {

                raw += reader.nextLine();

            }

        } catch (Exception e) {

            System.out.print("File not found: " + filePath);

        }

            inventory = this.getInventory();
        
    }


    public String[][] getInventory() {

        int totalAccounts = count(raw) - 1;

        editedRaw = raw;

        editedRaw = editedRaw.replaceAll(" ","");
        editedRaw = editedRaw.replaceAll("\\s+","");
        editedRaw = editedRaw.replaceAll("\"","");
        editedRaw = editedRaw.replaceAll("\t","");
        editedRaw = editedRaw.replaceAll("\\{","");
        editedRaw = editedRaw.replaceAll("\\}","");

        String[][] inventoryArray = new String[totalAccounts][];
        
        int index = 0;
        
        int splitJsonIndex = 0;

        while (index < totalAccounts) {

            String[] splitJson = editedRaw.substring(0, editedRaw.length()).split(",");

            String[] inventoryValues = new String[4];

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            inventoryValues[0] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            inventoryValues[1] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            inventoryValues[2] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            inventoryValues[3] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            inventoryArray[index] = inventoryValues;

            index++;

        }

        return inventoryArray;

    }

    public String[][] returnInventory() {

        return inventory;

    }

    public static int count(String s) 
    { 
  
        int braces = 0;

        Pattern pattern=Pattern.compile("\\{");
        Matcher matcher=pattern.matcher(s);
        
        while (matcher.find()) {

            braces++;

        }

        return braces;

    }

}