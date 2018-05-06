package com.redBeeDemo.fireEmblem.models;

public class Simulator {
	
	//ATTRIBUTES
	private Fighter fighter1;
	private Fighter figther2;
	private static int gameNumber;
	private static int turnNumber;
	private static FighterFactory fighterFactory;
	private static LevelFactory levelFactory;
	private static WeaponFactory weaponFactory;
	
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
	
	

}
