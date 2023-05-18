package br.edu.ifba.inf011.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;

public class RecargaState extends AbstractControladorState implements ControladorState{

	@Override
	public double monitorar(CalculoTemperaturaStrategy strategy, List<Termometro> termometros, List<Double> historico) {
		System.out.println("State: Recarga");
		return +0.5;
	}
	
	@Override
	public ControladorState ligar() {
		return new LigadoState();
	}



}
