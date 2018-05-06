package com.redBeeDemo.fireEmblem.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class WeaponFactory {

	@Autowired
	static
	DaoWeapon daoWeapon;

	public WeaponFactory() {
	}
	
	public static Weapon createSword(String name, int attack) {
		Weapon sword = new Weapon(name, attack, "Sword");
		daoWeapon.save(sword);
		return sword;
	}
	
	public static Weapon createAxe(String name, int attack) {
		Weapon axe = new Weapon(name, attack, "Axe");
		daoWeapon.save(axe);
		return axe;
	}
	
	public static Weapon createSpear(String name, int attack) {
		Weapon spear = new Weapon(name, attack, "Spear");
		daoWeapon.save(spear);
		return spear;
	}
	
	public static Weapon lookUpWeapon(String name, int attack, String type) {
		Weapon wpn = null;
		List<Weapon> weapons = daoWeapon.findByname(name);
		if(weapons.size()==0){		
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
		} else {
			wpn = weapons.get(0);
		}
		return wpn;
	}
	
	public static double lookUpWeakness(String attackerWpn, String defenderWpn) {
		double res = 0;
		switch(attackerWpn) {
			case "Sword":
				switch(defenderWpn){
					case "Sword": 
						res = 1;
						break;
					case "Axe": 
						res = 2;
						break;
					case "Spear": 
						res = 0.5;
						break;
				}
			case "Axe":
				switch(defenderWpn){
					case "Sword": 
						res = 0.5;
						break;
					case "Axe": 
						res = 1;
						break;
					case "Spear": 
						res = 2;
						break;
				}
			case "Spear":
				switch(defenderWpn){
					case "Sword": 
						res = 2;
						break;
					case "Axe": 
						res = 0.5;
						break;
					case "Spear": 
						res = 1;
						break;
				}
		}
		return res;
	}
	
}
