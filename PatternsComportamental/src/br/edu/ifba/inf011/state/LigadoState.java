package br.edu.ifba.inf011.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;

public class LigadoState extends AbstractControladorState implements ControladorState{

	@Override
	public double monitorar(CalculoTemperaturaStrategy strategy, List<Termometro> termometros, List<Double> historico) {
		System.out.println("State: Ligado");
		strategy.getTemperaturaAtuacao(termometros, historico);
		return -1.0;
	}

	@Override
	public ControladorState ligar() {
		return this;
	}

	@Override
	public ControladorState desligar() {
		return new DesligadoState();
	}

	@Override
	public ControladorState economizar() {
		return new EconomiaState();
	}


}
