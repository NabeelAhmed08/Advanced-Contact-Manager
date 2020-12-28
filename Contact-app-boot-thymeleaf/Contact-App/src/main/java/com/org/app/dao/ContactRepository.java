package com.org.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	public List<Contact> findByName(String name);

	public List<Contact> findByNameStartingWith(String name);

	public Page<Contact> findByNameStartingWith(String name, Pageable pageable);
}
