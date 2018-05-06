package com.redBeeDemo.fireEmblem.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface DaoFighter extends CrudRepository<Fighter, Long> {
	
	public List<Fighter> findByname(String name);

}
