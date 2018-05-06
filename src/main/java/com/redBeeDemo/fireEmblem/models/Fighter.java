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
	private double idFighter;
	
	@ManyToOne()
	@JoinColumn(name = "level_id")
	private Level level;
	
	@ManyToOne()
	@JoinColumn(name = "weapon_id")
	private Weapon weapon;
	
	private String name;
	private double heatlh;
	private int defense;
	private int attack;
	
	//CONSTRUCTORS
	public Fighter() {
	}
	
	public Fighter(Level level, Weapon weapon, String name, int heatlh,int attack, int defense) {
		this.name = name;
		this.heatlh = heatlh;
		this.defense = defense;
		this.attack = attack;
		this.setWeapon(weapon);
		this.level = level;
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
	public double getHeatlh() {
		return heatlh;
	}
	public void setHeatlh(double heatlh) {
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
		//level.linkFighter(this);
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		weapon.linkFighter(this);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//METHODS
	public void attack(Fighter opponent) {
		int attackPower = this.getAttack();
		int attackWeapon = this.getWeapon().getAttack();
		int attackLevel = this.getLevel().getAttack();
		double advMultiplier = analyzeWeakness(this, opponent);

		double attackTotal = (attackPower + attackWeapon + attackLevel) * advMultiplier;
		
		System.out.println(this.getName() + " attacked with a total damage of : " + attackTotal + ".");

		opponent.receiveAttack(attackTotal);

	}
	
	public void receiveAttack(double attackReceived) {
				
		int defenseOpponet = this.getDefense();
		int defenseLevel = this.getLevel().getDefense();
		
		int defenseDone = defenseOpponet + defenseLevel;
		System.out.println(this.getName() + " could protect himself/herself of : " + defenseDone + " damage.");
		
		double damageReceived = attackReceived - defenseDone;		
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
	
	public double analyzeWeakness(Fighter attackerWpn, Fighter defenderWpn) {
		double res = WeaponFactory.lookUpWeakness(attackerWpn.getWeapon().getType(), defenderWpn.getWeapon().getType());
		if(res == 1) {
			System.out.println(this.getName() + "'s " + this.getWeapon().getName() + " was the same type of his rival's so no effect was given.");
		}
		if(res == 0.5) {
			System.out.println(this.getName() + "'s " + this.getWeapon().getName() + " was weaker than of his rival's.");
		}
		if(res == 2) {
			System.out.println("SMAAAAAASH " +this.getName() + "'s " + this.getWeapon().getName() + " was stronger than of this rival's.");
		}
		return res;	
	}
	
	public void modifyLevel(String upOrDown) {
		switch(upOrDown) {
			case "up" :
				if(LevelFactory.getLevels().size() - 1 == this.getLevel().getPosition()) {
					System.out.println("Couldn't modify " + this.getName() + "'s level");
					System.out.println("Reason: His level was alredy the highest");
				} else {
					Level lvlUp = LevelFactory.lookUpLvl(this.getLevel().getPosition() + 1);
					this.setLevel(lvlUp);
				}
				break;
			case "down" :
				if(0 == this.getLevel().getPosition()) {
					System.out.println("Couldn't modify " + this.getName() + "'s level");
					System.out.println("Reason: His level was alredy the lowest");
				} else {
					Level lvlDown = LevelFactory.lookUpLvl(this.getLevel().getPosition() - 1);
					this.setLevel(lvlDown);
				}
				break;
			default:
				System.out.println("Couldn't modify " + this.getName() + "'s level");
		}
	}
}
