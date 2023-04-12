package com.minsait.emprestimo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "cpfCliente", referencedColumnName = "cpf", nullable = false)
	 @JsonIgnore
	 private Cliente cliente;
	 
	private double valorInicial;
	private double valorFinal; 
	private String relacionamento;
    private Date dataInicial;
    private Date dataFinal;
    
    
 
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	


	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	} 
	
	
	public double getValorInicial() {
		return valorInicial;
	}
	
	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}
	
	public double getValorFinal() {
		return valorFinal;
	}
	
	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	public String getRelacionamento() {
		return relacionamento;
	}
	
	public void setRelacionamento(String relacionamento) {
		this.relacionamento = relacionamento;
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	} 
    
    
    
    

}
