package com.minsait.emprestimo.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minsait.emprestimo.entity.Emprestimo;


@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
			
	List<Emprestimo> findByClienteCpf(Long cpf);
		
	}


