package br.edu.ifba.inf011.model.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public class RecargaState extends AbstractControladorState implements ControladorState{

	@Override
	public double monitorar(List<Termometro> termometros, List<Double> historico) {
		System.out.println("State: Recarregar");
		return +0.5;
	}
	
	@Override
	public ControladorState ligar() {
		return new LigadoState();
	}



}
