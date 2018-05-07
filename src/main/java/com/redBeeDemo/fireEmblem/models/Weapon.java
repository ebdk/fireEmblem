package com.redBeeDemo.fireEmblem.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@OneToOne(mappedBy = "weapon")
	private Fighter user;
	
	private String name;
	private int attack;
	private String type;
	
	//CONSTRUCTOR
	public Weapon() {
	}
	
	public Weapon(String name, int attack) {
		this.name = name;
		this.attack = attack;
	}
	public Weapon(String name, int attack, String type) {
		super();
		this.name = name;
		this.attack = attack;
		this.type = type;
	}

	//GETTERS AND SETTERS
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
	  public Long getIdWeapon() {
		return idWeapon;
	}
	public void setIdWeapon(Long idWeapon) {
		this.idWeapon = idWeapon;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Fighter getUser() {
		return user;
	}
	public void setUser(Fighter user) {
		this.user = user;
	}

	public void printStats() {
		System.out.println(this.getName() + "'s type is " + this.getType() + " and can deal " + this.getAttack() + " damage."); 
	}
	
}
