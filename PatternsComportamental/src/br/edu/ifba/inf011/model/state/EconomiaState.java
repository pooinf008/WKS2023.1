package br.edu.ifba.inf011.model.state;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public class EconomiaState extends AbstractControladorState implements ControladorState{

	private boolean ciclo = true;
	
	
	@Override
	public double monitorar(List<Termometro> termometros, List<Double> historico) {
		Double consumo = 0.0;
		System.out.println("State: Economia");
		if(ciclo) {
			double temperatura = this.getTempMedia(termometros);
			historico.add(temperatura);
			consumo -= 1.0;
		}else {
			historico.add(historico.get(historico.size() - 1));
		}
		ciclo = !ciclo; 
		return consumo;
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
		return new LigadoState();
	}



}
