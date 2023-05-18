package br.edu.ifba.inf011.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;

public class EconomiaState extends AbstractControladorState implements ControladorState{

	private boolean ciclo = true;
	
	
	@Override
	public double monitorar(CalculoTemperaturaStrategy strategy, List<Termometro> termometros, List<Double> historico) {
		Double consumo = 0.0;
		System.out.println("State: Economia");
		if(ciclo) {
			strategy.getTemperaturaAtuacao(termometros, historico);
			consumo -= 1.0;
		}else {
			historico.add(historico.get(historico.size() - 1));
		}
		ciclo = !ciclo; 
		return consumo;
	}
	
	@Override
	public ControladorState ligar() {
		return new LigadoState();
	}



}
