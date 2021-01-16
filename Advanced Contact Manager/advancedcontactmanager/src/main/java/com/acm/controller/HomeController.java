package com.acm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acm.dao.UserRepository;
import com.acm.model.User;
import com.acm.service.ContactService;
import com.acm.utill.Message;

import net.bytebuddy.implementation.bytecode.Throw;

@Controller
public class HomeController {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private ContactService service;
	
	
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

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title","Register - ACM");
		model.addAttribute("user",new User());
		
		return "signup";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user,BindingResult result,
			@RequestParam(value = "agreement",defaultValue = "false" )boolean agreement ,HttpSession session ,Model model ) {
		
	try {
		if (!agreement) {
			System.out.println("not agreed");
			throw new Exception("You have not agreed the terms and conditions");
		}
		
		
		if (result.hasErrors()) {
			System.out.println("error : " + result.toString());
			model.addAttribute("user",user);
			return "signup";
		}
		
		
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setImage("default.png");
		
		
		System.out.println("agree:"+agreement);
		System.out.println("user:"+user);
		
		this.service.registerUser(user);
		model.addAttribute("user",new User());
		
		session.setAttribute("message",new Message("Sucessfully Registered ", "alert-success"));
	} catch (Exception e) {
		e.printStackTrace();
		session.setAttribute("message",new Message("Somthing Went Wrong "+e.getMessage(), "alert-danger"));
	}
		
		
		
		return "signup";
	}






}
