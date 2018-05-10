package com.redBeeDemo.fireEmblem.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "weapontype")

public abstract class WeaponType {
	
	//ATTRIBUTES
	@Id
	@GeneratedValue
	private Long idWeapontype;
	
	protected String name;
	
	@OneToOne()
	protected WeaponType beats;
	@OneToOne()
	protected WeaponType getsBeaten;
	
	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WeaponType getBeats() {
		return beats;
	}
	public void setBeats(WeaponType beats) {
		this.beats = beats;
	}
	public WeaponType getGetsBeaten() {
		return getsBeaten;
	}
	public void setGetsBeaten(WeaponType getsBeaten) {
		this.getsBeaten = getsBeaten;
	}
	public void setWeakness(WeaponType beats, WeaponType getsBeaten) {
		this.beats = beats;
		this.getsBeaten = getsBeaten;
	}

	//METHODS
	public int getWeakness(WeaponType weaponType) {
		int res = 1;
		if(this.getBeats().getClass().equals(weaponType.getClass())){
			res = 2;
		} else if (this.getGetsBeaten().getClass().equals(weaponType.getClass())) {
			res = (int)0.5;
		}
		return res;
	}

}
