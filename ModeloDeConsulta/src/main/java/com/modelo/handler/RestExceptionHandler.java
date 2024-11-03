package com.modelo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.modelo.exception.CnpjNotFoundException;
import com.modelo.exception.CpfNotFoundException;
import com.modelo.exception.DuplicateEntryException;
import com.modelo.exception.IdNotFoundException;
import com.modelo.exception.InvalidDocumentException;
import com.modelo.exception.InvalidEmailFormatException;
import com.modelo.exception.InvalidNameException;
import com.modelo.exception.InvalidPhoneNumberException;
import com.modelo.exception.InvalidStatusException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({	IdNotFoundException.class, 
						CnpjNotFoundException.class, 
						CpfNotFoundException.class})
	public ResponseEntity<String> NotFoundExceptionsHandler(Exception exception){
		String message;
		
		if(exception instanceof IdNotFoundException) {
			message = "Id not found.";
		} else if (exception instanceof CnpjNotFoundException) {
			message = "CNPJ not found.";
		} else if (exception instanceof CpfNotFoundException){
			message = "CPF not found.";
		} else {
			message = "Resource not found";
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}
	
	@ExceptionHandler({ InvalidDocumentException.class,
						InvalidEmailFormatException.class,
						InvalidNameException.class,
						InvalidPhoneNumberException.class,
						InvalidStatusException.class})
	public ResponseEntity<String> InvalidInputExceptionHandler(Exception exception){
		String message;
		
		if (exception instanceof InvalidDocumentException) {
			message = "Invalid CNPJ/CPF input.";
		} else if (exception instanceof InvalidEmailFormatException) {
			message = "Invalid email input.";
		} else if (exception instanceof InvalidNameException) {
			message = "Invalid name input.";
		} else if (exception instanceof InvalidPhoneNumberException) {
			message = "Invalid phone number input.";
		} else if (exception instanceof InvalidStatusException) {
			message = "Invalid status.";
		} else {
			message = "Invalid Resource.";
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}
	
	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<String> duplicateEntryHandler(DuplicateEntryException exception){
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate entry found.");
	}
	
	
}
