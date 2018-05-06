package com.redBeeDemo.fireEmblem.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	public static double lookUpWeakness(String attackerWpn, String defenderWpn) {
		double res = 1;
		if(attackerWpn == defenderWpn) {
			res = 1;
		} else {
			switch(attackerWpn) {
			case "Sword":
				switch(defenderWpn){
					case "Axe": 
						res = 0.5;
						break;
					case "Spear": 
						res = 2;
						break;
				}
			case "Axe":
				switch(defenderWpn){
					case "Sword": 
						res = 2;
						break;
					case "Spear": 
						res = 0.5;
						break;
				}
			case "Spear":
				switch(defenderWpn){
					case "Sword": 
						res = 0.5;
						break;
					case "Axe": 
						res = 2;
						break;
				}
		}
		}
		
		return res;
	}
	
}
