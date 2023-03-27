package br.edu.ifba.inf011.criacional.fm;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.TermometroAlta;
import br.edu.ifba.inf011.model.TermometroBasico;
import br.edu.ifba.inf011.model.TermometroComTrava;

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
