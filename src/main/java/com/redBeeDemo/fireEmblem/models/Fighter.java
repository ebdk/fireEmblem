package com.redBeeDemo.fireEmblem.models;

public class Fighter {

	
	//ATTRIBUTES
	private String name;
	private int heatlh;
	private int defense;
	private int attack;
	private Level level;
	private Weapon weapon;
	
	//CONSTRUCTORS
	public Fighter(Level level, Weapon weapon) {
		super();
		this.level = level;
		this.weapon = weapon;
	}
	public Fighter(int heatlh, int defense, int attack, Level level, Weapon weapon) {
		super();
		this.heatlh = heatlh;
		this.defense = defense;
		this.attack = attack;
		this.level = level;
		this.weapon = weapon;
	}
	
	//GETTERS AND SETTERS
	public int getHeatlh() {
		return heatlh;
	}
	public void setHeatlh(int heatlh) {
		this.heatlh = heatlh;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	//METHODS
	public void attack(Fighter fighter) {
		int attackPower = this.getAttack();
		int attackWeapon = this.getWeapon().getAttack();
		int attackLevel = this.getLevel().getAttack();
		int attackMultiplier = this.compareWeapons(fighter);
		
		int attackTotal = (attackPower + attackWeapon + attackLevel) * attackMultiplier;
		
		int defenseOpponet = fighter.getDefense();
		int defenseLevel = fighter.getLevel().getDefense();
		
		int directAttack = attackTotal - (defenseOpponet + defenseLevel);
		
		if(directAttack <= fighter.getHeatlh()) {
			fighter.setHeatlh(this.getHeatlh() - directAttack);
		} else {
			fighter.setHeatlh(0);
		}
	}
	

	
}
