package com.topekox.spring.rest.crud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.topekox.spring.rest.crud.except.CustomerErrorResponse;
import com.topekox.spring.rest.crud.except.CustomerNotFoundException;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Handling Not Found Exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException notFoundException) {
		
		CustomerErrorResponse response = new CustomerErrorResponse(
													HttpStatus.NOT_FOUND.value(), 
													notFoundException.getMessage(), 
													System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	// Handling Generic Exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc) {
		
		CustomerErrorResponse response = new CustomerErrorResponse(
													HttpStatus.BAD_REQUEST.value(), 
													exc.getMessage(), 
													System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
}
