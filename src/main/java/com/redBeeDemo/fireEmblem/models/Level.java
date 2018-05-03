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
	
	//CONSTRUCTOR
	public Level(String name,int attack, int defense) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
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
	
	

}
