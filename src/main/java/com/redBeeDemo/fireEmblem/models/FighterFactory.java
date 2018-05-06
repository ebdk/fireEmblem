package com.redBeeDemo.fireEmblem.models;

public class FighterFactory {

	public FighterFactory() {
	}
	
	public Fighter createIan() {
		Fighter ian = new Fighter("Ian", 0, 0, 0);
		return ian;
	}

}
