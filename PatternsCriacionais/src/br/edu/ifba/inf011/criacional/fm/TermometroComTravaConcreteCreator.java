package br.edu.ifba.inf011.criacional.fm;

import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.TermometroAlta;
import br.edu.ifba.inf011.model.TermometroComTrava;

public class TermometroComTravaConcreteCreator implements TermometroConcreteCreator {
	
	public Termometro getTermometro() {
		return new TermometroComTrava();
	}

}
