package com.redBeeDemo.fireEmblem.models;

public class Game {
	
	//ATTRIBUTES
	private Fighter fighter1;
	private Fighter figther2;
	private static int gameNumber;
	private int turnNumber;
	
	//CONSTRUCTOR
	public Game(Fighter fighter1, Fighter figther2) {
		super();
		this.fighter1 = fighter1;
		this.figther2 = figther2;
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
		Game.gameNumber = gameNumber;
	}
	public int getTurnNumber() {
		return turnNumber;
	}
	public void setTurnNumber(int turnNumber) {
		this.turnNumber = turnNumber;
	}
	
	
	

}
