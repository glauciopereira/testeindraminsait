package com.minsait.emprestimo.entity;


import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
public class Cliente {
	

	
	@Id
	private Long cpf;
	
	@NotEmpty(message = "Nome nao pode ser nulo")
	private String nome;
	
	@NotEmpty(message = "Logradouro nao pode ser nulo")
	private String logradouro;
	
	@NotNull
	@Range(min= 1)
	private int numero;
	
	@NotEmpty(message = "CEP nao pode ser nulo")
	private String cep;
	private String complemento;
	
	@NotNull
	@Range(min= 11)
	private int ddd;
	
	@NotNull
	@Range(min= 1)
	private Long numTelefone;
	
	@NotNull
	@Range(min= 1)
	private double rendimentoMensal;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Emprestimo> emprestimos;
	
	
    public Cliente() {
        this.emprestimos = new ArrayList<>();
        
    }
    
    public Cliente(Long cpf) {
        this.cpf = cpf;
    }
    
    
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    
    public void addEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}


    public List<Emprestimo> getConsultas() {
        return emprestimos;
    }
    public void setConsultas(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

	
	public Long getCpf() {
		return cpf;
	}



	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}





	public double getRendimentoMensal() {
		return rendimentoMensal;
	}



	public void setRendimentoMensal(double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public int getDdd() {
		return ddd;
	}



	public void setDdd(int ddd) {
		this.ddd = ddd;
	}



	public Long getNumTelefone() {
		return numTelefone;
	}



	public void setNumTelefone(Long numTelefone) {
		this.numTelefone = numTelefone;
	}
	
	
	public Emprestimo getEmprestimoById(Long id) {
	    for (Emprestimo emprestimo : emprestimos) {
	        if (emprestimo.getId().equals(id)) {
	            return emprestimo;
	        }
	    }
	    return null;
	}
	

}
