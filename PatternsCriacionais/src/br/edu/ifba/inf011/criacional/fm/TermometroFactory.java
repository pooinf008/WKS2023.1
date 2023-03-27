package br.edu.ifba.inf011.criacional.fm;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Termometro;

public interface TermometroFactory {
	
	public Termometro getTermometro(Ambiente ambiente, int valor);

}
