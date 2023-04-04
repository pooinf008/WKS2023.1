package br.edu.ifba.inf011.criacional.af;

import br.edu.ifba.inf011.Atuador;
import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.termometros.TermometroFaixa;

public class KitFaixa implements KitTermometroAtuador{

	@Override
	public Termometro getTermometro() {
		return new TermometroFaixa();
	}

	@Override
	public Atuador getAtuador() {
		return new Estabilizador();
	}

}
