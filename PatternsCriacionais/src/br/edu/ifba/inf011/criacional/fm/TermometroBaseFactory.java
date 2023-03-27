package br.edu.ifba.inf011.criacional.fm;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.TermometroAlta;
import br.edu.ifba.inf011.model.TermometroBasico;
import br.edu.ifba.inf011.model.TermometroComTrava;

public class TermometroBaseFactory implements TermometroFactory{
	
	public Termometro getTermometro(Ambiente ambiente, int valor) {
		Termometro termometro;
		if(valor == 0)
			termometro = new TermometroBasico(ambiente);
		else
			termometro = new TermometroAlta(ambiente, 28);
		return termometro;
	}	
	
	
	
}
