package accounts;

import java.io.IOException;

import utils.*;

public class UpdateAccounts {

    String users;

    Editor editor;

    public UpdateAccounts() {

        editor = new Editor();

    }

    public void addUser(String user, String pass, String level) throws IOException {

        users = Scan.scan("C:/Users/Benjamin Broudy/OneDrive/Inventory Managment System/jsons/users.json");

        StringBuffer str = new StringBuffer(users);

        if (!(level.equals("admin") || level.equals("staff") || level.equals("guest"))) {

            System.err.println("Invalid level. Please enter one of the following: admin, staff, or guest.");

            return;

        }

        String newUser = "{        \"user\" : \"" + user + "\",        \"pass\" : \"" + pass + "\",        \"levl\" : \"" + level + "\"},";

        str.insert(1, newUser);

        editor.write("C:/Users/Benjamin Broudy/OneDrive/Inventory Managment System/jsons/users.json", str.toString());

    }

    public void removeUser(String user) throws IOException {

        users = Scan.scan("C:/Users/Benjamin Broudy/OneDrive/Inventory Managment System/jsons/users.json");

        int totalAccounts = usersReader.count(users) - 1;

        String pass = "";

        String level = "";

        String editedRaw = users;

        editedRaw = editedRaw.replaceAll(" ","");
        editedRaw = editedRaw.replaceAll("\\s+","");
        editedRaw = editedRaw.replaceAll("\"","");
        editedRaw = editedRaw.replaceAll("\t","");
        editedRaw = editedRaw.replaceAll("\\{","");
        editedRaw = editedRaw.replaceAll("\\}","");

        String[][] accountsArray = new String[totalAccounts][];
        
        int index = 0;

        int splitJsonIndex = 0;

        while (index < totalAccounts) {

            String[] splitJson = editedRaw.substring(0, editedRaw.length()).split(",");

            String[] commandValues = new String[3];

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[0] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[1] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            splitJson[splitJsonIndex] = splitJson[splitJsonIndex].substring(5, splitJson[splitJsonIndex].length());
            commandValues[2] = splitJson[splitJsonIndex];
            splitJsonIndex++;

            accountsArray[index] = commandValues;

            index++;

        }

        for (int i = 0; i < accountsArray.length; i++) {

            if (user.equals(accountsArray[i][0])) {

                pass = accountsArray[i][1];

                level = accountsArray[i][2];

            }

        }
        
        users = users.replace("{        \"user\" : \"" + user + "\",        \"pass\" : \"" + pass + "\",        \"levl\" : \"" + level + "\"},","");

        editor.write("C:/Users/Benjamin Broudy/OneDrive/Inventory Managment System/jsons/users.json", users);

    }

}