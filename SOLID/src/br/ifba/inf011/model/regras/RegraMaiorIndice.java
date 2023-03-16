package br.ifba.inf011.model.regras;

import br.ifba.inf011.model.Funcionario;
import br.ifba.inf011.model.FuncionarioIF;
import br.ifba.inf011.model.Reajustavel;
import br.ifba.inf011.model.exception.RHException;

public class RegraMaiorIndice implements Regra{

	@Override
	public void validar(Reajustavel funcionario, double indice) throws RHException {
		if (indice > 0.05) 
			throw new RHException("INDICE SUPERIOR AO PERMITIDO");
		return; 
	}

}
