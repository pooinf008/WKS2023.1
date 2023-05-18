package br.edu.ifba.inf011.cor;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMaxima;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMedia;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;


public class HandlerFullMaxima extends AbstractMonitorarHandle{
	
	public HandlerFullMaxima(MonitorarHandler proximo) {
		this.setProximo(proximo);
	}	
		
	
	public Double monitorar(Double bateria, List<Termometro> termometros, List<Double> historico) {
		if(bateria > 60) {
			System.out.println("Monitoramento Full Maxima");
			CalculoTemperaturaStrategy strategy = new CalculoTemperaturaMaxima();
			strategy.getTemperaturaAtuacao(termometros, historico);
			return -1.0;
		}	
		return super.monitorar(bateria, termometros, historico);	
	};

}
