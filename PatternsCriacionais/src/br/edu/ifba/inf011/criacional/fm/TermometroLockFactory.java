package br.edu.ifba.inf011.criacional.fm;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.model.termometros.TermometroBasico;
import br.edu.ifba.inf011.model.termometros.TermometroComTrava;

public class TermometroLockFactory extends TermometroBaseFactory implements TermometroFactory{
	
	public Termometro getTermometro(Ambiente ambiente, int valor) {
		Termometro termometro;
		if(valor == 2)
			termometro = new TermometroComTrava(ambiente, 28);
		else
			termometro = super.getTermometro(ambiente, valor);
		return termometro;
	}
	
	
}
