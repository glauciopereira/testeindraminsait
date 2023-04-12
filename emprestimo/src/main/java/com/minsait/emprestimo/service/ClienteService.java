package com.minsait.emprestimo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.excessoes.ClienteNotFoundException;
import com.minsait.emprestimo.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente cadastraCliente(Cliente cliente) {

		
		return this.clienteRepository.save(cliente);
	}
	
	public Cliente recuperarCliente(Long cpf) throws ClienteNotFoundException {
		if (this.clienteRepository.existsById(cpf)){
		return this.clienteRepository.getReferenceById(cpf);
		}else {
			throw new ClienteNotFoundException(cpf);
		}
	}

	
	public List<Cliente> recuperarTodosClientes() {
		return this.clienteRepository.findAll();
	}
	
	
	public void deleteCliente(Long cpf) throws ClienteNotFoundException {
		if (this.clienteRepository.existsById(cpf)) {
			this.clienteRepository.deleteById(cpf);

		}else {

		throw new ClienteNotFoundException(cpf);
		}
	}
	
	
	public Cliente alteraCliente(@Valid Cliente cliente, Long cpf) throws ClienteNotFoundException {

		if (this.clienteRepository.existsById(cpf)) {
			return this.clienteRepository.save(cliente);

		}else {

		throw new ClienteNotFoundException(cpf);
		
		}
		
	}

}
