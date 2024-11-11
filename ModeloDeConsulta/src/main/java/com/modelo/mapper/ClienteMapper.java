package com.modelo.mapper;

import com.modelo.model.Cliente;
import com.modelo.request.ClienteRequest;

public class ClienteMapper {

	public static Cliente toCliente(ClienteRequest request) {
		 
		Cliente cliente = new Cliente();
		cliente.setLegalName(request.getLegalName());
		cliente.setCorporateName(request.getCorporateName());
		cliente.setCnpj(request.getCnpj());
		cliente.setCpf(request.getCpf());
		cliente.setPhone(request.getPhone());
		cliente.setStatus(request.getStatus());
		cliente.setEmail(request.getEmail());
		
		return cliente;
	}
}
