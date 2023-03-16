package br.ifba.inf011.model;

import java.math.BigDecimal;

import br.ifba.inf011.model.exception.RHException;

public interface Reajustavel {
	
	public void reajustar(BigDecimal novoSalario) throws RHException;
	public BigDecimal getSalario();	

}
