package com.redBeeDemo.fireEmblem.models;

public class Simulator {
	
	//ATTRIBUTES
	private Fighter fighter1;
	private Fighter figther2;
	private static int gameNumber;
	private int turnNumber;
	
	//CONSTRUCTOR
	public Simulator() {
		this.turnNumber = 1;
	}
	
	//GETTERS AND SETTERS
	public Fighter getFighter1() {
		return fighter1;
	}
	public void setFighter1(Fighter fighter1) {
		this.fighter1 = fighter1;
	}
	public Fighter getFigther2() {
		return figther2;
	}
	public void setFigther2(Fighter figther2) {
		this.figther2 = figther2;
	}
	public static int getGameNumber() {
		return gameNumber;
	}
	public static void setGameNumber(int gameNumber) {
		Simulator.gameNumber = gameNumber;
	}
	public int getTurnNumber() {
		return turnNumber;
	}
	public void setTurnNumber(int turnNumber) {
		this.turnNumber = turnNumber;
	}
	
	/*public void initialize() {
		Level level1 = new Level("Apprentice", 5, 2);
		Level level2 = new Level("Apprentice", 5, 2);
		Level level3 = new Level("Apprentice", 5, 2);
		Level level4 = new Level("Apprentice", 5, 2);
	}*/
	

}
