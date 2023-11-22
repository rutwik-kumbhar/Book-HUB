package com.example.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Book;
import com.example.responsedto.DeleteResponseDto;
import com.example.service.BookService;


@RestController
@RequestMapping("/books")
public class MainController {
	
	@Autowired
	private BookService bookService;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestParam("image") MultipartFile file , @RequestParam Map<String,String> book)throws IllegalStateException, IOException {
		return new ResponseEntity<Book>(bookService.addBook(file, book),HttpStatus.CREATED);
	}
	
	
	@GetMapping()
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Integer id){
		return new ResponseEntity<Book>(bookService.getBookById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Integer id ,@RequestBody Book book){
		return new ResponseEntity<Book>(bookService.updateBook(id, book),HttpStatus.OK);
	}
	
	@PatchMapping("/delete/{id}")
	public ResponseEntity<DeleteResponseDto> deleteBook(@PathVariable Integer id){
		return new ResponseEntity<DeleteResponseDto>(bookService.deleteBook(id),HttpStatus.OK);
	}
	
	
 
	
}
