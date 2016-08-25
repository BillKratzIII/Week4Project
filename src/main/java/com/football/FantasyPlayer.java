package com.football;

import java.text.DecimalFormat;

public class FantasyPlayer {
	private String playerID = null;
	private String position = null;
	private String firstName = null;
	private String lastName = null;
	private String nflTeam = null;
	private String fantasyTeam = null;
	private int[] totals2015 = new int[11];
	private double totalPoints2015 = 0.0;
	private boolean flexEligible;
	
	public FantasyPlayer(String playerID, String position, String firstName, String lastName, String nflTeam,
			String fantasyTeam) {
		super();
		this.playerID = playerID;
		this.position = position;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nflTeam = nflTeam;
		this.fantasyTeam = fantasyTeam;
	}

	public FantasyPlayer() {
		super();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNflTeam() {
		return nflTeam;
	}

	public void setNflTeam(String nflTeam) {
		this.nflTeam = nflTeam;
	}

	public String getFantasyTeam() {
		return fantasyTeam;
	}

	public void setFantasyTeam(String fantasyTeam) {
		this.fantasyTeam = fantasyTeam;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getTotalPoints2015() {
		DecimalFormat numberFormat = new DecimalFormat("#.00"); 
		return numberFormat.format(totalPoints2015);
	}

	public void setTotals2015(int[] totals2015) {
		this.totals2015 = totals2015;
	}
	
	public void printArray(){
		for (int i =0; i<totals2015.length; i++) {
			System.out.print(totals2015[i] + ",");
		}
		System.out.println();
	}

	public String isFlexEligible() {
		if(this.flexEligible){
			return "is";
		}else{
			return "is not";
		}
	}

	public void setFlexEligible(boolean flexEligible) {
		this.flexEligible = flexEligible;
	}
	
	public void calcTotalScore(){
		totalPoints2015 += ((double)totals2015[0]/25);
		totalPoints2015 += ((double)totals2015[1]*4);
		totalPoints2015 -= (double)totals2015[2];
		totalPoints2015 += ((double)totals2015[3]/10);
		totalPoints2015 += ((double)totals2015[4]*6);
		totalPoints2015 += (double)totals2015[5];
		totalPoints2015 += ((double)totals2015[6]/10);
		totalPoints2015 += ((double)totals2015[7]*6);
		totalPoints2015 += ((double)totals2015[8]*6);
		totalPoints2015 += ((double)totals2015[9]*2);
		totalPoints2015 -= ((double)totals2015[10]*2);
	}

	@Override
	public String toString() {
		return "FantasyPlayer [playerID=" + playerID + ", 2015 total points="+ getTotalPoints2015() + ", position=" + position + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", nflTeam=" + nflTeam + ", fantasyTeam=" + fantasyTeam + " & " + isFlexEligible() + " flex eligible]";
	}

}
