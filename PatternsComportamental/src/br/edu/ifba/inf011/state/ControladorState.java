package br.edu.ifba.inf011.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;

public interface ControladorState {
	
	public double monitorar(CalculoTemperaturaStrategy strategy, List<Termometro> termometros, List<Double> historico);
	public ControladorState ligar();
	public ControladorState desligar();
	public ControladorState economizar();
	public ControladorState recarregar();	

}
