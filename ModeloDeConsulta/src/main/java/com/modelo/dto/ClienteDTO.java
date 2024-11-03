package com.modelo.dto;

import org.springframework.beans.BeanUtils;

import com.modelo.model.Cliente;

public class ClienteDTO {
	
	private Long id;
	private String razaoSocial;
	private String nomeFantasia;
	private String cnpj;
	private String cpf;
	private String telefone;
	private String email;
	private Boolean status;
	
	public ClienteDTO(Cliente cliente) {
		BeanUtils.copyProperties(cliente, this);
	}
	
	public ClienteDTO() {
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}

	
	
	
}
