package com.redBeeDemo.fireEmblem.models;

public class Spear extends WeaponType {

	   private static Spear instance = null;
	   protected Spear() {
	      // Exists only to defeat instantiation.
	   }
	   public static Spear getInstance() {
	      if(instance == null) {
	         instance = new Spear();
	      }
	      return instance;
	   }


}
