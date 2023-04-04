package br.edu.ifba.inf011.criacional.fm;

import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.termometros.TermometroBasico;

public class TermometroBasicoConcreteCreator implements TermometroConcreteCreator {
	
	public Termometro getTermometro() {
		return new TermometroBasico();
	}

}
