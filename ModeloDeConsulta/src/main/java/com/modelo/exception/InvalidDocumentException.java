package com.modelo.exception;

public class InvalidDocumentException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidDocumentException() {super("CNPJ/CPF inválido.");}

	public InvalidDocumentException(String message) {super(message);}

	
}
