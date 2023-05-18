package br.edu.ifba.inf011.model.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public class DesligadoState extends AbstractControladorState implements ControladorState{

	
	@Override
	public double monitorar(List<Termometro> termometros, List<Double> historico) {
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
