package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private UserService userService;
	private PasswordEncoder passwordEncoder;
	


	@Autowired
	public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
		super();
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/signup/user")
	public ResponseEntity<User> createUser(@RequestBody User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		return new ResponseEntity<User>(userService.registerUser(user),HttpStatus.CREATED);
	}
	
	@PostMapping("/signup/admin")
	public ResponseEntity<User> createAdmin(@RequestBody User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_ADMIN");
		return new ResponseEntity<User>(userService.registerUser(user),HttpStatus.CREATED);
	}
	
	@PostMapping("/signup/publisher")
	public ResponseEntity<User> createPublisher(@RequestBody User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_PUBLISHER");
		return new ResponseEntity<User>(userService.registerUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/signin")
	public ResponseEntity<User> getLoginUser(Authentication auth){
		
		return new ResponseEntity<User>(userService.getLoginUser(auth),HttpStatus.OK);
	}
	
	

}
