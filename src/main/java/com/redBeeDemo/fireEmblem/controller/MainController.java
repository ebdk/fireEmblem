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

@Controller
public class MainController {

	@Autowired
	DaoFighter daoAFighter;
	
	@Autowired
	DaoLevel daoLevel;

	public MainController() {
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "homepage";
	}

	
}