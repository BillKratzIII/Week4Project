package com.football;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FantasyPlayer {
	// declare variables
	private String playerID = null;
	private String position = null;
	private String firstName = null;
	private String lastName = null;
	private String nflTeam = null;
	private String fantasyTeam = null;
	private ArrayList<StatLine> statLines = new ArrayList<>();
	private double totalPoints2015 = 0;
	private boolean flexEligible;
	private HashMap summary = new HashMap();

	// constructor
	public FantasyPlayer(String playerID, String position, String firstName, String lastName, String nflTeam,
			String fantasyTeam) {
		this.playerID = playerID;
		this.position = position;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nflTeam = nflTeam;
		this.fantasyTeam = fantasyTeam;
	}

	// default constructor
	public FantasyPlayer() {
	}

	// method returns player's position
	public String getPosition() {
		return position;
	}

	// method sets player's position
	public void setPosition(String position) {
		this.position = position;
	}

	// method returns player's first name
	public String getFirstName() {
		return firstName;
	}

	// method sets player's first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// method returns player's last name
	public String getLastName() {
		return lastName;
	}

	// method set's players last name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// method returns players NFL team
	public String getNflTeam() {
		return nflTeam;
	}

	// method set's players NFL team
	public void setNflTeam(String nflTeam) {
		this.nflTeam = nflTeam;
	}

	// method returns players fantasy team
	public String getFantasyTeam() {
		return fantasyTeam;
	}

	// method set's players fantasy team
	public void setFantasyTeam(String fantasyTeam) {
		this.fantasyTeam = fantasyTeam;
	}

	// method set's players ID
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	// method returns players total fantasy points for 2015
	public String getTotalPoints2015() {
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		return numberFormat.format(totalPoints2015);
	}

	// method calls to return all attributes for a particular stat line they
	// have
	public void print2015Stats() {
		statLines.get(0).toString();
	}

	// method returns 'is' if they are flex eligible and 'is not' if not flex
	// eligible
	public String isFlexEligible() {
		if (this.flexEligible) {
			return "is";
		} else {
			return "is not";
		}
	}

	// method returns player's ID
	public String getPlayerID() {
		return playerID;
	}

	// method set's flex eligibility
	public void setFlexEligible(boolean flexEligible) {
		this.flexEligible = flexEligible;
	}

	// method returns stat-line from array list
	public StatLine getStatLines(int i) {
		return statLines.get(i);
	}

	// method adds stat-line to the array list
	public void addStatLines(StatLine sl) {
		this.statLines.add(sl);
	}

	// method set's totalpointsfor2015 year
	public void setTotalPoints2015(double totalPoints2015) {
		this.totalPoints2015 = totalPoints2015;
	}

	// method calculates and returns a total score for a give stat-line
	public double calcTotalScore(StatLine sl) {
		double total = 0;
		total += ((double) sl.getPassingYards() / 25);// 1pt per 25 passing
														// yards
		total += ((double) sl.getPassingTDs() * 4);// 4pts per passing touchdown
		total -= (double) sl.getPassingINTs();// -1pt per passing interception
		total += ((double) sl.getRuYards() / 10);// 1pt per 10 rushing yards
		total += ((double) sl.getRuTDs() * 6);// 6pts per rushing touchdown
		total += (double) sl.getReceptions();// 1pt per reception
		total += ((double) sl.getRecYards() / 10);// 1pt per 10 receiving yards
		total += ((double) sl.getRecTDs() * 6);// 6pts per receiving touchdown
		total += ((double) sl.getRetTDs() * 6);// 6pts per return touchdown
		total += ((double) sl.getTwoPtConv() * 2);// 2pts per two point
													// conversion
		total -= ((double) sl.getFumbLost() * 2);// -2pts per fumble lost
		return total;
	}// calcTotalScore()
	
	//method to add total scores to hash map
	public void addToHashMap(String label, double total){
		summary.put(label, total);
	}
	
	//method to print total scores contained in the hash map
	public void printSummary(){
		Set set = summary.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         System.out.print(me.getKey() + ": ");
	         System.out.println(me.getValue());
	      }
	      System.out.println();
	}//printSummary()

	// method to display player attributes to user
	@Override
	public String toString() {
		return "playerID=" + playerID + ", 2015 total points=" + getTotalPoints2015() + ", position=" + position
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", NFL Team=" + nflTeam + ", Fantasy Team="
				+ fantasyTeam + " & " + isFlexEligible() + " flex eligible";
	}// toString()

}// class
