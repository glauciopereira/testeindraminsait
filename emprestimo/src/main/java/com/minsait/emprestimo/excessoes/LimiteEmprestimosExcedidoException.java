package com.minsait.emprestimo.excessoes;

public class LimiteEmprestimosExcedidoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	
    public LimiteEmprestimosExcedidoException() {
        super("O cliente atingiu o limite de empréstimos.");
    }
}