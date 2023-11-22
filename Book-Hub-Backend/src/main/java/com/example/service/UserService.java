package com.example.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.example.entity.Book;
import com.example.entity.Cart;
import com.example.entity.User;
import com.example.exception.UserException;

public interface UserService {
	
	public User registerUser(User user) throws UserException;
	public User getLoginUser(Authentication auth) throws UserException;
	
	


}
