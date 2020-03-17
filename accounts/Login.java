package accounts;

import utils.*;

public class Login {

	int accountAmounts;
	String[][] accounts;

	public Login() {

		accounts = Constants.getUsers(); 
		accountAmounts = accounts.length;

	}

	public String[] login(String user, String pass) {

		String[] returnValuesSecondary = {"viewer","true"};
		
		for (int i = 0; i < accountAmounts; i++) {

			if ((user.equals(accounts[i][0])) && (pass.equals(accounts[i][1]))) {

				String[] returnValues = {accounts[i][2],"false"};

				return returnValues;

			}

		}

		System.out.println("Incorrect username or password. Try again.");

		return returnValuesSecondary;

	}

	public String logout() {

		return "viewer";

	}


}