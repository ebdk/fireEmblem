package com.redBeeDemo.fireEmblem.models;

import java.util.ArrayList;
import java.util.List;

public class WeaponFactory {

	static List<Weapon> weapons = new ArrayList<Weapon>();

	public WeaponFactory() {
	}
	
	public static void setWeakness() {
		WeaponType swords = Sword.getInstance();
		WeaponType axes = Axe.getInstance();
		WeaponType spears = Spear.getInstance();
		
		swords.setWeakness(axes, spears);
		axes.setWeakness(spears, swords);
		spears.setWeakness(swords, axes);
	}
	
	public static Weapon createSword(String name, int attack) {
		Weapon sword = new Weapon(name, attack, Sword.getInstance());
		weapons.add(sword);
		return sword;
	}
	
	public static Weapon createAxe(String name, int attack) {
		Weapon axe = new Weapon(name, attack, Axe.getInstance());
		weapons.add(axe);
		return axe;
	}
	
	public static Weapon createSpear(String name, int attack) {
		Weapon spear = new Weapon(name, attack, Spear.getInstance());
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
		
	public static List<Weapon> getWeapons(){
		return weapons;
	}
	
	public static void printAllWeapons() {
		for(Weapon weapon : weapons) {
			System.out.println(weapon.getStats());
			System.out.println("---------------");
		}
	}
	
}
