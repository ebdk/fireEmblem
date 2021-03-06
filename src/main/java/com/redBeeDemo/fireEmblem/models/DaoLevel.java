package com.redBeeDemo.fireEmblem.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface DaoLevel extends CrudRepository<Level, Long> {
	
	public List<Level> findByname(String name);
	
	public List<Level> findByposition(int number);

}
