package com.redBeeDemo.fireEmblem.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "level")

public class Level {
	
	//ATTRIBUTES
	@Id
	@GeneratedValue
	private Long idLevel;
	
	@OneToMany(mappedBy = "level")
	private List<Fighter> figthersAtThisLevel;
	
	private String name;
	private int attack;
	private int defense;
	private int health;
	private int position;
	
	//CONSTRUCTOR
	public Level(String name, int health, int attack, int defense, int position) {
		this.name = name;
		this.health= health;
		this.attack = attack;
		this.defense = defense;
		this.position = position;
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
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	

}
