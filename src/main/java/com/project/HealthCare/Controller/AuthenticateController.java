package com.project.HealthCare.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.HealthCare.Config.JwtUtils;
import com.project.HealthCare.Services.impl.UserDetailsServieImpl;
import com.project.HealthCare.model.JwtRequest;
import com.project.HealthCare.model.JwtResponse;
import com.project.HealthCare.model.User;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServieImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception
	{
		try
		{
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		}catch(UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("USERNOT FOUNT");
		}
		
		
		////authentintiacte
		
		
		UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token=this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	public void authenticate(String username,String password) throws Exception
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			
			
		}catch(DisabledException e)
		{
			throw new Exception("User Disabled");
		}catch(BadCredentialsException e)
		{
			throw new Exception("INVALID CREDENTIALS");
		}
	}
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal)
	{
		return (User) this.userDetailsService.loadUserByUsername(principal.getName());
	}
}
