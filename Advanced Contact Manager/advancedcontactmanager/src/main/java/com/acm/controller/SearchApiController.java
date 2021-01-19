package com.acm.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acm.dao.ContactRepository;
import com.acm.dao.UserRepository;
import com.acm.model.Contact;
import com.acm.model.User;

@RestController
public class SearchApiController {

	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ContactRepository contactRepo;
	
	@GetMapping("/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query, Principal principal){
		
		
	 	User user = userRepo.findByEmail(principal.getName());
		
		 List<Contact> contacts = contactRepo.findByNameContainingAndUser(query, user);
		
		
		return ResponseEntity.ok(contacts) ;
		
	}
	
	
}
