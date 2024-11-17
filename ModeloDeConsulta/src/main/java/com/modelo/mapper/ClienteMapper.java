package com.modelo.mapper;

import com.modelo.model.Cliente;
import com.modelo.request.ClienteRequest;
import com.modelo.response.ClienteResponse;

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
	
	public static ClienteResponse toClienteResponse(Cliente cliente) {
		
		ClienteResponse response = new ClienteResponse();
		response.setLegalName(cliente.getLegalName());
		response.setCorporateName(cliente.getCorporateName());
		response.setCnpj(cliente.getCnpj());
		response.setCpf(cliente.getCpf());
		response.setPhone(cliente.getPhone());
		response.setStatus(cliente.getStatus());
		response.setEmail(cliente.getEmail());
		
		return response;
	}
}
