package br.edu.ifba.inf011.strategy;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public interface CalculoTemperaturaStrategy {
	
	public void getTemperaturaAtuacao(List<Termometro> termometros, List<Double> historico); 

}
