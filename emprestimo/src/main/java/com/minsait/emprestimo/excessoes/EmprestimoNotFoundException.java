package com.minsait.emprestimo.excessoes;



public class EmprestimoNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	
    public EmprestimoNotFoundException(Long id) {
        super("Não foi possível encontrar o empréstimo com o ID: " + id);
    }
}