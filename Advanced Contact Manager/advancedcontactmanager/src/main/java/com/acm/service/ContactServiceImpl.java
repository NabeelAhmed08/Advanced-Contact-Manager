package com.acm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acm.dao.UserRepository;
import com.acm.model.User;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	UserRepository repo;
	
	@Override
	public void registerUser(User user) {
		
		this.repo.save(user);
		
		
	}

}
