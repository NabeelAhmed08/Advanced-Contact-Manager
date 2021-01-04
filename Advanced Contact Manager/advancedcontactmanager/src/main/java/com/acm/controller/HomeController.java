package com.acm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.acm.dao.UserRepository;

@Controller
public class HomeController {

	@Autowired
	private UserRepository UserRepository;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title","Home - ACM");
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","About - ACM");
		return "about";
	}










}
