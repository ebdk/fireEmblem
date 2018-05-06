package com.redBeeDemo.fireEmblem.models;

import org.springframework.beans.factory.annotation.Autowired;

public class WeaponFactory {

	@Autowired
	DaoWeapon daoWeapon;

	public WeaponFactory() {
	}
	
	public void createSword(String name, int attack) {
		Weapon sword = new Weapon(name, attack, "Sword");
		daoWeapon.save(sword);
		//return sword;
	}
	
	public void createAxe(String name, int attack) {
		Weapon axe = new Weapon(name, attack, "Axe");
		daoWeapon.save(axe);
		//return axe;
	}
	
	public void createSpear(String name, int attack) {
		Weapon spear = new Weapon(name, attack, "Spear");
		daoWeapon.save(spear);
		//return spear;
	}
}
