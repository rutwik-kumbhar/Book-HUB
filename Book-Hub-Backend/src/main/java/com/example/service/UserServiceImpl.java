package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.exception.UserException;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private CustomerUserDetailsService customerUserDetailsService;
	
	

	@Autowired
	public UserServiceImpl(UserRepository userRepository, CustomerUserDetailsService customerUserDetailsService) {
		super();
		this.userRepository = userRepository;
		this.customerUserDetailsService = customerUserDetailsService;
	}

	@Override
	public User registerUser(User user) throws UserException {
		// TODO Auto-generated method stub
		Optional<User> optional = userRepository.findByEmail(user.getEmail());

		if (optional.isPresent())
			throw new UserException("Email is already used try with another email");

		return userRepository.save(user);
	}

	@Override
	public User getLoginUser(Authentication auth) throws UserException {
		// TODO Auto-generated method stub

		Optional<User> optional = userRepository.findByEmail(auth.getName());

		User user = optional.orElseThrow(() -> new UserException("User Not Register"));

		return user;
	}

	
	

}
