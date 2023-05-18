package br.edu.ifba.inf011.model.atuadores;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;

public class AtuadorDummy extends GenericAtuador implements Atuador{
	
	public AtuadorDummy() {
		super();
	}
	
	public AtuadorDummy(GenericAtuador atuador) {
		this(null, atuador.saidaAtuacao, atuador.tabsAtuacao);
	}	

	public AtuadorDummy(Ambiente ambiente, PrintStream saidaAtuacao, Integer tabsAtuacao) {
		super(ambiente, saidaAtuacao, tabsAtuacao);
	}

	public AtuadorDummy(Ambiente ambiente) {
		super(ambiente);
	}

	@Override
	public Double definirTemperatura(Double temperaturaAtual) {
		return 0.0;
	}


}
