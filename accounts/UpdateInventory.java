package accounts;

import java.io.IOException;

import utils.*;

public class UpdateInventory {

    String inventory;

    Editor editor;

    public UpdateInventory() {

        editor = new Editor();

    }

    public void addItem(String item, String amount, String cost, String unit) throws IOException {

        inventory = Scan.scan("C:/Users/Benjamin Broudy/OneDrive/Documents/GitHub/Inventory-Management-System/jsons/inventory.json");

        StringBuffer str = new StringBuffer(inventory);
       
        String newItem = "{        \"item\" : \"" + item + "\",        \"amnt\" : \"" + amount + "\",        \"cost\" : \"" + cost + "\",        \"unit\" : \"" + unit + "\"},";
       
        str.insert(1, newItem);

        editor.write("C:/Users/Benjamin Broudy/OneDrive/Documents/GitHub/Inventory-Management-System/jsons/inventory.json", str.toString());

    }

    public void removeItem(String item) throws IOException {

        inventory = Scan.scan("C:/Users/Benjamin Broudy/OneDrive/Documents/GitHub/Inventory-Management-System/jsons/inventory.json");

        int totalItems = usersReader.count(inventory) - 1;

        String editedRaw = inventory;

        String amount = "";

        String cost = "";

        String unit = "";

        editedRaw = editedRaw.replaceAll(" ","");
        editedRaw = editedRaw.replaceAll("\\s+","");
        editedRaw = editedRaw.replaceAll("\"","");
        editedRaw = editedRaw.replaceAll("\t","");
        editedRaw = editedRaw.replaceAll("\\{","");
        editedRaw = editedRaw.replaceAll("\\}","");

        String[][] itemsArray = new String[totalItems][];
        
        int index = 0;

        int splitJsonIndex = 0;

        while (index < totalItems) {

            String[] splitJson = editedRaw.substring(0, editedRaw.length()).split(",");

            String[] commandValues = new String[4];

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[0] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[1] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[2] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[3] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            itemsArray[index] = commandValues;

            index++;

        }

        for (int i = 0; i < itemsArray.length; i++) {

            if (item.equals(itemsArray[i][0])) {

               amount = itemsArray[i][1];
               cost = itemsArray[i][2];
               unit = itemsArray[i][3];

            }

        }
        
        inventory = inventory.replace("{        \"item\" : \"" + item + "\",        \"amnt\" : \"" + amount + "\",        \"cost\" : \"" + cost + "\",        \"unit\" : \"" + unit + "\"},","");

        editor.write("C:/Users/Benjamin Broudy/OneDrive/Documents/GitHub/Inventory-Management-System/jsons/inventory.json", inventory);

    }

    public String[][] getItems() throws IOException {

        inventory = Scan.scan("C:/Users/Benjamin Broudy/OneDrive/Documents/GitHub/Inventory-Management-System/jsons/inventory.json");

        int totalItems = usersReader.count(inventory) - 1;

        String editedRaw = inventory;

        editedRaw = editedRaw.replaceAll(" ","");
        editedRaw = editedRaw.replaceAll("\\s+","");
        editedRaw = editedRaw.replaceAll("\"","");
        editedRaw = editedRaw.replaceAll("\t","");
        editedRaw = editedRaw.replaceAll("\\{","");
        editedRaw = editedRaw.replaceAll("\\}","");

        String[][] itemsArray = new String[totalItems][];
        
        int index = 0;

        int splitJsonIndex = 0;

        while (index < totalItems) {

            String[] splitJson = editedRaw.substring(0, editedRaw.length()).split(",");

            String[] commandValues = new String[4];

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[0] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[1] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[2] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[3] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            itemsArray[index] = commandValues;

            index++;

        }

        return itemsArray;

    }

}