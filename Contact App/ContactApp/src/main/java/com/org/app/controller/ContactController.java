package com.org.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
			System.out.println("---- request reached getMessage() -----");
			ModelAndView mav = new ModelAndView("home", "msg", "Contact App");
			return mav;
		}
		
		@RequestMapping(value = "/allContacts", method = RequestMethod.GET)
		public ModelAndView getAllContacts() {
			System.out.println("---- request reached  all contacts -----");
			System.out.println(service.fetchContact());
			ModelAndView mav = null;			
			ModelMap model = new ModelMap();		
			model.put("contact", service.fetchContact());		
				return mav =new ModelAndView("contact","model",model);
			}
	
	
		@RequestMapping(value = "/searchbyname", method = RequestMethod.GET)
		public ModelAndView getContactByName(@RequestParam("name") String name) {
			System.out.println("---- request reached getContactByName() -----");
			System.out.println(service.fetchContactByName(name) );
			ModelAndView mav = null;			
			ModelMap model = new ModelMap();		
			model.put("contact", service.fetchContactByName(name) );		
				return mav =new ModelAndView("contact","model",model);
			}
	
		@RequestMapping(value = "/addContact", method = RequestMethod.POST)
		public ModelAndView addContact(@RequestParam("name") String name,
				@RequestParam("pno") String pno ) { 
			
			service.addContact(new Contact(name,pno));
			System.out.println(name);
			System.out.println(pno);
			ModelAndView mav = new ModelAndView("redirect:/allContacts", "msg", "Contact Added Succesfully ");
			return mav;
		}
		
		
		@RequestMapping(value = "/addContactPage", method = RequestMethod.GET)
		public ModelAndView getAddContact() {
			System.out.println("---- request reached getAddPage() -----");
			ModelAndView mav = new ModelAndView("add", "msg", "Contact App/Add Contacts");
			return mav;
		}
		
		@RequestMapping(value = "/deleteById", method = RequestMethod.GET)
		public ModelAndView deleteContactById(@RequestParam("id") int id) {
			System.out.println("---- request reached deleteContactById-----");
			service.deleteContactById(id);
			ModelAndView mav = new ModelAndView("redirect:/allContacts", "msg", "deleted contact sucessfully");
			return mav;
		}
		
	
	
	}	

