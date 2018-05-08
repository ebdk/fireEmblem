package com.redBeeDemo.fireEmblem.models;

public class Simulator {
	
	//ATTRIBUTES
	private static Fighter fighter1;
	private static Fighter figther2;
	private static int gameNumber = 0;
	private static int turnNumber = 1;
	
	//CONSTRUCTOR
	private Simulator() {
	}
	
	//GETTERS AND SETTERS
	public static Fighter getFighter1() {
		return fighter1;
	}
	public static void setFighter1(Fighter fighter1) {
		Simulator.fighter1 = fighter1;
	}
	public static Fighter getFigther2() {
		return figther2;
	}
	public static void setFigther2(Fighter figther2) {
		Simulator.figther2 = figther2;
	}
	public static int getGameNumber() {
		return gameNumber;
	}
	public static void setGameNumber(int gameNumber) {
		Simulator.gameNumber = gameNumber;
	}
	public static int getTurnNumber() {
		return turnNumber;
	}
	public static void setTurnNumber(int turnNumber) {
		Simulator.turnNumber = turnNumber;
	}
	
	public static boolean isInOddTurn() {
		boolean res;
		if((Simulator.getTurnNumber()%2)==0)
			   res = false;
			else
				res = true;
		return res;
	}
	
	public static void nextTurn() {
		Simulator.setTurnNumber(Simulator.getTurnNumber() + 1);
	}
	
	public static Fighter getWinner() {
		Fighter res = fighter1;
		if(fighter1.getHealth() == 0) {
			res = figther2;
		}
		return res;
	}
	public static Fighter getLoser() {
		Fighter res = figther2;
		if(fighter1.getHealth() == 0) {
			res = fighter1;
		}
		return res;
	}
	public static void endGame() {
		fighter1 = null;
		figther2 = null;
		turnNumber = 1;
		gameNumber++;
	}

}
