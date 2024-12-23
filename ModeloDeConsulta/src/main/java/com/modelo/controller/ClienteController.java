package com.modelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modelo.mapper.ClienteMapper;
import com.modelo.model.Cliente;
import com.modelo.request.ClienteRequest;
import com.modelo.response.ClienteResponse;
import com.modelo.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	public ResponseEntity<ClienteResponse> createCliente(@Valid @RequestBody ClienteRequest request) {
		Cliente cliente = ClienteMapper.toCliente(request);
		Cliente savedCliente = clienteService.createCliente(cliente);
		ClienteResponse clienteResponse = ClienteMapper.toClienteResponse(savedCliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponse> update(@PathVariable("id") Long id, @Valid  @RequestBody ClienteRequest request) {
		
		Cliente updatedCliente = ClienteMapper.toCliente(request);
		Cliente savedCliente = clienteService.updateCliente(id, updatedCliente);
		ClienteResponse response = ClienteMapper.toClienteResponse(savedCliente);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public List<Cliente> getAllClientes(){
		return clienteService.getAllClientes();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		clienteService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
