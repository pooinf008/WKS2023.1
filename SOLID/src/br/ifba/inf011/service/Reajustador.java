package br.ifba.inf011.service;

import java.math.BigDecimal;
import java.util.List;

import br.ifba.inf011.model.Funcionario;
import br.ifba.inf011.model.FuncionarioIF;
import br.ifba.inf011.model.Reajustavel;
import br.ifba.inf011.model.exception.RHException;
import br.ifba.inf011.model.regras.Regra;

public class Reajustador {
	
	private List<Regra> regras;
	
	
	
	public Reajustador(List<Regra> regras) {
		this.regras = regras;
	}



	public void reajustar(Reajustavel funcionario, double indice) throws RHException {
		for(Regra regra : this.regras)
			regra.validar(funcionario, indice);
		BigDecimal novoSalario = funcionario.getSalario().multiply(new BigDecimal(1 + indice));
		funcionario.reajustar(novoSalario);
	}
	
		

}
