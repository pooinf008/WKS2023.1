package br.edu.ifba.inf011.criacional.afv2;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Atuador;
import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.termometros.TermometroFaixa;

public class KitFaixa extends AbstractKitTermometroAtuador implements KitTermometroAtuador{

	public KitFaixa(Ambiente ambiente) {
		super(ambiente);
	}

	@Override
	public Termometro getTermometro() {
		try {
			return  this.getTermometro("FAIXA");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Atuador getAtuador() {
		try {
			return this.getAtuador("ESTABILIZADOR");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
