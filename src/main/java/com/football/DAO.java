package com.football;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";
	
	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET= null;
	
	public static void connToDB(){
		System.out.println("Connecting to DB...");
		
		try {
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");
		} catch (Exception e) {
			System.out.println("Failed to connect to the database.");
			e.printStackTrace();
		}
	}
	
	public static void readFromDB(){
		ArrayList<FantasyPlayer> allPlayers = new ArrayList<>();
		int counter = 0;
		DAO.connToDB();
		
		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM football.players;");
			
			while(RES_SET.next()){
				FantasyPlayer temp = new FantasyPlayer();
				String position = RES_SET.getString("position");
				
				if(position.equalsIgnoreCase("RB")||position.equalsIgnoreCase("WR")||position.equalsIgnoreCase("TE")){
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
			
			while(RES_SET.next()){
				int[] temp = new int[11];
				temp[0] = RES_SET.getInt("pa_yds");
				temp[1] = RES_SET.getInt("pa_tds");
				temp[2] = RES_SET.getInt("pa_int");
				temp[3] = RES_SET.getInt("ru_yds");
				temp[4] = RES_SET.getInt("ru_tds");
				temp[5] = RES_SET.getInt("receptions");
				temp[6] = RES_SET.getInt("rec_yds");
				temp[7] = RES_SET.getInt("rec_tds");
				temp[8] = RES_SET.getInt("ret_tds");
				temp[9] = RES_SET.getInt("two_pt_conv");
				temp[10] = RES_SET.getInt("fum_lost");
						
				
				allPlayers.get(counter).setTotals2015(temp);
				counter++;
			}
			
			//for each loop
			for(FantasyPlayer player : allPlayers){
				player.calcTotalScore();
				System.out.println(player.toString());
			}
			
			for (FantasyPlayer fantasyPlayer : allPlayers) {
				fantasyPlayer.printArray();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
