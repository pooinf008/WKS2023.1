package br.ifba.inf011.model.regras;

import br.ifba.inf011.model.Funcionario;
import br.ifba.inf011.model.exception.RHException;

public interface Regra {
	
	public void validar(Funcionario funcionario, double indice) throws RHException;

}
