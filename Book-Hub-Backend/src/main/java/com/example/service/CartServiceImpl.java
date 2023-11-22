package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Book;
import com.example.entity.Cart;
import com.example.entity.User;
import com.example.repository.BookRepository;
import com.example.repository.CartRepository;
import com.example.repository.UserRepository;


@Service
public class CartServiceImpl  implements CartService{
	
	private CartRepository cartRepository;
	private BookRepository bookRepository;
	private UserRepository userRepository;
	
	
	
	@Autowired
	public CartServiceImpl(CartRepository cartRepository, BookRepository bookRepository,
			UserRepository userRepository) {
		super();
		this.cartRepository = cartRepository;
		this.bookRepository = bookRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Cart addBookIntoCart(Integer bookId, Integer userId) {
		// TODO Auto-generated method stub

		User user = userRepository.findById(userId).get();
		Book book = bookRepository.findById(bookId).get();

		Cart cart = user.getCart();

		if (cart != null) {
			return cartHelper(cart, user, book);

		} else {
			Cart newCart = new Cart();

			cart = cartHelper(newCart, user, book);

			return cart;
		}
	}
	
	@Override
	public List<Book> getAllBooks(Integer userId) {
		// TODO Auto-generated method stub
		
		Cart cart = cartRepository.findByUserId(userId);
		
		List<Book>  books = new ArrayList<>();
		
		cart.getProductIds().stream().forEach((id)-> {	
			Book book  = bookRepository.findById(id).get();
			books.add(book);
		});
		
		return books;
	}
	
	@Override
	public String removeBookFromCart(Integer bookId , Integer userId) {
		// TODO Auto-generated method stub
		
		Cart cart  = cartRepository.findByUserId(userId);
		
		 cart.getProductIds().remove(bookId);
		 
		 cartRepository.save(cart);
		return "Book Removed Sucsessfully";
	}
	
	
	
	
	

//	----------------------------------Helper Functions-------------------------------------------------------

	public Cart cartHelper(Cart cart, User user, Book book) {

		user.setCart(cart);
		cart.setUser(user);

		Integer discountPrice = book.getPrice() * book.getDiscountedPerceantage() / 100;

		cart.setTotalPrice(cart.getTotalPrice() + book.getPrice() - discountPrice);
		cart.setTotalDiscountedPrice(cart.getTotalDiscountedPrice()+discountPrice);
		cart.setCartQaunatity(cart.getProductIds().size()+1);
		
	
		cart.getProductIds().add(book.getId());	
	

		return cartRepository.save(cart);

	}

	


}
