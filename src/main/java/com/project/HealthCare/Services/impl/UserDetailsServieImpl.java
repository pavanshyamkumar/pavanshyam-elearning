package com.project.HealthCare.Services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.HealthCare.Repository.UserRepository;
import com.project.HealthCare.model.User;


@Service
public class UserDetailsServieImpl implements UserDetailsService {

	@Autowired
	private UserRepository service;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= this.service.findByUsername(username);
		if(user==null) {
			System.out.print("User Not Found");
			throw new UsernameNotFoundException("No user found!!!");
		}
		
		return user;
	}

}
