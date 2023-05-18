package br.edu.ifba.inf011.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;

public abstract class AbstractControladorState implements ControladorState{

	public abstract double monitorar(CalculoTemperaturaStrategy strategy,  List<Termometro> termometros, List<Double> historico);

	@Override
	public ControladorState ligar() {
		return this;
	}

	@Override
	public ControladorState desligar() {
		return this;
	}

	@Override
	public ControladorState economizar() {
		return this;
	}

	@Override
	public ControladorState recarregar() {
		return this;
	}

}
