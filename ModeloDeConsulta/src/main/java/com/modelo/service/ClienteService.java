package com.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.dto.ClienteDTO;
import com.modelo.exception.DuplicateEntryException;
import com.modelo.exception.IdNotFoundException;
import com.modelo.model.Cliente;
import com.modelo.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
		
	}

	public Cliente createCliente(Cliente cliente) {

	    if (clienteRepository.existsByCnpj(cliente.getCnpj())
	            || clienteRepository.existsByCpf(cliente.getCpf())) {
	        throw new DuplicateEntryException("CNPJ/CPF já cadastrados");
	    }

	   
	    Cliente savedCliente = clienteRepository.save(cliente);
	    return new Cliente(savedCliente);
	}

	public Cliente getClienteByID(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IdNotFoundException());

		return cliente;
	}

	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.stream().map(Cliente::new).toList();
	}

	public Cliente updateCliente(Long id,  Cliente cliente) {
		Cliente clienteExist = clienteRepository.findById(id).orElseThrow(() -> new IdNotFoundException());

		clienteExist.setLegalName(cliente.getLegalName());
		clienteExist.setCorporateName(cliente.getCorporateName());
		clienteExist.setCnpj(cliente.getCnpj());
		clienteExist.setCpf(cliente.getCpf());
		clienteExist.setPhone(cliente.getPhone());
		clienteExist.setStatus(cliente.getStatus());

		return new Cliente(clienteRepository.save(clienteExist));

	}

	public void delete(Long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		clienteRepository.delete(cliente);
	}
}
