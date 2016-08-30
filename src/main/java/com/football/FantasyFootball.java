package com.football;

import java.util.Scanner;

public class FantasyFootball {

	public static void main(String[] args) {
		// declare variables
		Scanner sc = new Scanner(System.in);
		boolean continueApp = true;
		String menuSelection = null;

		// connect and load info from DB
		DAO.refreshFromDB();

		// loop menu options as long as user wishes to continue
		do {
			System.out.println();
			System.out.println("What would you like to do?");
			printMenu();
			menuSelection = sc.nextLine();

			switch (menuSelection) {
			case "1":
				DAO.readFromDB();
				break;
			case "2":
				//DAO.writeToDB();
				break;
			case "3":
				//DAO.deleteFromDB();
				break;
			case "4":
				DAO.modifyInDB();
				break;
			case "5":
				System.out.println("Goodbye");
				continueApp = false;
				break;
			default:
				System.out.println("Not a valid selection, please try again.");
				break;
			}// switch

		} while (continueApp);
		// close scanner
		sc.close();
	}// main()

	// display menu options to the user
	public static void printMenu() {
		System.out.println("1 - display all players");
		System.out.println("2 - add a player");
		System.out.println("3 - delete a player");
		System.out.println("4 - modify a player");
		System.out.println("5 - exit program");
	}// printMenu()

}// class
