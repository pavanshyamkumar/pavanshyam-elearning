package com.project.HealthCare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.HealthCare.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	public User findByUsername(String username);

	

	

}
