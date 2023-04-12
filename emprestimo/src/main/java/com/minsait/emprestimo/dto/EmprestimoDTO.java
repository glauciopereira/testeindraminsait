package com.minsait.emprestimo.dto;

import java.util.Date;
import java.util.List;

import com.minsait.emprestimo.entity.Cliente;
import com.minsait.emprestimo.entity.Emprestimo;

public class EmprestimoDTO {

    private Long id;
	private double valorInicial;
	private double valorFinal; 
	private String relacionamento;
    private Date   dataInicial;
    private Date   dataFinal;
    private Long cpfCliente;
    private List<EmprestimoDTO> emprestimos;


    public EmprestimoDTO(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.valorInicial = emprestimo.getValorInicial();
        this.valorFinal = emprestimo.getValorFinal();
        this.relacionamento = emprestimo.getRelacionamento();
        this.dataInicial = emprestimo.getDataInicial();
        this.dataFinal = emprestimo.getDataFinal();
        this.cpfCliente = emprestimo.getCliente().getCpf();
       
    }
    
    
    public EmprestimoDTO() {
    }
    
    
    public void EmprestimoIdDTO(Long id) {
        this.id = id;
    }
    
  
    
    
    public Emprestimo toEmprestimo() {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setValorInicial(this.valorInicial);
        emprestimo.setValorFinal(this.valorFinal);
        emprestimo.setRelacionamento(this.relacionamento);
        emprestimo.setDataInicial(this.dataInicial);
        emprestimo.setDataFinal(this.dataFinal);
        emprestimo.setCliente(new Cliente(this.cpfCliente)); 
        return emprestimo;
    }
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public Long getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(Long cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	

    
    public void EmprestimosDTO(List<EmprestimoDTO> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    public List<EmprestimoDTO> getEmprestimos() {
        return emprestimos;
    }
    
    public void setEmprestimos(List<EmprestimoDTO> emprestimos) {
        this.emprestimos = emprestimos;
    }
	

    
}