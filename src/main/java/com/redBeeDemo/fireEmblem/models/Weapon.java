package com.redBeeDemo.fireEmblem.models;

public abstract class Weapon {
	
	//ATTRIBUTES
	private String type = this.getClass().toString();
	private String name;
	private int attack;
	private Weapon strongAgainst;
	private Weapon weakAgainst;

	
	//CONSTRUCTOR
	public Weapon(String name, int attack) {
		super();
		this.name = name;
		this.attack = attack;
	}
	
	//GETTERS AND SETTERS
	public String getType() {
		return type;
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
	
	
}
