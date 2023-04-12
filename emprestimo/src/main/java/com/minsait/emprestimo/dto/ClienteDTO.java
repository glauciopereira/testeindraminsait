package com.minsait.emprestimo.dto;

import com.minsait.emprestimo.entity.Cliente;

public class ClienteDTO {

    private Long cpf;
    private String nome;
    private String logradouro;
    private int numero;
    private String cep;
    private String complemento;
    private int ddd;
    private Long numTelefone;
    private double rendimentoMensal;
    
    public ClienteDTO(Cliente cliente) {
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.logradouro = cliente.getLogradouro();
        this.numero = cliente.getNumero();
        this.cep = cliente.getCep();
        this.complemento = cliente.getComplemento();
        this.ddd = cliente.getDdd();
        this.numTelefone = cliente.getNumTelefone();
        this.rendimentoMensal = cliente.getRendimentoMensal();
    }

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public double getRendimentoMensal() {
		return rendimentoMensal;
	}

	public void setRendimentoMensal(double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
    
    
}
