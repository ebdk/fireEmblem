package com.redBeeDemo.fireEmblem.models;

public class Sword extends WeaponType {

	   private static Sword instance = null;
	   protected Sword() {
	      this.name = "Sword";
	   }
	   public static Sword getInstance() {
	      if(instance == null) {
	         instance = new Sword();
	      }
	      return instance;
	   }

}
