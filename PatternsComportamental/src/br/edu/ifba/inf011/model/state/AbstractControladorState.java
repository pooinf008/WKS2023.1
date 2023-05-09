package br.edu.ifba.inf011.model.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public abstract class AbstractControladorState implements ControladorState{

	public abstract double monitorar(List<Termometro> termometros, List<Double> historico);

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
