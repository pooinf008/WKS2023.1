package br.edu.ifba.inf011.cor;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMedia;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;


public class HandlerFullMedia extends AbstractMonitorarHandle{
	
	public HandlerFullMedia(MonitorarHandler proximo) {
		this.setProximo(proximo);
	}	
			
	
	public Double monitorar(Double bateria, List<Termometro> termometros, List<Double> historico) {
		if(bateria > 75) {
			System.out.println("Monitoramento Full Media");
			CalculoTemperaturaStrategy strategy = new CalculoTemperaturaMedia();
			strategy.getTemperaturaAtuacao(termometros, historico);
			return -1.0;
		}	
		return super.monitorar(bateria, termometros, historico);	
	};

}
