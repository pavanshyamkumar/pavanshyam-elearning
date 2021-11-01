package com.project.HealthCare.Services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.HealthCare.Repository.RoleRepository;
import com.project.HealthCare.Repository.UserRepository;
import com.project.HealthCare.Services.UserService;
import com.project.HealthCare.model.User;
import com.project.HealthCare.model.UserRole;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private RoleRepository rolerepo;
	

	@Override
	public User createuser(User user, Set<UserRole> userrole) throws Exception {
		User lo=this.userrepo.findByUsername(user.getUsername());
		if(lo!=null) {
			System.out.print("User is Already Existed");
			throw new Exception("user is already present");
		}
		else {
			for(UserRole us:userrole)
			{
				rolerepo.save(us.getRole());
			}
			
			user.getU1().addAll(userrole);
			lo=this.userrepo.save(user);
		}
		return lo;
	}


	@Override
	public User userbyid(Long id) {
		return this.userrepo.findById(id).orElse(null);
	}


	@Override
	public void userdeletebyid(Long id) {
		this.userrepo.deleteById(id);
		
	}


	@Override
	public User updateuser(User user) {
		User encrypt=this.userrepo.findById(user.getId()).orElse(null);
		encrypt.setFirstname(user.getFirstname());
		encrypt.setLastname(user.getLastname());
		encrypt.setMobilenumber(user.getMobilenumber());
		encrypt.setEmail(user.getEmail());
		encrypt.setDesignation(user.getDesignation());
	    return this.userrepo.save(encrypt);
	}


	@Override
	public Set<User> alluser() {
		return new HashSet<>(this.userrepo.findAll());
	}


	@Override
	public User userbyname(String username) {
	
		return this.userrepo.findByUsername(username);
	}
	

}
