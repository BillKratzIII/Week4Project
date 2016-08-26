package com.football;

import java.util.Scanner;

public class FantasyFootball {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean continueApp = true;
		String menuSelection = null;
		// TODO Auto-generated method stub
		DAO.refreshFromDB();
		do{
			System.out.println("What would you like to do?");
			printMenu();
			menuSelection = sc.nextLine();
			
			switch (menuSelection) {
			case "1":
				DAO.readFromDB();
				break;
			case "2":
				DAO.writeToDB();
				break;
			case "3":
				DAO.deleteFromDB();
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
			}
				
			
		}while(continueApp);
	}
	
	public static void printMenu(){
		System.out.println("1 - display all players");
		System.out.println("2 - add a player");
		System.out.println("3 - delete a player");
		System.out.println("4 - modify a player");
		System.out.println("5 - exit program");
	}

}
