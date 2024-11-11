package com.modelo.request;

public class ClienteRequest {

	private String legalName;

	private String corporateName;

	private String cnpj;

	private String cpf;

	private String phone;

	private Boolean status;

	private String email;
	
	
	//constructor all argues
	public ClienteRequest(String legalName, String corporateName, String cnpj, String cpf, String phone,
			Boolean status, String email) {
		super();
		this.legalName = legalName;
		this.corporateName = corporateName;
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.phone = phone;
		this.status = status;
		this.email = email;
	}
	
	//constructor no argues
	public ClienteRequest() {
	
	}

	//getters and setters
	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
