import utils.*;
import accounts.*;

import java.io.IOException;

public class Main {

    static Login login;
    static Input input;

    static String[] level = {"viewer","true"};

    static boolean loggedOut;

    static UpdateAccounts updateAccounts;

    public static void main(String[] args) throws IOException {

        input = new Input();

        login = new Login();

        updateAccounts = new UpdateAccounts();

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

                if (commandType.equals("addUser")) {

                    try {

                        updateAccounts.addUser(commandWordArray[1], commandWordArray[2], commandWordArray[3]);

                    } catch (Exception e) {

                        System.err.println("Oops! You entered invalid input when adding a user!");

                    }

                }

                if (commandType.equals("remUser")) {

                    try {

                        updateAccounts.removeUser(commandWordArray[1]);

                    } catch (Exception e) {

                        System.err.println("Oops! You entered invalid input when removing a user!");

                    }

                }

                } catch (Exception e) {

                    System.err.println("Oops! You entered an invalid command!");

            }
        }

    }

 }
