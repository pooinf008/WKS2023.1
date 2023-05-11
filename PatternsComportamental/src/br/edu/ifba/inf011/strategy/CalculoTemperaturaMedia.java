package br.edu.ifba.inf011.strategy;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public class CalculoTemperaturaMedia implements CalculoTemperaturaStrategy{

	@Override
	public void getTemperaturaAtuacao(List<Termometro> termometros, List<Double> historico) {
		double temperatura = 0;
		System.out.println("Politica: Media");
		for(Termometro termometro : termometros)
			temperatura +=termometro.lerTemperatura();
		historico.add(temperatura / termometros.size());
		return;
	}

}
