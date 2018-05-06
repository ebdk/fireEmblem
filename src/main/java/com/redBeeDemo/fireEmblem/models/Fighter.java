package com.redBeeDemo.fireEmblem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fighter")

public class Fighter {

	
	//ATTRIBUTES
	@Id
	@GeneratedValue
	private Long idFighter;
	
	@ManyToOne()
	@JoinColumn(name = "level_id")
	private Level level;
	
	@ManyToOne()
	@JoinColumn(name = "weapon_id")
	private Weapon weapon;
	
	private String name;
	private int heatlh;
	private int defense;
	private int attack;
	
	//CONSTRUCTORS
	public Fighter(Level level, Weapon weapon, String name, int heatlh,int attack, int defense) {
		this.name = name;
		this.heatlh = heatlh;
		this.defense = defense;
		this.attack = attack;
		this.setWeapon(weapon);
		this.setLevel(level);
	}
	public Fighter(Level level, Weapon weapon) {
		this.level = level;
		this.weapon = weapon;
	}
	public Fighter(String name, int heatlh, int defense, int attack) {
		this.name = name;
		this.heatlh = heatlh;
		this.defense = defense;
		this.attack = attack;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//METHODS
	public void attack(Fighter opponent, int advMultiplier) {
		int attackPower = this.getAttack();
		int attackWeapon = this.getWeapon().getAttack();
		int attackLevel = this.getLevel().getAttack();
		int attackMultiplier = advMultiplier;
		
		int attackTotal = (attackPower + attackWeapon + attackLevel) * attackMultiplier;
		System.out.println(this.getName() + " attacked with a total damage of : " + attackTotal + ".");

		opponent.receiveAttack(attackTotal);

	}
	
	public void receiveAttack(int attackReceived) {
				
		int defenseOpponet = this.getDefense();
		int defenseLevel = this.getLevel().getDefense();
		
		int defenseDone = defenseOpponet + defenseLevel;
		System.out.println(this.getName() + " could protect himself/herself of : " + defenseDone + " damage.");
		
		int damageReceived = attackReceived - defenseDone;		
		if (damageReceived > 0) {
			if(damageReceived <= this.getHeatlh()) {
				this.setHeatlh(this.getHeatlh() - damageReceived);
			} else {
				this.setHeatlh(0);
			}
			
			System.out.println(this.getName() + " ended up getting damaged by: " + damageReceived + ".");
			System.out.println(this.getName() + " now has " + this.getHeatlh() + " hp.");
		} else {
			System.out.println((this.getName() + " received no damage at all."));
		}	
	}
	
	/*
	public void modifyLevel() {
		this.getLevel().levelUp();
	}
	*/
}
