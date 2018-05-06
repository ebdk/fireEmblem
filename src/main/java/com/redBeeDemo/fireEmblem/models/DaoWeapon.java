package com.redBeeDemo.fireEmblem.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface DaoWeapon extends CrudRepository<Weapon, Long> {
	
	public List<Weapon> findByname(String name);

}
