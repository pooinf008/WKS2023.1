package br.edu.ifba.inf011.criacional.fm;

import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.model.termometros.TermometroFaixa;

public class TermometroFaixaConcreteCreator implements TermometroConcreteCreator {
	
	public Termometro getTermometro() {
		return new TermometroFaixa();
	}

}
