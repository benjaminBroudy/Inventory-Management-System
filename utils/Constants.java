package utils;

public class Constants {

    static inventoryReader stock = new inventoryReader("C:/Users/Benjamin Broudy/OneDrive/Documents/GitHub/Inventory-Management-System/jsons/inventory.json");
    
    static usersReader accounts = new usersReader("C:/Users/Benjamin Broudy/OneDrive/Documents/GitHub/Inventory-Management-System/jsons/users.json");

    public static String[][] getInventory() {

        return stock.returnInventory();

    }

    public static String[][] getUsers() {

        return accounts.returnAccounts();

    }

}