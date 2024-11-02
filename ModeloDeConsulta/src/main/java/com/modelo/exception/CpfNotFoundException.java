package com.modelo.exception;

public class CpfNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CpfNotFoundException() {super("CPF não encontrado");}
	
	public CpfNotFoundException(String message) {super(message);}
}
