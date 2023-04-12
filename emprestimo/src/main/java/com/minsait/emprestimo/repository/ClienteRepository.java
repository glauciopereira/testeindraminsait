package com.minsait.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minsait.emprestimo.entity.Cliente;


	@Repository
	public interface ClienteRepository extends JpaRepository<Cliente, Long> {

		Cliente findByCpf(Long cpf);
		
	}

