package com.example.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Book;
import com.example.exception.BookNotFoundException;
import com.example.responsedto.DeleteResponseDto;

public interface BookService {
	
	public Book addBook(MultipartFile image , Map<String,String> products) throws IllegalStateException, IOException ;
	public Book getBookById(Integer id) throws BookNotFoundException;
	public Book updateBook(Integer id , Book book);
	public DeleteResponseDto deleteBook(Integer id) throws BookNotFoundException;
	public List<Book> getAllBooks();
}
