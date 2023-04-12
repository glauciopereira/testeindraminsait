package com.minsait.emprestimo.tipos;

import java.math.BigDecimal;
import java.math.MathContext;

public class tipoCliente {
	
	
public enum Status {
		
	
	Bronze(1) {
		@Override
		public BigDecimal calculaValorFinal(BigDecimal valorAtual) {
			BigDecimal fatorMultiplicador = new BigDecimal(1.8);
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
		}
	},
	 
    Prata(2) {
		@Override
		public BigDecimal calculaValorFinal(BigDecimal valorAtual) {
			
			if(valorAtual.compareTo(BigDecimal.ZERO) > 5000.00) {
				
			BigDecimal fatorMultiplicador = new BigDecimal(1.4);
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
			} else {
				
			BigDecimal fatorMultiplicador = new BigDecimal(1.6);
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
			}
					
		}
	},
 
    Ouro(3) {
		@Override
		public BigDecimal calculaValorFinal(BigDecimal valorAtual) {
			
			BigDecimal fatorMultiplicador = new BigDecimal(1.3);
			return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
					
		}
	},
    
	  Ouro_MenorTaxa(4) {
			@Override
			public BigDecimal calculaValorFinal(BigDecimal valorAtual) {
				
				BigDecimal fatorMultiplicador = new BigDecimal(1.2);
				return valorAtual.multiply(fatorMultiplicador, MathContext.DECIMAL32);
			}
			
	};
	
	
    private int codigo;
 
    private Status(int codigo) {
 
        this.codigo = codigo;
    }
 
    public int getCodigo() { 
        return this.codigo;
    }
    
    public abstract BigDecimal calculaValorFinal(BigDecimal valorAtual);

  }
}
