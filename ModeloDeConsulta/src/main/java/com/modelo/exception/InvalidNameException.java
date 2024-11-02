package com.modelo.exception;

public class InvalidNameException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidNameException() {super("Nome de cliente inválido.");}

	public InvalidNameException(String message) {super(message);}
}
