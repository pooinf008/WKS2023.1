package br.edu.ifba.inf011.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;

public class DesligadoState extends AbstractControladorState implements ControladorState{

	
	@Override
	public double monitorar(CalculoTemperaturaStrategy strategy, List<Termometro> termometros, List<Double> historico) {
		System.out.println("State: Desligar");
		return 0;
	}
	
	@Override
	public ControladorState ligar() {
		return new LigadoState();
	}


	@Override
	public ControladorState recarregar() {
		return new RecargaState();
	}	
		

}
