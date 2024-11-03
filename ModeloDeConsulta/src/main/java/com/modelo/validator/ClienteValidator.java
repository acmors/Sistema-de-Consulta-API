package com.modelo.validator;

import com.modelo.exception.InvalidDocumentException;
import com.modelo.exception.InvalidNameException;
import com.modelo.exception.InvalidPhoneNumberException;

public class ClienteValidator {

	public static void validateClienteData(String razaoSocial, String cnpj, String cpf, String phone) {
		validateRazaoSocial(razaoSocial);
		validateCnpj(cnpj);
		validateCpf(cpf);
		validatePhone(phone);
	}

	public static void validateRazaoSocial(String razaoSocial) {
		if (razaoSocial == null || razaoSocial.isEmpty()) {
			throw new InvalidNameException("Nome inválido");
		}

	}

	public static void validateCnpj(String cnpj) {
		if (cnpj == null || cnpj.length() != 14 || cnpj.chars().distinct().count() == 1 || !isValidCnpj(cnpj)) {

			throw new InvalidDocumentException("CNPJ inválido.");
		}

	}

	public static void validateCpf(String cpf) {
		if (cpf == null || cpf.length() != 11 || cpf.chars().distinct().count() == 1 || !isValidCpf(cpf)) {

			throw new InvalidDocumentException("CPF inválido.");
		}
	}

	public static void validatePhone(String phone) {
		String regex = "^(\\(\\d{2}\\)\\s?)?(\\d{4,5}-\\d{4})$";
		if (phone == null || !phone.matches(regex)) {

			throw new InvalidPhoneNumberException("Telefone inválido.");
		}
	}

	private static boolean isValidCpf(String cpf) {

		int sum1 = 0;
		for (int i = 0; i < 9; i++) {

			sum1 += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
		}

		int checkDigit1 = 11 - (sum1 % 11);
		checkDigit1 = (checkDigit1 >= 10) ? 0 : checkDigit1;

		int sum2 = 0;
		for (int i = 0; i < 9; i++) {

			sum2 += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
		}
		
		int checkDigit2 = 11 - (sum2 % 11);
		checkDigit2 = (checkDigit2 >= 10) ? 0 : checkDigit2;
		
		return 	checkDigit1 == Character.getNumericValue(cpf.charAt(9)) &&
				checkDigit2 == Character.getNumericValue(cpf.charAt(10));
	}
	
	private static boolean isValidCnpj(String cnpj) {
		if (cnpj.length() != 14) return false;
		
		int[] weights1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		int[] weights2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		
		int sum1 = 0;
		for (int i = 0; i < 12; i++) {
			sum1 += Character.getNumericValue(cnpj.charAt(i)) * weights1[i];
		}
		
		int checkDigit1 = sum1 % 11;
		checkDigit1 = (checkDigit1 < 2) ? 0 : 11 - checkDigit1;
		
		
		int sum2 = 0;
		for (int i = 0; i < 13; i++) {
			sum2 += Character.getNumericValue(cnpj.charAt(i)) * weights2[i];
		}
		
		int checkDigit2 = sum2 % 11;
		checkDigit2 = (checkDigit2 < 2) ? 0 : 11 - checkDigit2;
		
		return 	checkDigit1 == Character.getNumericValue(cnpj.charAt(12)) &&
				checkDigit2 == Character.getNumericValue(cnpj.charAt(13));
	}

}