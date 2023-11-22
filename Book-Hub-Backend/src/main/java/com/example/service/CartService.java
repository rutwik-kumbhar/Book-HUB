package com.example.service;

import java.util.List;

import com.example.entity.Book;
import com.example.entity.Cart;

public interface CartService {
	
	
	public Cart addBookIntoCart(Integer bookId,Integer userId);
	
	public List<Book> getAllBooks(Integer userId);
	
	public String removeBookFromCart(Integer bookId ,  Integer userId);
	
}
