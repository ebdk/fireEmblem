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
	public void setTotalHealth(int totalHealth) {
		this.totalHealth = totalHealth;
	}
	public int getTotalDamage() {
		return attack + this.getWeapon().getAttack() + this.getLevel().getAttack();
	}
	public int getTotalDefense() {
		return defense + this.getLevel().getDefense();
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	//METHODS
	public void attack(Fighter opponent) {
		int attackTotal;
		//Message 0
		Messages.addMessage(this.getName() + " is about to hit with an attack of " + this.getTotalDamage());
		switch(analyzeWeakness(this, opponent)) {
			case "Strong":
				attackTotal = this.getTotalDamage() * 2;
				//Message 1
				Messages.addMessage("SMAAAAAAASH his weapon was super effective so it caused double damage, dealing " + attackTotal + " of damage.");
				break;
			case "Weak":
				attackTotal = this.getTotalDamage() / 2;
				//Message 1
				Messages.addMessage("His weapon was not effective, dealing halved the damage, ending up in doing " + attackTotal + " of damage.");
				break;
			default:
				attackTotal = this.getTotalDamage();
				//Message 1
				Messages.addMessage("It landed the hit");
				
		}
		System.out.println(this.getName() + " attacked with a total damage of : " + attackTotal + ".");
		opponent.receiveAttack(attackTotal);
	}
	
	public void receiveAttack(int attackReceived) {
		
		System.out.println(this.getName() + " could protect himself/herself of : " + this.getTotalDefense() + " damage.");
		//Message 2
		Messages.addMessage(this.getName() + " could protect himself/herself of : " + this.getTotalDefense() + " damage.");
		
		int damageReceived = attackReceived - this.getTotalDefense();		
		if (damageReceived > 0) {
			if(damageReceived <= this.getTotalHealth()) {
				this.setTotalHealth(this.getTotalHealth() - damageReceived);
			} else {
				this.setTotalHealth(0);
				//DEFEATED
			}
			System.out.println(this.getName() + " ended up getting damaged by: " + damageReceived + ".");
			System.out.println(this.getName() + " now has " + this.getTotalHealth() + " hp.");
			//Message 3
			Messages.addMessage(this.getName() + " was damaged by " + damageReceived + " so it now has " + this.getTotalHealth() + " HPs");
		} else {
			System.out.println((this.getName() + " received no damage at all."));
			//Message 3
			Messages.addMessage(this.getName() + " received no damage at all. So it's health is still at " + this.getTotalHealth());
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
				if(LevelFactory.getLevels().size() == this.getLevel().getPosition()) {
					System.out.println("Couldn't modify " + this.getName() + "'s level");
					System.out.println("Reason: His level was alredy the highest");
					//Message 0
					Messages.addMessage(this.getName() + " tried to level up but he was alredy at the highest level");
				} else {
					Level lvlUp = LevelFactory.lookUpLvl(this.getLevel().getPosition() + 1);
					//Message 0
					Messages.addMessage(this.getName() + " leveled up, going from " + this.getLevel().getName() + " to " + lvlUp.getName());
					this.setLevel(lvlUp);
					this.setTotalHealth(health + level.getHealth());
					this.setMaxHealth(this.getTotalHealth());
				}
				break;
			case "down" :
				if(1 == this.getLevel().getPosition()) {
					System.out.println("Couldn't modify " + this.getName() + "'s level");
					System.out.println("Reason: His level was alredy the lowest");
					//Message 1
					Messages.addMessage(this.getName() + " tried to level down but he was alredy at the lowest level");
					this.setTotalHealth(this.getMaxHealth());
				} else {
					Level lvlDown = LevelFactory.lookUpLvl(this.getLevel().getPosition() - 1);
					//Message 1
					Messages.addMessage(this.getName() + " leveled down, going from " + this.getLevel().getName() + " to " + lvlDown.getName());
					this.setLevel(lvlDown);
					this.setTotalHealth(health + level.getHealth());
					this.setMaxHealth(this.getTotalHealth());
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
