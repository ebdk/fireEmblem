package com.redBeeDemo.fireEmblem.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class LevelFactory {

	static List<Level> levels = new ArrayList<Level>();
	
	private LevelFactory() {
	}
	
	private static void createLevel(String name, int health, int attack, int defense, int position) {
		Level lvl = new Level(name, health, attack, defense, position);
		addLevel(lvl);
	}
	
	private static void addLevel(Level lvl) {
		int pos = lvl.getPosition();
		for(Level level : levels) {
			if(level.getPosition() >= pos) {
				level.setPosition(level.getPosition() + 1);
			}
		}
		levels.add(lvl);
	}

	public static void createAll() {
		System.out.println("1");
		createLevel("None", 1, 0, -30, 0);
		createLevel("Apprentice", 100, 16, 3, 1);
		createLevel("Soldier", 150,  28, 6, 2);
		createLevel("General", 300, 44, 9, 3);
		createLevel("God", 750, 62, 18, 4);
		//createLevel("Intruder", 999, 999, 999, 0);
	}
	
	public static Level getLvl(String name) {
		Level lvl = lookUpLvl(name);		
		if(lvl.equals(null)){		
			lvl = lookUpLvl(0);
		}
		return lvl;
	}
	
	public static Level lookUpLvl(String name) {
		Level res = null;
		for(Level level : levels) {
			if(level.getName() == name) {
				res = level;
			}
		}
		return res;
	}
	
	public static Level lookUpLvl(int pos) {
		Level res = null;
		for(Level level : levels) {
			if(level.getPosition() == pos) {
				res = level;
			}
		}
		return res;
	}
	
	public static void printAllLevels() {
		for(Level level : levels) {
			System.out.println("Pos: " + level.getPosition() +" ---- " + "Name: " + level.getName());
		}
	}
	
	public static List<Level> getLevels(){
		return levels;
	}
	

}
