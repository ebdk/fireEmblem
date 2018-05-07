package com.redBeeDemo.fireEmblem.models;

import java.util.ArrayList;
import java.util.List;

public class WeaponFactory {

	static List<Weapon> weapons = new ArrayList<Weapon>();

	public WeaponFactory() {
	}
	
	public static Weapon createSword(String name, int attack) {
		Weapon sword = new Weapon(name, attack, "Sword");
		weapons.add(sword);
		return sword;
	}
	
	public static Weapon createAxe(String name, int attack) {
		Weapon axe = new Weapon(name, attack, "Axe");
		weapons.add(axe);
		return axe;
	}
	
	public static Weapon createSpear(String name, int attack) {
		Weapon spear = new Weapon(name, attack, "Spear");
		weapons.add(spear);
		return spear;
	}
	
	public static Weapon getWeapon(String name, int attack, String type) {
		Weapon wpn = lookUpWpn(name);
		if(wpn.equals(null)){		
			switch(type){
				case "Sword":
					wpn = createSword(name, attack);
					break;
				case "Axe":
					wpn = createAxe(name, attack);
					break;
				case "Spear":
					wpn = createSpear(name, attack);
					break;
			}
		} 
		return wpn;
	}
	
	public static Weapon lookUpWpn(String name) {
		Weapon res = null;
		for(Weapon wpn : weapons) {
			if(wpn.getName().equals(name)) {
				res = wpn;
			}
		}
		return res;
	}
	
	public static String lookUpWeakness(String attackerWpn, String defenderWpn) {
		String res = "";
		if(attackerWpn == defenderWpn) {
			res = "Equal";
		} else {
			switch(attackerWpn) {
				//WEAPON: SWORD, STRONG AGAINST AXE BUT WEAK AGAINST SPEAR
				case "Sword":
					switch(defenderWpn) {
						case "Axe": 
							res = "Strong";
							break;
						case "Spear":
							res = "Weak";
							break;
					}
					break;
					
				//WEAPON: AXE, STRONG AGAINST SPEAR BUT WEAK AGAINST SWORD
				case "Axe":
					switch(defenderWpn) {
						case "Sword": 
							res = "Weak";
							break;
						case "Spear":
							res = "Strong";
							break;
					}
					break;
					
				//WEAPON: SPEAR, STRONG AGAINST SWORD BUT WEAK AGAINST AXE
				case "Spear":
					switch(defenderWpn) {
						case "Axe": 
							res = "Weak";
							break;
						case "Sword":
							res = "Strong";
							break;
					}
					break;
			}
		}
		return res;
	}
	
	public static List<Weapon> getWeapons(){
		return weapons;
	}
	
	public static void printAllWeapons() {
		for(Weapon weapon : weapons) {
			weapon.printStats();
			System.out.println("---------------");
		}
	}
	
}
