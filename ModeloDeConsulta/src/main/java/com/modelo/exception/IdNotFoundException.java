package com.modelo.exception;

public class IdNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {super("Cliente não encontrado!");}
	
	public IdNotFoundException(String message) {super(message);}
}
