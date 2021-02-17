package com.acm.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acm.model.Contact;
import com.acm.model.User;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	@Query("from Contact as c where c.user.id =:userId")
	public Page<Contact> findContactsByUser(@Param("userId")int userId, Pageable pePageable);
	
   public List<Contact> findByNameContainingAndUser(String keyword,User user);
 	
	
}
