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

import com.modelo.dto.ClienteDTO;
import com.modelo.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<ClienteDTO> getAllClientes(){
		return clienteService.getAllClientes();
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> createCliente(@Valid @RequestBody ClienteDTO clienteDTO) {
	    ClienteDTO createdCliente = clienteService.createCliente(clienteDTO);
	    return new ResponseEntity<>(createdCliente, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable("id") Long id,  @RequestBody ClienteDTO clienteDTO) {
		ClienteDTO cliente = clienteService.updateCliente(id, clienteDTO);
		return new ResponseEntity<>(cliente ,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		clienteService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
