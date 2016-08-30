package com.football;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
	
	//set up constants for db constants
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	// declare other variables
	static ArrayList<FantasyPlayer> allPlayers = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);

	// method to connect to SQL database
	public static void connToDB() {
		System.out.println("Connecting to DB...");

		try {
			Class.forName(JDBC_DRIVER);
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");
		} catch (Exception e) {
			System.out.println("Failed to connect to the database.");
			e.printStackTrace();
		}
	}// connToDB()

	public static void readFromDB() {
		refreshFromDB();

		// for each loop: cal
		for (FantasyPlayer player : allPlayers) {
			//player.setTotalPoints2015(player.calcTotalScore((player.getStatLines(0))));
			System.out.println(player.toString());
		}

		for (FantasyPlayer fantasyPlayer : allPlayers) {
			System.out.println(fantasyPlayer.getStatLines(0).toString());
		}
	}//readFromDB()

	public static void writeToDB(FantasyPlayer player) {
		FantasyPlayer PlayerToAdd = new FantasyPlayer();
		PlayerToAdd = player;
		String playerID = null;

		connToDB();
		try {
			PREP_STMT = CONN.prepareStatement(insertToPlayerDB);

			PREP_STMT.setString(1, PlayerToAdd.getPosition());
			PREP_STMT.setString(2, PlayerToAdd.getFirstName());
			PREP_STMT.setString(3, PlayerToAdd.getLastName());
			PREP_STMT.setString(4, PlayerToAdd.getNflTeam());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		refreshFromDB();
		System.out.println(allPlayers.size());
		playerID = allPlayers.get((allPlayers.size() - 1)).getPlayerID();
		// playerID = PlayerToAdd.getPlayerID();
		//addStats(playerID);
		//refreshFromDB();
	}

	private static String insertToPlayerDB = "INSERT INTO `football`.`players`"
			+ "(position, first_name, last_name, nfl_team)" + " VALUES " + "(?, ?, ?, ?)";

	/*private static FantasyPlayer addPlayer() {
		FantasyPlayer PlayerToAdd = new FantasyPlayer();

		System.out.println("What is the players's last name?");
		PlayerToAdd.setLastName(sc.nextLine());
		System.out.println("What is the player's first name?");
		PlayerToAdd.setFirstName(sc.nextLine());
		System.out.println("What is the player's position?");
		PlayerToAdd.setPosition(sc.nextLine());
		System.out.println("What NFL team does the player play for?");
		PlayerToAdd.setNflTeam(sc.nextLine());

		return PlayerToAdd;
	}*/

	public static void addStats(StatLine sl) {
		int passingYards = 0;
		int passingTDs = 0;
		int passingINTs = 0;
		int ruYards = 0;
		int ruTDs = 0;
		int receptions = 0;
		int recYards = 0;
		int recTDs = 0;
		int retTDs = 0;
		int twoPtConv = 0;
		int fumbLost = 0;
		//String userInput = null;

		//System.out.println("Do you want to enter their 2015 stats? Enter Y or N");
		//userInput = sc.nextLine();
		//if (userInput.equalsIgnoreCase("Y")) {
		//	System.out.println("How many passing yards did the player have in 2015?");
		//	passingYards = Integer.parseInt(sc.nextLine());
		//	System.out.println("How many passing touchdowns did the player have in 2015?");
		//	passingTDs = Integer.parseInt(sc.nextLine());
		//	System.out.println("How many passing interceptions did the player have in 2015?");
		//	passingINTs = Integer.parseInt(sc.nextLine());
		//	System.out.println("How many rushing yards did the player have in 2015?");
		//	ruYards = Integer.parseInt(sc.nextLine());
		//	System.out.println("How many rushing touchdowns did the player have in 2015?");
		///	ruTDs = Integer.parseInt(sc.nextLine());
		//	System.out.println("How many receptions did the player have in 2015?");
		//	receptions = Integer.parseInt(sc.nextLine());
		//	System.out.println("How many receiving yards did the player have in 2015?");
		//	recYards = Integer.parseInt(sc.nextLine());
		//	System.out.println("How many receiving touch downs did the player have in 2015?");
		//	recTDs = Integer.parseInt(sc.nextLine());
		//	System.out.println("How many two point conversions did the player have in 2015?");
		//	twoPtConv = Integer.parseInt(sc.nextLine());
		//	System.out.println("How many fumbles lost did the player have in 2015?");
		//	fumbLost = Integer.parseInt(sc.nextLine());
		//}

		connToDB();
		try {
			PREP_STMT = CONN.prepareStatement(insertTo2015StatsDB);
			PREP_STMT.setString(1, sl.getPlayerID());
			PREP_STMT.setInt(2, sl.getPassingYards());
			PREP_STMT.setInt(3, sl.getPassingTDs());
			PREP_STMT.setInt(4, sl.getPassingINTs());
			PREP_STMT.setInt(5,sl.getRuYards());
			PREP_STMT.setInt(6, sl.getRuTDs());
			PREP_STMT.setInt(7, sl.getReceptions());
			PREP_STMT.setInt(8, sl.getRecYards());
			PREP_STMT.setInt(9, sl.getRetTDs());
			PREP_STMT.setInt(10, sl.getRetTDs());
			PREP_STMT.setInt(11, sl.getTwoPtConv());
			PREP_STMT.setInt(12, sl.getFumbLost());

			PREP_STMT.executeUpdate();
			System.out.println("Player sucessfully added.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		refreshFromDB();
	}

	private static String insertTo2015StatsDB = "INSERT INTO `football`.`2015_stats`"
			+ "(player_id, pa_yds, pa_tds, pa_int, ru_yds, ru_tds, receptions, rec_yds, rec_tds, ret_tds, two_pt_conv, fum_lost)"
			+ " VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	/*
	 * private static String getPlayerID(FantasyPlayer player){ connToDB();
	 * String playerID = null; String playerIDFromDB =
	 * "SELECT * FROM football.players WHERE last_name like " +
	 * "(?) AND first_name like (?);"; System.out.println(playerIDFromDB); try {
	 * STMT = CONN.createStatement(); RES_SET =
	 * STMT.executeQuery(playerIDFromDB); playerID =
	 * RES_SET.getString("player_id"); System.out.println(playerID);
	 * }catch(SQLException e){ e.printStackTrace(); }
	 * 
	 * return playerID; }
	 */

	private static String deleteFromDB1 = "DELETE FROM `football`.`2015_stats`" + "WHERE" + "(player_id)" + "= (?)";

	private static String deleteFromDB2 = "DELETE FROM `football`.`players`" + "WHERE" + "(player_id)" + "= (?)";

	/*public static FantasyPlayer aboutPlayerToDelete() {
		FantasyPlayer playerToDelete = new FantasyPlayer();

		System.out.println("What is the last name of the player you wish to delete?");
		playerToDelete.setLastName(sc.nextLine());
		System.out.println("What is the first name of the player you wish to delete?");
		playerToDelete.setFirstName(sc.nextLine());

		return playerToDelete;
	}// end method*/

	public static void deleteFromDB(FantasyPlayer player) {
		FantasyPlayer playerToDelete = new FantasyPlayer();
		playerToDelete = player;
		String playerIDToDelete = null;
		
		refreshFromDB();

		for (int i = 0; i < allPlayers.size(); i++) {
			if (playerToDelete.getLastName().equalsIgnoreCase(allPlayers.get(i).getLastName())
					&& playerToDelete.getFirstName().equalsIgnoreCase(allPlayers.get(i).getFirstName())) {
				playerIDToDelete = allPlayers.get(i).getPlayerID();
				System.out.println("found player");
			}
		}

		if (playerIDToDelete == null) {
			System.out.println("No player found by that name.");
		} else {
			System.out.println(playerIDToDelete);

			connToDB();

			try {
				PREP_STMT = CONN.prepareStatement(deleteFromDB1);
				PREP_STMT.setString(1, playerIDToDelete);
				PREP_STMT.executeUpdate();
				PREP_STMT = CONN.prepareStatement(deleteFromDB2);
				PREP_STMT.setString(1, playerIDToDelete);
				PREP_STMT.executeUpdate();
				System.out.println("Player deleted");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			refreshFromDB();
		}
	}// end method

	private static String modifyInDB = "UPDATE `football`.`players`" + " SET " + "nfl_team " + "= ? " + "WHERE "
			+ "player_id " + "= ?";

	public static void modifyInDB() {
		FantasyPlayer playerToModify = new FantasyPlayer();
		playerToModify = modifyPlayer();
		String playerIDToModify = null;
		String newTeam = null;

		for (int i = 0; i < allPlayers.size(); i++) {
			if (playerToModify.getLastName().equalsIgnoreCase(allPlayers.get(i).getLastName())
					&& playerToModify.getFirstName().equalsIgnoreCase(allPlayers.get(i).getFirstName())) {
				playerIDToModify = allPlayers.get(i).getPlayerID();
				System.out.println("found player");
			}
		}

		if (playerIDToModify == null) {
			System.out.println("No player found by that name.");
		} else {
			System.out.println("Player found");
			System.out.println(playerIDToModify);
			System.out.println("What is the new NFL team for this player?");
			newTeam = sc.nextLine();
			connToDB();

			try {
				PREP_STMT = CONN.prepareStatement(modifyInDB);

				PREP_STMT.setString(1, newTeam);
				PREP_STMT.setString(2, playerIDToModify);

				PREP_STMT.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			refreshFromDB();
		}
	}

	public static FantasyPlayer modifyPlayer() {
		FantasyPlayer playerToModify = new FantasyPlayer();

		System.out.println("What is the last name of the player you wish to modify?");
		playerToModify.setLastName(sc.nextLine());
		System.out.println("What is the first name of the player you wish to modify?");
		playerToModify.setFirstName(sc.nextLine());

		return playerToModify;
	}

	public static void refreshFromDB() {
		allPlayers.clear();
		int counter = 0;
		connToDB();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM football.players;");

			while (RES_SET.next()) {
				FantasyPlayer temp = new FantasyPlayer();
				String position = RES_SET.getString("position");

				if (position.equalsIgnoreCase("RB") || position.equalsIgnoreCase("WR")
						|| position.equalsIgnoreCase("TE")) {
					temp.setFlexEligible(true);
				}

				temp.setPlayerID(RES_SET.getString("player_id"));
				temp.setPosition(position);
				temp.setLastName(RES_SET.getString("last_name"));
				temp.setFirstName(RES_SET.getString("first_name"));
				temp.setNflTeam(RES_SET.getString("nfl_team"));
				temp.setFantasyTeam(RES_SET.getString("fantasy_team"));
				allPlayers.add(temp);
			}

			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM football.2015_stats;");

			while (RES_SET.next()) {
				StatLine sl = new StatLine();
				sl.setPlayerID(allPlayers.get(counter).getPlayerID());
				sl.setLabel("totals2015");
				sl.setPassingYards(RES_SET.getInt("pa_yds"));
				sl.setPassingTDs(RES_SET.getInt("pa_tds"));
				sl.setPassingINTs(RES_SET.getInt("pa_int"));
				sl.setRuYards(RES_SET.getInt("ru_yds"));
				sl.setRuTDs(RES_SET.getInt("ru_tds"));
				sl.setReceptions(RES_SET.getInt("receptions"));
				sl.setRecYards(RES_SET.getInt("rec_yds"));
				sl.setRecTDs(RES_SET.getInt("rec_tds"));
				sl.setRetTDs(RES_SET.getInt("ret_tds"));
				sl.setTwoPtConv(RES_SET.getInt("two_pt_conv"));
				sl.setFumbLost(RES_SET.getInt("fum_lost"));

				allPlayers.get(counter).addStatLines(sl);
				allPlayers.get(counter).setTotalPoints2015(allPlayers.get(counter).calcTotalScore((sl)));
				allPlayers.get(counter).addToHashMap("2015 total fantasy points",
						allPlayers.get(counter).getTotalPoints2015());
				counter++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getNewPlayerID(){
		System.out.println(allPlayers.size());
		return allPlayers.get((allPlayers.size() - 1)).getPlayerID();
	}

}
