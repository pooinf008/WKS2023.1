package br.edu.ifba.inf011.model.atuadores;

import br.edu.ifba.inf011.Atuador;

public class AtuadorDummy implements Atuador{

	@Override
	public double definirTemperatura(double temperaturaAtual) {
		return 0;
	}

}
