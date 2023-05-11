package br.edu.ifba.inf011.cor;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMaxima;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMedia;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;


public class HandlerRecarga extends AbstractMonitorarHandle{
	
	public HandlerRecarga(MonitorarHandler proximo) {
		this.setProximo(proximo);
	}	
	
	public Double monitorar(Double bateria, List<Termometro> termometros, List<Double> historico) {
		System.out.println("Monitoramento Recarga");
		return +0.5;
	};

}
