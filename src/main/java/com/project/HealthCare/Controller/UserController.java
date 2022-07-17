package com.project.HealthCare.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.HealthCare.Services.ProfeserService;
import com.project.HealthCare.Services.StudentService;
import com.project.HealthCare.Services.UserService;
import com.project.HealthCare.model.Professors;
import com.project.HealthCare.model.Role;
import com.project.HealthCare.model.Students;
import com.project.HealthCare.model.User;
import com.project.HealthCare.model.UserRole;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Autowired
	private ProfeserService prodser;

	@Autowired
	private StudentService stuser;

	
	@PostMapping("/createuserpro")
	public Professors usercreatedoc(@RequestBody User uc) throws Exception {
		
		uc.setPassword(this.bcryptPasswordEncoder.encode(uc.getPassword()));
		Set<UserRole> ur=new HashSet<>();
		Role r=new Role();
		r.setRoleid(42L);
		r.setRolename("PROFESSOR");
		
		UserRole urt=new UserRole();
		urt.setUser(uc);
		urt.setRole(r);
		ur.add(urt);
		this.userservice.createuser(uc, ur);
		User hf=new User();
		hf=this.userservice.userbyname(uc.getUsername());

		Professors professors=new Professors();
		professors.setProid(hf.getId());
		professors.setName(uc.getFirstname()+uc.getLastname());
		professors.setEmail(uc.getUsername());
		professors.setDegree(uc.getDegree());
		professors.setCollege(uc.getCollege());
		professors.setQualification(uc.getQualification());
		return this.prodser.addProfessors(professors);
		
		
	}
	
	@PostMapping("/createuserstu")
	public Students usercreatepat(@RequestBody User uc) throws Exception {
		uc.setPassword(this.bcryptPasswordEncoder.encode(uc.getPassword()));
		Set<UserRole> ur=new HashSet<>();
		Role r=new Role();
		r.setRoleid(43L);
		r.setRolename("STUDENT");
		
		UserRole urt=new UserRole();
		urt.setUser(uc);
		urt.setRole(r);
		ur.add(urt);
		this.userservice.createuser(uc, ur);

		User hf=new User();
		hf=this.userservice.userbyname(uc.getUsername());

		Students students=new Students();
		students.setStuid(hf.getId());
		students.setName(uc.getFirstname()+uc.getLastname());
		students.setEmail(uc.getUsername());
		
		return this.stuser.addStudents(students);
		
		
	}
	
	@PostMapping("/createuseradm")
	public User usercreateadm(@RequestBody User uc) throws Exception {
		uc.setPassword(this.bcryptPasswordEncoder.encode(uc.getPassword()));
		Set<UserRole> ur=new HashSet<>();
		Role r=new Role();
		r.setRoleid(44L);
		r.setRolename("ADMIN");
		
		UserRole urt=new UserRole();
		urt.setUser(uc);
		urt.setRole(r);
		ur.add(urt);
		
		return this.userservice.createuser(uc, ur);
		
		
	}
	
	@GetMapping("/{id}")
	public User userbyid(@PathVariable("id") Long id) {
		return this.userservice.userbyid(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletebyid(@PathVariable("id") Long id) {
		this.userservice.userdeletebyid(id);
	}
	
	@PutMapping("/update")
	public User updateuser(@RequestBody User update) {
		return this.userservice.updateuser(update);
	}
	
	@GetMapping("/showall")
	public Set<User> showall(){
		return this.userservice.alluser();
	}
	
	
	
	
	

}
