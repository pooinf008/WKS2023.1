package br.ifba.inf011.model.regras;

import br.ifba.inf011.model.FuncionarioIF;
import br.ifba.inf011.model.Reajustavel;
import br.ifba.inf011.model.exception.RHException;

public interface Regra {
	
	public void validar(Reajustavel funcionario, double indice) throws RHException;

}
