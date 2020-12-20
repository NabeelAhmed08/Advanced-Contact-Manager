package com.org.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.org.app.dao.Contact;
import com.org.app.dao.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository dao;
	
	public List<Contact> fetchContact()  {
		return dao.findAll();
	}
	
	public List<Contact> fetchContactByName(String name) {
		List<Contact> contacts = dao.findByName(name) ;
		return contacts;
	}
	
	public Contact addContact(Contact contact) {
		Contact createdContact = dao.save(contact);
			return null;
	}
	
	public void deleteContactById(int id) {
		dao.deleteById(id);
	}
	
}
