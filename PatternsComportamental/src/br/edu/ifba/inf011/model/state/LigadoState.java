package br.edu.ifba.inf011.model.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public class LigadoState extends AbstractControladorState implements ControladorState{

	@Override
	public double monitorar(List<Termometro> termometros, List<Double> historico) {
		double temperatura = this.getTempMedia(termometros);
		historico.add(temperatura);
		return -1.0;
	}
	
	private double getTempMedia(List<Termometro> termometros) {
		double temperatura = 0;
		System.out.println("State: Ligado");
		for(Termometro termometro : termometros)
			temperatura +=termometro.lerTemperatura();
		return temperatura / termometros.size();
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
