package com.acm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acm.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
