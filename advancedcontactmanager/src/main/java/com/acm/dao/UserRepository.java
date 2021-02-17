package com.acm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acm.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	
	/*
	@Query("select u from User where u.email = :email")
	public User getUserByUserName(@Param("email") String email );
 */
}
