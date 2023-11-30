package com.example.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Book;
import com.example.exception.BookNotFoundException;
import com.example.repository.BookRepository;
import com.example.responsedto.DeleteResponseDto;

@Service
public class BookServiceImpl implements BookService {

	private final String FOLDER_PATH = "D:\\Book-HUB\\Book-Hub-Backend\\src\\main\\resources\\static\\images";

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(MultipartFile image, Map<String, String> book) throws IllegalStateException, IOException {

		String url = FOLDER_PATH + image.getOriginalFilename();

		Book newBook = new Book();

		newBook.setTitle(book.get("title"));
		newBook.setAuthor(book.get("author"));
		newBook.setGenre(book.get("genre"));
		newBook.setDescription(book.get("description"));
		newBook.setImageUrl(url);
		newBook.setPrice(Integer.parseInt(book.get("price")));
		newBook.setDiscountedPerceantage(Integer.parseInt(book.get("discountedPerceantage")));
		newBook.setCategory(book.get("category"));
		newBook.setQuantity(Integer.parseInt(book.get("quantity")));
	

		image.transferTo(new File(url));

		return bookRepository.save(newBook);

	}

	@Override
	public Book getBookById(Integer id) throws BookNotFoundException {

		Optional<Book> opt = bookRepository.findById(id);

		Book book = opt.orElseThrow(() -> new BookNotFoundException("Book not found by give id " + id));

		return book;
	}

	@Override
	public Book updateBook(Integer id, Book book) {
		// TODO Auto-generated method
		Optional<Book> opt = bookRepository.findById(id);

		Book existBook = opt.orElseThrow(() -> new BookNotFoundException("Book not found by give id " + id));
		
		existBook.setTitle(book.getTitle());
		existBook.setAuthor(book.getAuthor());
		existBook.setGenre(book.getGenre());
		existBook.setDescription(book.getDescription());
		existBook.setPrice(book.getPrice());
		existBook.setDiscountedPerceantage(book.getDiscountedPerceantage());
		existBook.setQuantity(book.getQuantity());
		
		bookRepository.save(existBook);
		
		return existBook;
	}

	@Override
	public DeleteResponseDto deleteBook(Integer id) throws BookNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Book> opt =  bookRepository.findById(id);
		
		 Book book = opt.orElseThrow(()-> new BookNotFoundException("Book not found by give id " + id));
		 
		 book.setDeleted(false);
		 
		 bookRepository.save(book);
		 
		return new DeleteResponseDto("Book Deleted Successfully",true);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books =  bookRepository.findAll();
		
		List<Book> bookList =  books.stream().filter((b)-> b.getQuantity() > 0 & b.isDeleted() != false).toList();
		
		 
		return bookList;
	}
	
	

}
