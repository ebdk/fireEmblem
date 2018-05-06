package com.redBeeDemo.fireEmblem.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class FighterFactory {
		
	static List<Fighter> fighters = new ArrayList<Fighter>();

	private FighterFactory() {
	}
	
	public static void createHarryPotter() {
		Weapon wpn = WeaponFactory.getWeapon("The Sword of Gryffindor", 100, "Sword");
		Level lvl = LevelFactory.lookUpLvl("Apprentice");
		Fighter harryPotter = new Fighter(lvl, wpn, "Harry Potter", 60, 10, 1);
		fighters.add(harryPotter);
		//return elCid;
	}
	public static void createElCid() {
		Weapon wpn = WeaponFactory.getWeapon("Tizona", 40, "Sword");
		Level lvl = LevelFactory.lookUpLvl("Soldier");
		Fighter elCid = new Fighter(lvl, wpn, "El Cid", 90, 25, 2);
		fighters.add(elCid);
		//return elCid;
	}
	
	public static Fighter createElCid2() {
		Weapon wpn = WeaponFactory.createSword("Tizona", 40);
		Level lvl = LevelFactory.getLvl("Soldier");
		Fighter elCid = new Fighter(lvl, wpn, "El Cid", 90, 25, 2);
		fighters.add(elCid);
		return elCid;
	}
	
	
	
	public static void createKingArthur() {
		Weapon wpn = WeaponFactory.getWeapon("Excalibur", 90, "Sword");
		Level lvl = LevelFactory.lookUpLvl("General");
		Fighter kingArthur = new Fighter(lvl, wpn, "King Arthur", 130, 30, 5);
		fighters.add(kingArthur);
		//return kingArthur;
	}
	public static Fighter createObiWan() {
		Weapon wpn = WeaponFactory.createSword("Lightsaber", 200);
		Level lvl = LevelFactory.lookUpLvl("God");
		Fighter obiWan = new Fighter(lvl, wpn, "Obi-wan", 250, 70, 15);
		fighters.add(obiWan);
		return obiWan;
	}
	
	public static void createFireFighter() {
		Weapon wpn = WeaponFactory.getWeapon("Red Axe", 30, "Axe");
		Level lvl = LevelFactory.lookUpLvl("Apprentice");
		Fighter fireFighter = new Fighter(lvl, wpn, "Fire Fighter", 80, 15, 4);
		fighters.add(fireFighter);
		//return fireFighter;
	}
	
	public static Fighter createFireFighter2() {
		Weapon wpn = WeaponFactory.createAxe("Red Axe", 30);
		Level lvl = LevelFactory.getLvl("Apprentice");
		Fighter fireFighter = new Fighter(lvl, wpn, "Fire Fighter", 80, 15, 4);
		fighters.add(fireFighter);
		return fireFighter;
	}
	
	public static void createThief() {
		Weapon wpn = WeaponFactory.getWeapon("Throwing axes", 20, "Axe");
		Level lvl = LevelFactory.lookUpLvl("Soldier");
		Fighter thief = new Fighter(lvl, wpn, "Thief", 60, 30, 1);
		fighters.add(thief);
		//return thief;
	}
	public static void createGimli() {
		Weapon wpn = WeaponFactory.getWeapon("Double-bladed Axe", 85, "Axe");
		Level lvl = LevelFactory.lookUpLvl("General");
		Fighter gimli = new Fighter(lvl, wpn, "Gimli", 200, 40, 10);
		fighters.add(gimli);
		//return gimli;
	}
	public static void createThor() {
		Weapon wpn = WeaponFactory.getWeapon("The Wrecker of Worlds", 175, "Axe"); //Espero que hayan visto Infinity War
		Level lvl = LevelFactory.lookUpLvl("God");
		Fighter thor = new Fighter(lvl, wpn, "Thor", 275, 80, 20);
		fighters.add(thor);
		//return thor;
	}
	
	public static void createGuyWithStick() {
		Weapon wpn = WeaponFactory.getWeapon("Stick", 10, "Spear");
		Level lvl = LevelFactory.lookUpLvl("Apprentice");
		Fighter guy = new Fighter(lvl, wpn, "Dude", 70, 10, 1);
		fighters.add(guy);
		//return guy;
	}
	public static void createWarriorTribe() {
		Weapon wpn = WeaponFactory.getWeapon("Battle Spear", 25, "Spear");
		Level lvl = LevelFactory.lookUpLvl("Soldier");
		Fighter SoldierTribe = new Fighter(lvl, wpn, "Warrior Tribe", 90, 25, 3);
		fighters.add(SoldierTribe);
		//return SoldierTribe;
	}
	public static void createArchangelMichael() {
		Weapon wpn = WeaponFactory.getWeapon("The Spear of Archangel Michael", 50, "Spear");
		Level lvl = LevelFactory.lookUpLvl("General");
		Fighter archangelMichael = new Fighter(lvl, wpn, "Archangel Michael", 150, 30, 6);
		fighters.add(archangelMichael);
		//return archangelMichael;
	}
	public static void createSunWukong() {
		Weapon wpn = WeaponFactory.getWeapon("Monkey King Bar", 150, "Spear");
		Level lvl = LevelFactory.lookUpLvl("God");
		Fighter monkeyKing = new Fighter(lvl, wpn, "Sun Wukong", 230, 70, 15);
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

}
