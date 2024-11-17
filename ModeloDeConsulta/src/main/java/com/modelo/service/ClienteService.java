package com.modelo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.modelo.model.Cliente;
import com.modelo.repository.ClienteRepository;

@Service
public class ClienteService {

	
	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
		
	}

	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> getAllClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente getById(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("teste"));
	}
	
	public Cliente updateCliente(Long id, Cliente updatedCliente) {
		Cliente cliente = getById(id);
		dataUpdate(cliente, updatedCliente);
		entryDuplicate(updatedCliente);
		return clienteRepository.save(cliente);
		
	}
	
	public void deleteCliente(Long id) {
		Cliente cliente = getById(id);
		clienteRepository.delete(cliente);
	}
	
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente com ID " + id + " não encontrado."));
    }
	
    private void entryDuplicate(Cliente cliente) {
    	if (	clienteRepository.existsByCpfAndNot(cliente.getCnpj(), cliente.getId()) || 
    			clienteRepository.existsByCpfAndIdNot(cliente.getCpf(), cliente.getId())) {
    		
    		throw new EntryDuplicateException("CNPJ/CPF já cadastrado.");
    	}
    	
    }
    
    private void dataUpdate(Cliente cliente, Cliente updatedCliente) {
        cliente.setLegalName(updatedCliente.getLegalName());
        cliente.setCorporateName(updatedCliente.getCorporateName());
        cliente.setCnpj(updatedCliente.getCnpj());
        cliente.setPhone(updatedCliente.getPhone());
        cliente.setEmail(updatedCliente.getEmail());
        cliente.setStatus(updatedCliente.getStatus());
    }
}
