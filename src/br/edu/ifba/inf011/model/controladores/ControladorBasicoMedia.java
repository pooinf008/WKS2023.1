package br.edu.ifba.inf011.model.controladores;

import br.edu.ifba.inf011.cor.MonitorarHandler;
import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.TipoControlador;

public class ControladorBasicoMedia extends ControladorBasico{

	public ControladorBasicoMedia(TipoControlador tipo, Ambiente ambiente, Integer qtdeTermometros, Double tempMaxima, MonitorarHandler handler) {
		super(tipo, ambiente, qtdeTermometros, tempMaxima, handler);
	}
	
	public  double getTemperatura() {
		double temperatura = 0;
		for(Termometro termometro : this.termometros)
			temperatura +=termometro.lerTemperatura();
		return temperatura / this.termometros.size();
	}	

}
