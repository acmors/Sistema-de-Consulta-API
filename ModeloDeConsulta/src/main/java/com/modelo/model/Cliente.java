package com.modelo.model;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;

import com.modelo.dto.ClienteDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Razão social não pode estar vazia.")
    private String razaoSocial;

	@NotBlank(message = "Nome fantasia não pode estar vazio.")
    private String nomeFantasia;

	@NotBlank
    @CNPJ(message = "CNPJ deve ter 14 dígitos.")
    private String cnpj;

	@NotBlank(message = "CPF não pode estar vazio.")
    @CPF(message = "CPF deve ter 11 dígitos.")
    private String cpf;


	@NotBlank(message = "Telefone não pode estar vazio.")
    @Pattern(regexp = "^(\\(\\d{2}\\)\\s?)?(\\d{4,5}-\\d{4})$", message = "Formato de telefone inválido.")
    private String telefone;

	@NotNull
    private Boolean status;

	@NotBlank(message = "O email não deve ser nulo")
    @Email(message = "O email deve ser válido")
    private String email;
	
	public Cliente(ClienteDTO cliente) {
		BeanUtils.copyProperties(cliente, this);
	}
	
	public Cliente() {
		
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
