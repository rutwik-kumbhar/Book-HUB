package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Cart;
import com.example.service.CartService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/cart/add/book/{bookid}/{userid}")
	public ResponseEntity<Cart> addBookCart(@PathVariable Integer bookid , @PathVariable Integer userid){
		return  new ResponseEntity<Cart>(cartService.addBookIntoCart(bookid, userid),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("cart/books/{userid}")
	public ResponseEntity<List> getAllCartBooks(@PathVariable Integer userid){
		return new ResponseEntity<List>(cartService.getAllBooks(userid),HttpStatus.OK);
	}
	
	@DeleteMapping("cart/remove/book/{bookid}/{userid}")
	public ResponseEntity<String> removeBook(@PathVariable(name="bookid") Integer bookId ,@PathVariable(name = "userid") Integer userId){
		return new ResponseEntity<String>(cartService.removeBookFromCart(bookId, userId),HttpStatus.OK);
	}

}
