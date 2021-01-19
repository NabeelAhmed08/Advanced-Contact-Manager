package com.acm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acm.dao.ContactRepository;
import com.acm.dao.UserRepository;
import com.acm.model.Contact;
import com.acm.model.User;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	UserRepository repo;
	
	@Autowired
	ContactRepository contactRepo;
	
	@Override
	public void registerUser(User user) {
		
		this.repo.save(user);
		
		
	}

	@Transactional
	@Override
	public void deleteContact(Contact contact) {

		this.contactRepo.delete(contact);
		  
		 
		  
		  
		  
		
	}

}
