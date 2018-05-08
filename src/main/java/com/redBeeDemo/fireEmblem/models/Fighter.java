package com.redBeeDemo.fireEmblem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	@OneToOne()
	@JoinColumn(name = "weapon_id")
	private Weapon weapon;
	
	private String name;
	private int health;
	private int maxHealth;
	private int totalHealth;
	private int defense;
	private int attack;
	
	//CONSTRUCTORS
	public Fighter() {
	}
	
	public Fighter(Level level, Weapon weapon, String name, int health,int attack, int defense) {
		this.name = name;
		this.health = health;
		this.defense = defense;
		this.attack = attack;
		this.weapon = weapon;
		this.level = level;
		this.totalHealth = health + level.getHealth();
		this.maxHealth = totalHealth;
	}
	public Fighter(Level level, Weapon weapon) {
		this.level = level;
		this.weapon = weapon;
	}
	public Fighter(String name, int health, int defense, int attack) {
		this.name = name;
		this.health = health;
		this.defense = defense;
		this.attack = attack;
	}
	
	//GETTERS AND SETTERS
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
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
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIdFighter() {
		return idFighter;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public int getTotalHealth() {
		return totalHealth;
	}
	public int getTotalDamage() {
		return attack + this.getWeapon().getAttack() + this.getLevel().getAttack();
	}
	public int getTotalDefense() {
		return defense + this.getLevel().getDefense();
	}

	//METHODS
	public void attack(Fighter opponent) {
		int attackTotal;
		switch(analyzeWeakness(this, opponent)) {
			case "Strong":
				attackTotal = this.getTotalDamage() * 2;
				break;
			case "Weak":
				attackTotal = this.getTotalDamage() / 2;
				break;
			default:
				attackTotal = this.getTotalDamage();
		}
		System.out.println(this.getName() + " attacked with a total damage of : " + attackTotal + ".");
		opponent.receiveAttack(attackTotal);
	}
	
	public void receiveAttack(int attackReceived) {
				
		int defenseDone = this.getTotalDefense();
		System.out.println(this.getName() + " could protect himself/herself of : " + defenseDone + " damage.");
		
		int damageReceived = attackReceived - defenseDone;		
		if (damageReceived > 0) {
			if(damageReceived <= this.getHealth()) {
				this.setHealth(this.getHealth() - damageReceived);
			} else {
				this.setHealth(0);
			}
			
			System.out.println(this.getName() + " ended up getting damaged by: " + damageReceived + ".");
			System.out.println(this.getName() + " now has " + this.getHealth() + " hp.");
		} else {
			System.out.println((this.getName() + " received no damage at all."));
		}
		System.out.println("---------------");
	}
	
	public String analyzeWeakness(Fighter attackerWpn, Fighter defenderWpn) {
		String res = WeaponFactory.lookUpWeakness(attackerWpn.getWeapon().getType(), defenderWpn.getWeapon().getType());
		if(res == "Equal") {
			System.out.println(attackerWpn.getWeapon().getType() + " vs " + defenderWpn.getWeapon().getType() + " = TIE");
			System.out.println(this.getName() + "'s " + this.getWeapon().getName() + " was the same type of his rival's so no effect was given.");
		}
		if(res == "Weak") {
			System.out.println(attackerWpn.getWeapon().getType() + " vs " + defenderWpn.getWeapon().getType() + " = " + defenderWpn.getWeapon().getType());
			System.out.println(this.getName() + "'s " + this.getWeapon().getName() + " was weaker than of his rival's.");
		}
		if(res == "Strong") {
			System.out.println(attackerWpn.getWeapon().getType() + " vs " + defenderWpn.getWeapon().getType() + " = " + attackerWpn.getWeapon().getType());
			System.out.println("SMAAAAAASH " +this.getName() + "'s " + this.getWeapon().getName() + " was stronger than of this rival's.");
		}
		return res;	
	}
	
	public String getMessage1FromWeakness(Fighter attackerWpn, Fighter defenderWpn) {
		String aux = WeaponFactory.lookUpWeakness(attackerWpn.getWeapon().getType(), defenderWpn.getWeapon().getType());
		String res = "";
		if(aux == "Equal") {
			res = this.getName() + "'s " + this.getWeapon().getName() + " was the same type of his rival's so no effect was given.";
		}
		if(aux == "Weak") {
			res = this.getName() + "'s " + this.getWeapon().getName() + " was weaker than of his rival's.";
		}
		
		if(aux == "Strong") {
			res = "SMAAAAAASH " +this.getName() + "'s " + this.getWeapon().getName() + " was stronger than of this rival's.";
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
	
	public void printStats() {
		System.out.println(this.getName() + "'s level is " + this.getLevel().getName() + " and has " +  this.getWeapon().getName());
		System.out.println("HP: " + this.getHealth() + " Attack: " + this.getAttack() + " Defense: " +this.getDefense());
	}
}
