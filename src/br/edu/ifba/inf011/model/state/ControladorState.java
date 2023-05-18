package br.edu.ifba.inf011.model.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public interface ControladorState {
	
	public double monitorar(List<Termometro> termometros, List<Double> historico);
	public ControladorState ligar();
	public ControladorState desligar();
	public ControladorState economizar();
	public ControladorState recarregar();	

}
