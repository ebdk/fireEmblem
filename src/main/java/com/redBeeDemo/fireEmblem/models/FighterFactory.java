package com.redBeeDemo.fireEmblem.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class FighterFactory {
		
	@Autowired
	DaoFighter daoFighter;

	public FighterFactory() {
	}
	
	public Fighter createHarryPotter() {
		Weapon wpn = WeaponFactory.lookUpWeapon("The Sword of Gryffindor", 100, "Sword");
		Level lvl = LevelFactory.lookUpLvl("Apprentice");
		Fighter harryPotter = new Fighter(lvl, wpn, "Harry Potter", 60, 10, 1);
		daoFighter.save(harryPotter);
		return harryPotter;
	}
	public Fighter createElCid() {
		Weapon wpn = WeaponFactory.lookUpWeapon("Tizona", 40, "Sword");
		Level lvl = LevelFactory.lookUpLvl("Warrior");
		Fighter elCid = new Fighter(lvl, wpn, "El Cid", 90, 25, 2);
		daoFighter.save(elCid);
		return elCid;
	}
	public Fighter createKingArthur() {
		Weapon wpn = WeaponFactory.lookUpWeapon("Excalibur", 90, "Sword");
		Level lvl = LevelFactory.lookUpLvl("General");
		Fighter kingArthur = new Fighter(lvl, wpn, "King Arthur", 130, 30, 5);
		daoFighter.save(kingArthur);
		return kingArthur;
	}
	public Fighter createObiWan() {
		Weapon wpn = WeaponFactory.lookUpWeapon("Lightsaber", 200, "Sword");
		Level lvl = LevelFactory.lookUpLvl("God");
		Fighter obiWan = new Fighter(lvl, wpn, "Obi-wan", 250, 70, 15);
		daoFighter.save(obiWan);
		return obiWan;
	}
	
	public Fighter createFireFighter() {
		Weapon wpn = WeaponFactory.lookUpWeapon("Red Axe", 30, "Axe");
		Level lvl = LevelFactory.lookUpLvl("Apprentice");
		Fighter fireFighter = new Fighter(lvl, wpn, "Fire Fighter", 80, 15, 4);
		daoFighter.save(fireFighter);
		return fireFighter;
	}
	public Fighter createThief() {
		Weapon wpn = WeaponFactory.lookUpWeapon("Throwing axes", 20, "Axe");
		Level lvl = LevelFactory.lookUpLvl("Warrior");
		Fighter thief = new Fighter(lvl, wpn, "Thief", 60, 30, 1);
		daoFighter.save(thief);
		return thief;
	}
	public Fighter createGimli() {
		Weapon wpn = WeaponFactory.lookUpWeapon("Double-bladed Axe", 85, "Axe");
		Level lvl = LevelFactory.lookUpLvl("General");
		Fighter gimli = new Fighter(lvl, wpn, "Gimli", 200, 40, 10);
		daoFighter.save(gimli);
		return gimli;
	}
	public Fighter createThor() {
		Weapon wpn = WeaponFactory.lookUpWeapon("The Wrecker of Worlds", 175, "Axe"); //Espero que hayan visto Infinity War
		Level lvl = LevelFactory.lookUpLvl("God");
		Fighter thor = new Fighter(lvl, wpn, "Thor", 275, 80, 20);
		daoFighter.save(thor);
		return thor;
	}
	
	public Fighter createGuyWithStick() {
		Weapon wpn = WeaponFactory.lookUpWeapon("Stick", 10, "Spear");
		Level lvl = LevelFactory.lookUpLvl("Apprentice");
		Fighter guy = new Fighter(lvl, wpn, "Dude", 70, 10, 1);
		daoFighter.save(guy);
		return guy;
	}
	public Fighter createWarriorTribe() {
		Weapon wpn = WeaponFactory.lookUpWeapon("Battle Spear", 25, "Spear");
		Level lvl = LevelFactory.lookUpLvl("Warrior");
		Fighter warriorTribe = new Fighter(lvl, wpn, "Warrior Tribe", 90, 25, 3);
		daoFighter.save(warriorTribe);
		return warriorTribe;
	}
	public Fighter createArchangelMichael() {
		Weapon wpn = WeaponFactory.lookUpWeapon("The Spear of Archangel Michael", 50, "Spear");
		Level lvl = LevelFactory.lookUpLvl("General");
		Fighter archangelMichael = new Fighter(lvl, wpn, "Archangel Michael", 150, 30, 6);
		daoFighter.save(archangelMichael);
		return archangelMichael;
	}
	public Fighter createSunWukong() {
		Weapon wpn = WeaponFactory.lookUpWeapon("Monkey King Bar", 150, "Spear");
		Level lvl = LevelFactory.lookUpLvl("God");
		Fighter monkeyKing = new Fighter(lvl, wpn, "Sun Wukong", 230, 70, 15);
		daoFighter.save(monkeyKing);
		return monkeyKing;
	}

}
