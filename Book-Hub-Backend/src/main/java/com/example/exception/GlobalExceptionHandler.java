package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ExceptionFormat> userException(UserException ex , WebRequest request){
		return new ResponseEntity<ExceptionFormat>(new ExceptionFormat(LocalDateTime.now(),ex.getMessage(),request.getDescription(false)),HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ExceptionFormat> BookException(BookNotFoundException ex , WebRequest request){
		return new ResponseEntity<ExceptionFormat>(new ExceptionFormat(LocalDateTime.now(),ex.getMessage(),request.getDescription(false)), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionFormat> handlerNotFoundException(NoHandlerFoundException ex ,WebRequest request){
		ExceptionFormat ef = new ExceptionFormat(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ExceptionFormat>(ef,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionFormat> globalException(Exception ex , WebRequest request){
		return new ResponseEntity<ExceptionFormat>(new ExceptionFormat(LocalDateTime.now(),ex.getMessage(),request.getDescription(false)),HttpStatus.BAD_REQUEST);
	}
}
