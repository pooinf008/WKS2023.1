package br.edu.ifba.inf011.criacional.af;

import br.edu.ifba.inf011.Atuador;
import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.atuadores.Resfriador;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.model.termometros.TermometroFaixa;

public class KitAlta implements KitTermometroAtuador{

	@Override
	public Termometro getTermometro() {
		return new TermometroAlta();
	}

	@Override
	public Atuador getAtuador() {
		return new Resfriador();
	}

}
