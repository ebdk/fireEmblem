package com.redBeeDemo.fireEmblem.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "weapon")

public class Weapon {
	
	//ATTRIBUTES
	@Id
	@GeneratedValue
	private Long idWeapon;
	
	@ManyToOne()
	@JoinColumn(name = "weapontype_id")
	private WeaponType type;
	
	@OneToOne(mappedBy = "weapon")
	private Fighter user;
	
	private String name;
	private int attack;

	
	//CONSTRUCTOR
	public Weapon() {
	}
	public Weapon(String name, int attack, WeaponType type) {
		super();
		this.name = name;
		this.attack = attack;
		this.type = type;
	}


	//GETTERS AND SETTERS
	public Long getIdWeapon() {
		return idWeapon;
	}
	public void setIdWeapon(Long idWeapon) {
		this.idWeapon = idWeapon;
	}
	public Fighter getUser() {
		return user;
	}
	public void setUser(Fighter user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public WeaponType getType() {
		return type;
	}
	public void setType(WeaponType type) {
		this.type = type;
	}
	public int getWeakness(Weapon wpn) {
		int res = wpn.getType().getWeakness(wpn.getType());
		return res;
	}

	public String getStats() {
		return this.getName() + "'s type is " + this.getClass().toString() + " and can deal " + this.getAttack() + " damage."; 
	}

	
}
