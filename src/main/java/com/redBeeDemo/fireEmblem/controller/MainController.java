package com.redBeeDemo.fireEmblem.controller;

import java.util.ArrayList;
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
import com.redBeeDemo.fireEmblem.models.Messages;

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
		return "homepage";
	}
	@RequestMapping(value = "/showwarriors", method = RequestMethod.POST)
	public String showWarriors(Model model) {

		String str2 = "";
		String str1 = "Please choose a warrior:";
		model.addAttribute("message0", "You have been playing " + Simulator.getGameNumber() + " times alredy.");
		model.addAttribute("message1", str1);
		model.addAttribute("message2", str2);
		model.addAttribute("allWarriors", daoFighter.findAll());
		return "warrior1selection";
	}	
	@RequestMapping(value = "/getwarrior", method = RequestMethod.GET)
	public String getWarrior(Model model, @RequestParam Long id){
	
		Fighter player1 = daoFighter.findById(id).get(); 
		//Usaria un daoFighter.findOne(Long id) para que devuelva un Fighter sin el Optional, pero se ve que no existe mas en esta ver 
		//de Hibernate
		Simulator.setFighter1(player1);
		
		String str2 = "Chosen warrior: " + Simulator.getFighter1().getName();
		String str1 = "Please choose a warrior:";
		model.addAttribute("message0", "You have been playing " + Simulator.getGameNumber() + " times alredy.");
		model.addAttribute("message1", str1);
		model.addAttribute("message2", str2);
		model.addAttribute("allWarriors", daoFighter.findAll());
		return "warrior2selection";
	}
	@RequestMapping(value = "/getwarrior2", method = RequestMethod.GET)
	public String getWarrior2(Model model, @RequestParam Long id){
	
		Fighter player2 = daoFighter.findById(id).get(); 
		Simulator.setFigther2(player2);
		
		String str1 = Simulator.getFighter1().getName() + ": " + Simulator.getFighter1().getTotalHealth() + "/" + Simulator.getFighter1().getMaxHealth();
		String str2 = Simulator.getFigther2().getName() + ": " + Simulator.getFigther2().getTotalHealth() + "/" + Simulator.getFigther2().getMaxHealth();
		model.addAttribute("war", player2);
		model.addAttribute("message0", "You have been playing " + Simulator.getGameNumber() + " times alredy.");
		model.addAttribute("message1", str1);
		model.addAttribute("message2", str2);
		return "fightprologue";
	}
	
	@RequestMapping(value = "/engage", method = RequestMethod.POST)
	public String engage(Model model) {
		
		if(Simulator.getFighter1().getTotalHealth() == 0 || Simulator.getFigther2().getTotalHealth() == 0) {
			model.addAttribute("message0", "After " + Simulator.getTurnNumber() + " long turns the battle concluded in a winner.");
			return "endfight";
		}
		
		if(Simulator.isInOddTurn()) {
			Simulator.getFighter1().attack(Simulator.getFigther2());
		} else {
			Simulator.getFigther2().attack(Simulator.getFighter1());
		}
				
		String str1 = Simulator.getFighter1().getName() + ": " + Simulator.getFighter1().getTotalHealth() + "/" + Simulator.getFighter1().getMaxHealth();
		String str2 = Simulator.getFigther2().getName() + ": " + Simulator.getFigther2().getTotalHealth() + "/" + Simulator.getFigther2().getMaxHealth();
		model.addAttribute("message0", "Turn number: " + Simulator.getTurnNumber() + ".");
		model.addAttribute("message1", str1);
		model.addAttribute("message2", str2);
		
		model.addAttribute("battlemessage0", Messages.getMessage0());
		model.addAttribute("battlemessage1", Messages.getMessage1());
		model.addAttribute("battlemessage2", Messages.getMessage2());
		model.addAttribute("battlemessage3", Messages.getMessage3());
		
		model.addAttribute("warrior1url", Simulator.getFighter1().getImgUrl());
		model.addAttribute("warrior2url", Simulator.getFigther2().getImgUrl());
		
		model.addAttribute("warrior1porc", Simulator.getFighter1().getPorcent());
		model.addAttribute("warrior2porc", Simulator.getFigther2().getPorcent());
		
		Simulator.nextTurn();
		Messages.empty();
		return "fight";
	}
	
	@RequestMapping(value = "/showwinner", method = RequestMethod.POST)
	
	
	public String showWinner(Model model) {
		Fighter winner = null;
		Fighter loser = null;
		if(Simulator.getFighter1().getTotalHealth() > Simulator.getFigther2().getTotalHealth()) {
			winner = Simulator.getFighter1();
			loser = Simulator.getFigther2();
		} else {
			loser = Simulator.getFighter1();
			winner = Simulator.getFigther2();
		}
		
		winner.modifyLevel("up");
		loser.modifyLevel("down");
		
		if(winner.getIdFighter().equals(loser.getIdFighter())) {
			Messages.empty();
			Messages.addMessage(winner.getName() + " waved goodbye to his clone.");
			Messages.addMessage("He learnt nothing from today's fight, so his level was kept intact");
		} else {
			daoFighter.save(winner);
			daoFighter.save(loser);
		}

		
		model.addAttribute("message1", winner.getName());
		model.addAttribute("message2", "And " + loser.getName() + " lost ...");
		Simulator.endGame();
		
		model.addAttribute("battlemessage0", Messages.getMessage0());
		model.addAttribute("battlemessage1", Messages.getMessage1());
		Messages.empty();
		return "winner";
	}
	
}