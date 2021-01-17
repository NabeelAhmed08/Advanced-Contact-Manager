package com.acm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acm.dao.UserRepository;
import com.acm.model.Contact;
import com.acm.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@ModelAttribute
	public void addCommonData(Model model ,Principal principal) {
		model.addAttribute("title","Dashboard - ACM");
		String userName =  principal.getName();
	 	User user = userRepo.findByEmail(userName);
	 	model.addAttribute("user",user);
	}

	@GetMapping("/index")
	public String dashboard(Model model ,Principal principal) {
		
		return "normal/user_dashboard";
	
	}
	
	@GetMapping("/add-contact")
	public String addContactForm(Model model) {
		model.addAttribute("title","Add Contact - ACM");
		model.addAttribute("contact",new Contact());
		
		return "normal/add_contact_form";
		
	}
	
	
	
}
