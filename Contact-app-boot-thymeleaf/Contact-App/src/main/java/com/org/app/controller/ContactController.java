package com.org.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.app.dao.Contact;
import com.org.app.service.ContactService;

	@Controller
	public class ContactController {
		
		@Autowired
		ContactService service;
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public ModelAndView getMessage() {
		//	System.out.println("---- request reached getMessage() -----");
			ModelAndView mav = new ModelAndView("home", "msg", "Contact App");
			return mav;
		}
		
		@GetMapping("/allContacts")
		public String listContacts(Model model) {
			model.addAttribute("contact",service.fetchContactAsc());	
			return "list-contacts";	
		}
		
		@GetMapping("/allContactsDec")
		public String listContactsDec(Model model) {
			model.addAttribute("contact",service.fetchContactDec());	
			return "list-contacts";	
		}
	
		/*
		@GetMapping("/sortByLocation")
		public String sortByLocation(Model model) {
			model.addAttribute("contact",service.sortContactByLocation());	
			return "list-contacts";	
		}
		*/
		@GetMapping("/sortByPno")
		public String sortByPno(Model model) {
			model.addAttribute("contact",service.sortByPno());	
			return "list-contacts";	
		}
		
		@GetMapping("/addContact")
		public String showFormAddContacts(Model model) {
			model.addAttribute("addedcontact",new Contact());	
			return "add";	
		}
		@PostMapping("/saveContact")
		public String saveEmployee(@ModelAttribute("addedcontact") Contact contact ) {
			service.addContact(contact);	
			return "redirect:/allContacts";	
		}
		
		@GetMapping("/updateForm")
		public String showFormUpdateContact(@RequestParam("id") int id, Model model) {
			model.addAttribute("addedcontact",service.fetchContactById(id));	
			return "add";
		}
		
		@GetMapping("/deleteContact")
		public String deleteContact(@RequestParam("id") int id) {
			service.deleteContactById(id);	
			return "redirect:/allContacts";
		}
		

		@GetMapping(value = "/searchbyname")
		public String getContactByName(@RequestParam("name") String name,Model model  ) {
		model.addAttribute("contact",service.fetchContactByNameLike(name));
			return "list-contacts";		
				
			}
	
	
	}	

