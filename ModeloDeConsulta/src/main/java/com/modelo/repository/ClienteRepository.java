package com.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modelo.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	boolean existsByCnpj(String cnpj);
	boolean existsByCpf(String cpj);
}
