package com.redBeeDemo.fireEmblem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.redBeeDemo.fireEmblem.models.DaoFighter;
import com.redBeeDemo.fireEmblem.models.DaoLevel;
import com.redBeeDemo.fireEmblem.models.DaoWeapon;
import com.redBeeDemo.fireEmblem.models.LevelFactory;
import com.redBeeDemo.fireEmblem.models.Level;
import com.redBeeDemo.fireEmblem.models.FighterFactory;
import com.redBeeDemo.fireEmblem.models.Fighter;
import com.redBeeDemo.fireEmblem.models.WeaponFactory;
import com.redBeeDemo.fireEmblem.models.Weapon;

@Controller
public class MainController {

	@Autowired
	DaoFighter daoFighter;
	
	@Autowired
	DaoLevel daoLevel;
	
	@Autowired
	DaoWeapon daoWeapon;
	

	public MainController() {
	}
	
	private void saveNewLevelEntries() {
		for(Level level : LevelFactory.getLevels()) {
			daoLevel.save(level);
		}
	}
	
	public void init() {
		LevelFactory.createAll();
		LevelFactory.printAllLevels();
		saveNewLevelEntries();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		init();

		Fighter cid = FighterFactory.createElCid2();
		System.out.println("FIGHTER STATS: " + cid.getName());
		System.out.println(cid.getLevel().getName());
		System.out.println(cid.getWeapon().getName());
		Fighter fig = FighterFactory.createFireFighter2();
		System.out.println("FIGHTER STATS: " + fig.getName());
		System.out.println(fig.getLevel().getName());
		System.out.println(fig.getWeapon().getName());
		
		Fighter obi = FighterFactory.createObiWan();
		
		System.out.println("----------");
		cid.attack(obi);
		System.out.println("----------");
		System.out.println(cid.getName() + "'s weapon's type is " + cid.getWeapon().getType());
		System.out.println(obi.getName() + "'s weapon's type is " + obi.getWeapon().getType());
		System.out.println("----------");
		obi.attack(fig);
		System.out.println("----------");
		fig.attack(obi);
		System.out.println("----------");
		System.out.println(fig.getName() + "'s weapon's type is " + fig.getWeapon().getType());
		
		return "homepage";
	}
	
}