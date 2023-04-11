package br.edu.ifba.inf011.criacional.afv2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Atuador;
import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.atuadores.Resfriador;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.model.termometros.TermometroFaixa;

public class KitAlta extends AbstractKitTermometroAtuador implements KitTermometroAtuador{

	public KitAlta(Ambiente ambiente) {
		super(ambiente);
	}

	@Override
	public Termometro getTermometro() {
		try {
			return  this.getTermometro("ALTA");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Atuador getAtuador() {
		try {
			return this.getAtuador("RESFRIADOR");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
