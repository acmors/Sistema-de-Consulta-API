package com.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.dto.ClienteDTO;
import com.modelo.exception.DuplicateEntryException;
import com.modelo.exception.IdNotFoundException;
import com.modelo.model.Cliente;
import com.modelo.repository.ClienteRepository;
import com.modelo.validator.ClienteValidator;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteDTO createCliente(ClienteDTO clienteDTO) {
		
		if (clienteRepository.existsByCnpj(clienteDTO.getCnpj()) || clienteRepository.existsByCpf(clienteDTO.getCpf())) {
			throw new DuplicateEntryException("CNPJ/CPF já cadastrados");
		}
		
		ClienteValidator.validateClienteData(	clienteDTO.getRazaoSocial(), clienteDTO.getCnpj(), clienteDTO.getCpf(), clienteDTO.getTelefone());
		Cliente cliente = new Cliente(clienteDTO);
		Cliente savedCliente = clienteRepository.save(cliente);
		return new ClienteDTO(savedCliente);
	}
	
	public ClienteDTO getClienteByID(Long id) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException());
				
		return new ClienteDTO(cliente);
	}
	
	public List<ClienteDTO> getAllClientes(){
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.stream().map(ClienteDTO::new).toList();
	}
	
	public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
		Cliente clienteExist = clienteRepository.findById(id)
				.orElseThrow(() -> new IdNotFoundException());
		
		clienteExist.setRazaoSocial(clienteDTO.getRazaoSocial());
		clienteExist.setNomeFantasia(clienteDTO.getNomeFantasia());
		clienteExist.setCnpj(clienteDTO.getCnpj());
		clienteExist.setCpf(clienteDTO.getCpf());
		clienteExist.setTelefone(clienteDTO.getTelefone());
		clienteExist.setStatus(clienteDTO.getStatus());
		
		return new ClienteDTO(clienteRepository.save(clienteExist));
		
	}
	
	public void delete(Long id) {
		Cliente cliente = clienteRepository.findById(id).get();
		clienteRepository.delete(cliente);
	}
}
