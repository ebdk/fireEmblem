package com.redBeeDemo.fireEmblem.models;

public class Axe extends WeaponType {

	   private static Axe instance = null;
	   protected Axe() {
	      // Exists only to defeat instantiation.
	   }
	   public static Axe getInstance() {
	      if(instance == null) {
	         instance = new Axe();
	      }
	      return instance;
	   }


}
