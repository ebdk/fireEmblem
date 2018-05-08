package com.redBeeDemo.fireEmblem.controller;

import java.util.List;
import java.util.Optional;

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
import com.redBeeDemo.fireEmblem.models.Simulator;
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
	
	private void saveAllLevelEntries() {
		for(Level level : LevelFactory.getLevels()) {
			daoLevel.save(level);
		}
	}
	private void saveAllFighterEntries() {
		for(Fighter fighter : FighterFactory.getFighters()) {
			daoFighter.save(fighter);
		}
	}
	private void saveAllWeaponEntries() {
		for(Weapon weapon : WeaponFactory.getWeapons()) {
			daoWeapon.save(weapon);
		}
	}
	private void testWeaponTriangle() {
		Fighter sw = daoFighter.findByname("Obi-wan").get(0);
		Fighter sp = daoFighter.findByname("Sun Wukong").get(0);
		Fighter ax = daoFighter.findByname("Thor").get(0);
		
		sw.attack(ax);
		ax.attack(sp);
		sp.attack(sw);
		
		sw.attack(sp);
		ax.attack(sw);
		sp.attack(ax);
		
		sw.attack(sw);
		ax.attack(ax);
		sp.attack(sp);
	}
	
	public void init() {
		LevelFactory.createAll();
		LevelFactory.printAllLevels();
		FighterFactory.createAll();
		WeaponFactory.printAllWeapons();
		FighterFactory.printAllFighters();
		saveAllLevelEntries();
		saveAllWeaponEntries();
		saveAllFighterEntries();
		System.out.println("Done");
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		init();
		//testWeaponTriangle();	
		String str0 = "You have been playing " + Simulator.getGameNumber() + " times alredy.";
		String str2 = "";
		String str1 = "Please choose a warrior:";
		model.addAttribute("message0", str0);
		model.addAttribute("message1", str1);
		model.addAttribute("message2", str2);
		model.addAttribute("allWarriors", daoFighter.findAll());
		return "homepage";
	}	
	@RequestMapping(value = "/getwarrior", method = RequestMethod.GET)
	public String getWarrior(Model model, @RequestParam Long id){
	
		Fighter player1 = daoFighter.findById(id).get(); 
		//Usaria un daoFighter.findOne(Long id) para que devuelva un Fighter sin el Optional, pero se ve que no existe mas en esta ver 
		//de Hibernate
		Simulator.setFighter1(player1);
		
		String str0 = "You have been playing " + Simulator.getGameNumber() + " times alredy.";
		String str2 = "Chosen warrior: " + Simulator.getFighter1().getName();
		String str1 = "Please choose a warrior:";
		model.addAttribute("message0", str0);
		model.addAttribute("message1", str1);
		model.addAttribute("message2", str2);
		model.addAttribute("allWarriors", daoFighter.findAll());
		return "page2";
	}
	@RequestMapping(value = "/getwarrior2", method = RequestMethod.GET)
	public String getWarrior2(Model model, @RequestParam Long id){
	
		Fighter player2 = daoFighter.findById(id).get(); 
		Simulator.setFigther2(player2);
		
		String str0 = "You have been playing " + Simulator.getGameNumber() + " times alredy.";
		String str1 = "Chosen warrior: " + Simulator.getFighter1().getName();
		String str2 = "Chosen adversary: " + Simulator.getFigther2().getName();
		model.addAttribute("message0", str0);
		model.addAttribute("message1", str1);
		model.addAttribute("message2", str2);
		return "page3";
	}
	
}