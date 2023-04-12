package com.minsait.emprestimo.service;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.excessoes.EmprestimoNotFoundException;
import com.minsait.emprestimo.repository.EmprestimoRepository;
import com.minsait.emprestimo.repository.ClienteRepository;


@Service
public class EmprestimoService {
	
	private EmprestimoRepository emprestimoRepository;
	private ClienteRepository clienteRepository;

	@Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository,  ClienteRepository clienteRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.clienteRepository = clienteRepository;
    }

	
    public Emprestimo criarEmprestimo(@RequestBody Emprestimo emprestimo) {
        Long cpf = emprestimo.getCliente().getCpf();
        Cliente cliente = clienteRepository.findByCpf(cpf);
        emprestimo.setCliente(cliente);
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo atualizarEmprestimo(Long id, Emprestimo emprestimoAtualizado) {
    	if (this.emprestimoRepository.existsById(id)){
    	Emprestimo emprestimoExistente = emprestimoRepository.findById(id).orElseThrow(() -> new EmprestimoNotFoundException(id));
        emprestimoExistente.setValorInicial(emprestimoAtualizado.getValorInicial());
        emprestimoExistente.setValorFinal(emprestimoAtualizado.getValorFinal());
        emprestimoExistente.setRelacionamento(emprestimoAtualizado.getRelacionamento());
        emprestimoExistente.setDataInicial(emprestimoAtualizado.getDataInicial());
        emprestimoExistente.setDataFinal(emprestimoAtualizado.getDataFinal());
        return emprestimoRepository.save(emprestimoExistente);
   	} else {
		throw new EmprestimoNotFoundException(id);
	}
       
    }

    public void deletarEmprestimo(Long id) throws EmprestimoNotFoundException {
    	if (this.emprestimoRepository.existsById(id)){
        Emprestimo emprestimoExistente = emprestimoRepository.findById(id).orElseThrow();
        emprestimoRepository.delete(emprestimoExistente);
    	} else {
    		throw new EmprestimoNotFoundException(id);
    	}
    }
    
    
    public boolean validarLimiteEmprestimos(Long cpfCliente, double valorNovoEmprestimo) {
        Cliente cliente = clienteRepository.findByCpf(cpfCliente);
        double rendimentoMensal = cliente.getRendimentoMensal();

        List<Emprestimo> emprestimosCliente = emprestimoRepository.findByClienteCpf(cpfCliente);
        double valorTotalEmprestimos = emprestimosCliente.stream().mapToDouble(Emprestimo::getValorFinal).sum();

        return valorTotalEmprestimos + valorNovoEmprestimo <= rendimentoMensal * 10;
    }
}
