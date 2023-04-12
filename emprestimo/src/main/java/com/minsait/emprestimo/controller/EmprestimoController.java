package com.minsait.emprestimo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.minsait.emprestimo.dto.EmprestimoDTO;

import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.excessoes.LimiteEmprestimosExcedidoException;
import com.minsait.emprestimo.repository.EmprestimoRepository;
import com.minsait.emprestimo.service.EmprestimoService;

	
@RestController
@RequestMapping("/clientes/{cpf}/emprestimos")
public class EmprestimoController {

    private EmprestimoService emprestimoService;
    
    private  EmprestimoRepository emprestimoRepository;


    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }
    
    @Autowired
    public void EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmprestimoDTO criarEmprestimo(@RequestBody EmprestimoDTO emprestimoDTO) {
    	
        String relacionamento = emprestimoDTO.getRelacionamento();
        double valorInicial = emprestimoDTO.getValorInicial();
        Long cpf = emprestimoDTO.getCpfCliente();
        
            List<Emprestimo> qtdemprestimos = emprestimoRepository.findByClienteCpf(cpf);
    

        
            if (relacionamento.equals("Bronze")) {
                emprestimoDTO.setValorFinal(valorInicial * 1.80);
            } else if (relacionamento.equals("Prata")) {
                if (valorInicial > 5000) {
                    emprestimoDTO.setValorFinal(valorInicial * 1.40);
                } else {
                    emprestimoDTO.setValorFinal(valorInicial * 1.60);
                }
            } else if (relacionamento.equals("Ouro")) {
                if (qtdemprestimos.size() > 0) {
                    emprestimoDTO.setValorFinal(valorInicial * 1.3);
                } else {
                    emprestimoDTO.setValorFinal(valorInicial * 1.2);
                }
            }
            
            if (!emprestimoService.validarLimiteEmprestimos(cpf, valorInicial)) {
                throw new LimiteEmprestimosExcedidoException();
            }
        
        
        Emprestimo emprestimo = emprestimoService.criarEmprestimo(emprestimoDTO.toEmprestimo());
        emprestimo.setValorFinal(emprestimoDTO.getValorFinal());
        emprestimo = emprestimoService.criarEmprestimo(emprestimo);
        

        return new EmprestimoDTO(emprestimo);
        
    }

    @PutMapping("/{id}")
    public EmprestimoDTO atualizarEmprestimo(@PathVariable Long id, @RequestBody EmprestimoDTO emprestimoDTO) {
    	
        
        Emprestimo emprestimo = emprestimoService.atualizarEmprestimo(id, emprestimoDTO.toEmprestimo());
        return new EmprestimoDTO(emprestimo);
    }

    @DeleteMapping("/{id}")
    public void deletarEmprestimo(@PathVariable Long id) {
        emprestimoService.deletarEmprestimo(id);
    }
}
