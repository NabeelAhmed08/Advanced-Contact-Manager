package com.acm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acm.dao.UserRepository;
import com.acm.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	//User user =   userRepo.getUserByUserName(username);
	User user =   userRepo.findByEmail(username);
	
	if (user==null) {
		throw new UsernameNotFoundException("Could not found user !!");
	}
	
	UserDetailsImpl userDetailsImpl  = new UserDetailsImpl(user);
	
		return userDetailsImpl;
	}

}
