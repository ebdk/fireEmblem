package com.redBeeDemo.fireEmblem.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class LevelFactory {

	@Autowired
	static
	DaoLevel daoLevel;
	
	private static List<Level> levels;
	
	public LevelFactory() {
	}
	
	public static void createLevel(String name, int health, int attack, int defense, int position) {
		Level lvl = new Level(name, health, attack, defense, position);
		addLevel(lvl);
	}
	
	private static void addLevel(Level lvl) {
		int pos = lvl.getPosition();
		for(Level level : levels) {
			if(level.getPosition() >= pos) {
				level.setPosition(level.getPosition() + 1);
				daoLevel.save(lvl);
			}
		}
		levels.add(lvl);
		daoLevel.save(lvl);
	}

	public static void createAllLevels() {
		createLevel("None", 1, 0, -30, 0);
		createLevel("Apprentice", 100, 16, 3, 1);
		createLevel("Soldier", 150,  28, 6, 2);
		createLevel("General", 300, 44, 9, 3);
		createLevel("God", 750, 62, 18, 4);
	}
	
	public static Level lookUpLvl(String name) {
		Level lvl = null;
		List<Level> levels = daoLevel.findByname(name);
		if(levels.size()==0){		
			lvl = daoLevel.findByposition(0).get(0);
		} else {
			lvl = levels.get(0);
		}
		return lvl;
	}
	
	
	

}
