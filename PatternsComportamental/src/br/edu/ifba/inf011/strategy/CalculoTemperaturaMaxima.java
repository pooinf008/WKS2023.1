package br.edu.ifba.inf011.strategy;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public class CalculoTemperaturaMaxima implements CalculoTemperaturaStrategy{

	@Override
	public void getTemperaturaAtuacao(List<Termometro> termometros, List<Double> historico) {
		double temperatura = 0;
		double tempMaxima = 0;
		System.out.println("Politica: Maxima");
		for(Termometro termometro : termometros) {
			temperatura = termometro.lerTemperatura();
			if(tempMaxima < temperatura)
				tempMaxima = temperatura;
		}
		historico.add(tempMaxima);
	}

}
