package br.edu.ifba.inf011.criacional.fm;

import br.edu.ifba.inf011.Atuador;
import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.atuadores.AtuadorDummy;
import br.edu.ifba.inf011.model.termometros.TermometroBasico;

public class AtuadorDummyConcreteCreator implements AtuadorConcreteCreator {

	@Override
	public Atuador getAtuador() {
		return new AtuadorDummy();
	}
	


}
