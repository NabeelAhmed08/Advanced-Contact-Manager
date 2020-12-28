package com.org.app.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.org.app.dao.Contact;
import com.org.app.dao.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository dao;

	public List<Contact> fetchContact() {
		return dao.findAll();
	}

	public Page<Contact> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return dao.findAll(pageable);
	}

	public Page<Contact> findPaginatedByName(int pageNo, int pageSize, String name) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return dao.findByNameStartingWith(name, pageable);
	}

	public List<Contact> fetchContactAsc() {
		List<Contact> list = dao.findAll().stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
				.collect(Collectors.toList());
		return list;
	}

	public List<Contact> fetchContactDec() {
		List<Contact> list = dao.findAll().stream().sorted((e1, e2) -> e2.getName().compareTo(e1.getName()))
				.collect(Collectors.toList());
		return list;
	}

	/*
	 * public List<Contact> sortContactByLocation() { List<Contact> list =
	 * dao.findAll().stream().sorted((e1, e2) ->
	 * e1.getLocation().compareTo(e2.getLocation())) .collect(Collectors.toList());
	 * return list; }
	 */
	public List<Contact> sortByPno() {
		List<Contact> list = dao.findAll().stream().sorted((e1, e2) -> e1.getPno().compareTo(e2.getPno()))
				.collect(Collectors.toList());
		return list;
	}

	/*
	 * public List <Contact> sortById() { List<Contact> list =
	 * dao.findAll().stream().collect(Collectors.toList());
	 * Collections.sort(list,(e1,e2) -> e1.getId() - e2.getId()); return list; }
	 */
	public List<Contact> fetchContactByNameLike(String name) {
		// List<Contact> contacts = dao.findByNameLike(name) ;
		List<Contact> contacts = dao.findByNameStartingWith(name);
		return contacts;
	}

	public Optional<Contact> fetchContactById(int id) {
		return dao.findById(id);
	}

	public Contact addContact(Contact contact) {
		Contact createdContact = dao.save(contact);
		return null;
	}

	public void deleteContactById(int id) {
		dao.deleteById(id);
	}

	public void updateContactById(Contact contact) {
		// dao.findById(id);
		Optional<Contact> cont = fetchContactById(contact.getId());
		if (cont.isPresent()) {
			Contact updateContact = cont.get();
			System.out.println(updateContact);
			dao.save(updateContact);
		}
	}
}
