package com.football;

public class StatLine {
	// declare variables
	String playerID = null;
	String label = null;
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

	// constructor
	public StatLine(String playerID, String label, int passingYards, int passingTDs, int passingINTs, int ruYards,
			int ruTDs, int receptions, int recYards, int recTDs, int retTDs, int twoPtConv, int fumbLost) {
		this.playerID = playerID;
		this.label = label;
		this.passingYards = passingYards;
		this.passingTDs = passingTDs;
		this.passingINTs = passingINTs;
		this.ruYards = ruYards;
		this.ruTDs = ruTDs;
		this.receptions = receptions;
		this.recYards = recYards;
		this.recTDs = recTDs;
		this.retTDs = retTDs;
		this.twoPtConv = twoPtConv;
		this.fumbLost = fumbLost;
	}// constructor()

	// default constructor
	public StatLine() {
	}

	// method returns player ID for stat-line
	public String getPlayerID() {
		return playerID;
	}

	// method sets player ID for stat-line
	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	// method returns label for stat-line
	public String getLabel() {
		return label;
	}

	// method sets lavel for stat-line
	public void setLabel(String label) {
		this.label = label;
	}

	// method returns passing yards for stat-line
	public int getPassingYards() {
		return passingYards;
	}

	// method sets passing yards for the stat-line
	public void setPassingYards(int passingYards) {
		this.passingYards = passingYards;
	}

	// method returns passing touchdowns for stat-line
	public int getPassingTDs() {
		return passingTDs;
	}

	// method sets passing touchdowns for stat-line
	public void setPassingTDs(int passingTDs) {
		this.passingTDs = passingTDs;
	}

	// method returns passing touchdowns for stat-line
	public int getPassingINTs() {
		return passingINTs;
	}

	// method sets passing interceptions for stat-line
	public void setPassingINTs(int passingINTs) {
		this.passingINTs = passingINTs;
	}

	// method returns rushing yards for stat-line
	public int getRuYards() {
		return ruYards;
	}

	// method sets rushing yards for stat-line
	public void setRuYards(int ruYards) {
		this.ruYards = ruYards;
	}

	// method returns rushing touchdowns for stat-line
	public int getRuTDs() {
		return ruTDs;
	}

	// method sets rushing tushing touchdowns for stat-line
	public void setRuTDs(int ruTDs) {
		this.ruTDs = ruTDs;
	}

	// method returns receptions for stat-line
	public int getReceptions() {
		return receptions;
	}

	// method sets receptions for stat-line
	public void setReceptions(int receptions) {
		this.receptions = receptions;
	}

	// method returns receiving yards for stat-line
	public int getRecYards() {
		return recYards;
	}

	// method sets receiving yards for stat-line
	public void setRecYards(int recYards) {
		this.recYards = recYards;
	}

	// method returns receiving touchdowns for stat-line
	public int getRecTDs() {
		return recTDs;
	}

	// method sets receiving touchdowns for stat-line
	public void setRecTDs(int recTDs) {
		this.recTDs = recTDs;
	}

	// method returns return touchdowns for stat-line
	public int getRetTDs() {
		return retTDs;
	}

	// method sets return touchdowns for stat-line
	public void setRetTDs(int retTDs) {
		this.retTDs = retTDs;
	}

	// method returns two point conversions for stat-line
	public int getTwoPtConv() {
		return twoPtConv;
	}

	// method sets two point conversions for stat-line
	public void setTwoPtConv(int twoPtConv) {
		this.twoPtConv = twoPtConv;
	}

	// method returns fumbles lost for stat-line
	public int getFumbLost() {
		return fumbLost;
	}

	// method sets fumbles lost for stat-line
	public void setFumbLost(int fumbLost) {
		this.fumbLost = fumbLost;
	}

	// method returns stat-line's attributes
	@Override
	public String toString() {
		return "StatLine [playerID=" + playerID + ", label=" + label + ", passingYards=" + passingYards
				+ ", passingTDs=" + passingTDs + ", passingINTs=" + passingINTs + ", ruYards=" + ruYards + ", ruTDs="
				+ ruTDs + ", receptions=" + receptions + ", recYards=" + recYards + ", recTDs=" + recTDs + ", retTDs="
				+ retTDs + ", twoPtConv=" + twoPtConv + ", fumbLost=" + fumbLost + "]";
	}

}// class
