package com.modelo.exception;

public class InvalidPhoneNumberException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidPhoneNumberException() {super("Número de telefone inválido.");}

	public InvalidPhoneNumberException(String message) {super(message);}
	
}
