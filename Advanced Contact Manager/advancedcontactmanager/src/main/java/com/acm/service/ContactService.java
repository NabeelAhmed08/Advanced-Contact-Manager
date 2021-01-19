package com.acm.service;

import com.acm.model.Contact;
import com.acm.model.User;

public interface ContactService {

	public abstract void registerUser (User user);
	
	
	public abstract void deleteContact(Contact contact);
	
}
