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
	
	@OneToMany(mappedBy = "weapon")
	private List<Fighter> usedBy;
	
	@OneToOne
	private Weapon strongAgainst;

	@OneToOne(mappedBy = "strongAgainst")
	private Weapon weakAgainst;
	//https://stackoverflow.com/questions/22972241/jpa-validation-onetoone-to-same-table
	
	private String name;
	private int attack;
	
	//CONSTRUCTOR
	public Weapon(String name, int attack) {
		this.name = name;
		this.attack = attack;
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
	public Weapon getStrongAgainst() {
		return strongAgainst;
	}
	public void setStrongAgainst(Weapon strongAgainst) {
		this.strongAgainst = strongAgainst;
	}
	public Weapon getWeakAgainst() {
		return weakAgainst;
	}
	public void setWeakAgainst(Weapon weakAgainst) {
		this.weakAgainst = weakAgainst;
	}
	
	  enum SwAxSp {
		    Sw("Sword", "Ax"), Sp("Spear", "Sw"), Ax("Axe", "Sp");
		    private final String beats, name;
		    SwAxSp(String name, String beats) { this.beats = beats; this.name = name; }
		    int compare(SwAxSp other) { return other == this? 0 : other == valueOf(beats)? 1 : -1; }
		    String fullName() { return name; }
		  }
	
}
