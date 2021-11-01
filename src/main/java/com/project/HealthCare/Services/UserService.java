package com.project.HealthCare.Services;

import java.util.Set;

import com.project.HealthCare.model.User;
import com.project.HealthCare.model.UserRole;

public interface UserService {
	
	public User createuser(User user, Set<UserRole> userrole) throws Exception;
	
    public User userbyid(Long id);
    
    public void userdeletebyid(Long id);
    
    public User updateuser(User user);

    public User userbyname(String username);
    
    public Set<User> alluser();
	

}

