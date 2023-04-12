package com.minsait.emprestimo.controller;

import java.util.List;
import java.util.ArrayList;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.minsait.emprestimo.dto.EmprestimoDTO;
import com.minsait.emprestimo.dto.ClienteDTO;
import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.entity.Emprestimo;
import com.minsait.emprestimo.excessoes.ClienteNotFoundException;
import com.minsait.emprestimo.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {		
		this.clienteService = clienteService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente cadastraCliente(@Valid @RequestBody Cliente cliente) {
		return this.clienteService.cadastraCliente(cliente);
	}
	
	@GetMapping
	public List<Cliente> recuperarTodosOsCliente() {
		return this.clienteService.recuperarTodosClientes();		
	}

	
	@GetMapping("/{cpf}")
	public ClienteDTO recuperarCliente(@PathVariable Long cpf) throws ClienteNotFoundException{
		
        Cliente cliente = clienteService.recuperarCliente(cpf);
        return new ClienteDTO(cliente);
		
	}
	
	
	@DeleteMapping("/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public void alteraCliente(@PathVariable Long cpf) throws ClienteNotFoundException {
		this.clienteService.deleteCliente(cpf);		
	}
	

	@PutMapping("/{cpf}")
	public Cliente altera(@Valid @RequestBody Cliente cliente, @PathVariable Long cpf) throws ClienteNotFoundException {
		return this.clienteService.alteraCliente(cliente, cpf);		
	}
	
    @GetMapping("/{cpf}/emprestimos")
    public List<EmprestimoDTO> getEmprestimoByCliente(@PathVariable Long cpf) throws ClienteNotFoundException {
        Cliente cliente = clienteService.recuperarCliente(cpf);
        List<Emprestimo> emprestimos = cliente.getEmprestimos(); 
        
        List<EmprestimoDTO> emprestimosDTO = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            emprestimosDTO.add(new EmprestimoDTO(emprestimo));
        }
        
        return emprestimosDTO;
    }
	
    @GetMapping("/{cpf}/emprestimos/{id}")
    public EmprestimoDTO getEmprestimoByIdAndCliente(@PathVariable Long cpf, @PathVariable Long id) throws ClienteNotFoundException {
        Cliente cliente = clienteService.recuperarCliente(cpf);
        Emprestimo emprestimo = cliente.getEmprestimoById(id);
        return new EmprestimoDTO(emprestimo);
    }

		
}
