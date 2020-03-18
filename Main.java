import utils.*;
import accounts.*;

import java.io.IOException;

public class Main {

    static Login login;
    static Input input;

    static String[] level = {"viewer","true"};

    static boolean loggedOut;

    static UpdateAccounts updateAccounts;

    static UpdateInventory updateInventory;

    public static void main(String[] args) throws IOException {

        input = new Input();

        login = new Login();

        updateAccounts = new UpdateAccounts();

        updateInventory = new UpdateInventory();

        setLoggedOut();
/*
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.println(Constants.users[i][j]);

            }

        }
*/
        login();
        operate();

    }

    public static void login() throws IOException {

        while (loggedOut) {

            System.out.println("Enter username: ");
            String user = input.getInput();

            System.out.println("Enter password: ");
            String pass = input.getInput();

            level = login.login(user, pass);

            setLoggedOut();

        }
        
        System.out.println("You are currently a " + level[0]);

    }

    public static void setLoggedOut() {

        if (level[1].equals("true")) {

            loggedOut = true;

        } else {

            loggedOut = false;

        }

    }

    public static void operate() throws IOException {

        while (!loggedOut) {

            String command = input.getInput();

            String commandWordArray[] = command.substring(0, command.length()).split(" ");

            try {

                String commandType = commandWordArray[0];

                if (commandType.equals("help")) {}

                userCommands(commandType, commandWordArray);

                inventoryCommands(commandType, commandWordArray);

                } catch (Exception e) {

                    System.err.println("Oops! You entered an invalid command!");

            }
        }

    }

    public static void userCommands(String commandType, String[] commandWordArray) {

        if (commandType.equals("addUser")) {

            try {

                updateAccounts.addUser(commandWordArray[1], commandWordArray[2], commandWordArray[3]);

            } catch (Exception e) {

                System.err.println("Oops! You entered an invalid input when adding a user!");

           }

        }

        if (commandType.equals("remUser")) {

            try {

                updateAccounts.removeUser(commandWordArray[1]);

            } catch (Exception e) {

                System.err.println("Oops! You entered an invalid input when removing a user!");

            }

        }

    }

    public static void inventoryCommands(String commandType, String[] commandWordArray) {

        if (commandType.equals("addItem")) {

            try {

                updateInventory.addItem(commandWordArray[1], commandWordArray[2], commandWordArray[3], commandWordArray[4]);

            } catch (Exception e) {

                System.err.println("Oops! You entered an invalid input when adding an item!");

            }

        }

        if (commandType.equals("remItem")) {

            try {

                updateInventory.removeItem(commandWordArray[1]);

            } catch (Exception e) {

                System.err.println("Oops! You entered an invalid input when removing an item!");

            }

        }

        if (commandType.equals("purchase")) {

            int amount = 0;
            String cost = "";
            String unit = "";

            try {

                String[][] items = updateInventory.getItems();

                for (int i = 0; i < items.length; i++) {

                    if (items[i][0].equals(commandWordArray[1])) {

                        amount = Integer.parseInt(items[i][1]) - Integer.parseInt(commandWordArray[2]);
                        cost = items[i][2];
                        unit = items[i][3];

                    }

                }

                updateInventory.removeItem(commandWordArray[1]);
                updateInventory.addItem(commandWordArray[1], Integer.toString(amount), cost, unit);

            } catch (Exception e) {

                System.err.println("OOps! You entered an invalid input when purchasing an item!");

            }

        }

    }

 }
