package com.project.HealthCare.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name="role")
public class Role {
	
	@Id
	private Long roleid;
	private String rolename;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="role")
	private Set<UserRole> r1=new HashSet<>();
	
	public Role() {
		
	}
	
	


	public Set<UserRole> getR1() {
		return r1;
	}




	public void setR1(Set<UserRole> r1) {
		this.r1 = r1;
	}




	public Long getRoleid() {
		return roleid;
	}


	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}


	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public Role(Long roleid, String rolename) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
	}
	
	
	
	

}
