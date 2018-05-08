package com.redBeeDemo.fireEmblem.models;

import java.util.ArrayList;
import java.util.List;


public class FighterFactory {
		
	static List<Fighter> fighters = new ArrayList<Fighter>();

	private FighterFactory() {
	}
	
	public static void createHarryPotter() {
		Weapon wpn = WeaponFactory.createSword("The Sword of Gryffindor", 100);
		Level lvl = LevelFactory.lookUpLvl("Apprentice");
		Fighter harryPotter = new Fighter(lvl, wpn, "Harry Potter", 180, 10, 1);
		fighters.add(harryPotter);
		//return elCid;
	}
	public static void createElCid() {
		Weapon wpn = WeaponFactory.createSword("Tizona", 40);
		Level lvl = LevelFactory.lookUpLvl("Soldier");
		Fighter elCid = new Fighter(lvl, wpn, "El Cid", 225, 25, 2);
		fighters.add(elCid);
		//return elCid;
	}	
	public static void createKingArthur() {
		Weapon wpn = WeaponFactory.createSword("Excalibur", 90);
		Level lvl = LevelFactory.lookUpLvl("General");
		Fighter kingArthur = new Fighter(lvl, wpn, "King Arthur", 260, 30, 5);
		fighters.add(kingArthur);
		//return kingArthur;
	}
	public static Fighter createObiWan() {
		Weapon wpn = WeaponFactory.createSword("Lightsaber", 200);
		Level lvl = LevelFactory.lookUpLvl("God");
		Fighter obiWan = new Fighter(lvl, wpn, "Obi-wan", 375, 70, 15);
		fighters.add(obiWan);
		return obiWan;
	}
	
	public static void createFireFighter() {
		Weapon wpn = WeaponFactory.createAxe("Red Axe", 30);
		Level lvl = LevelFactory.lookUpLvl("Apprentice");
		Fighter fireFighter = new Fighter(lvl, wpn, "Fire Fighter", 200, 15, 4);
		fighters.add(fireFighter);
		//return fireFighter;
	}
	
	public static void createThief() {
		Weapon wpn = WeaponFactory.createAxe("Throwing axes", 20);
		Level lvl = LevelFactory.lookUpLvl("Soldier");
		Fighter thief = new Fighter(lvl, wpn, "Thief", 240, 30, 1);
		fighters.add(thief);
		//return thief;
	}
	public static void createGimli() {
		Weapon wpn = WeaponFactory.createAxe("Double-bladed Axe", 85);
		Level lvl = LevelFactory.lookUpLvl("General");
		Fighter gimli = new Fighter(lvl, wpn, "Gimli", 300, 40, 10);
		fighters.add(gimli);
		//return gimli;
	}
	public static void createThor() {
		Weapon wpn = WeaponFactory.createAxe("The Wrecker of Worlds", 175); //Espero que hayan visto Infinity War
		Level lvl = LevelFactory.lookUpLvl("God");
		Fighter thor = new Fighter(lvl, wpn, "Thor", 340, 80, 20);
		fighters.add(thor);
		//return thor;
	}
	
	public static void createGuyWithStick() {
		Weapon wpn = WeaponFactory.createSpear("Stick", 10);
		Level lvl = LevelFactory.lookUpLvl("Apprentice");
		Fighter guy = new Fighter(lvl, wpn, "Dude", 210, 10, 1);
		fighters.add(guy);
		//return guy;
	}
	public static void createWarriorTribe() {
		Weapon wpn = WeaponFactory.createSpear("Battle Spear", 25);
		Level lvl = LevelFactory.lookUpLvl("Soldier");
		Fighter SoldierTribe = new Fighter(lvl, wpn, "Warrior Tribe", 230, 25, 3);
		fighters.add(SoldierTribe);
		//return SoldierTribe;
	}
	public static void createArchangelMichael() {
		Weapon wpn = WeaponFactory.createSpear("The Spear of Archangel Michael", 50);
		Level lvl = LevelFactory.lookUpLvl("General");
		Fighter archangelMichael = new Fighter(lvl, wpn, "Archangel Michael", 280, 30, 6);
		fighters.add(archangelMichael);
		//return archangelMichael;
	}
	public static void createSunWukong() {
		Weapon wpn = WeaponFactory.createSpear("Monkey King Bar", 150);
		Level lvl = LevelFactory.lookUpLvl("God");
		Fighter monkeyKing = new Fighter(lvl, wpn, "Sun Wukong", 310, 70, 15);
		fighters.add(monkeyKing);
		//return monkeyKing;
	}
	
	public static void createAll() {
		createHarryPotter();
		createElCid();
		createKingArthur();
		createObiWan();
		createFireFighter();
		createThief();
		createGimli();
		createThor();
		createGuyWithStick();
		createWarriorTribe();
		createArchangelMichael();
		createSunWukong();
	}
	
	public static void printAllFighters() {
		for(Fighter fighter : fighters) {
			fighter.printStats();
			System.out.println("---------------");
		}
	}
	
	public static List<Fighter> getFighters(){
		return fighters;
	}
	

}
