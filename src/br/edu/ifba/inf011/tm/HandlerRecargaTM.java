package br.edu.ifba.inf011.tm;

import java.util.List;

import br.edu.ifba.inf011.cor.MonitorarHandler;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMaxima;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMedia;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;


public class HandlerRecargaTM extends HandlerTemplateMethod{
	
	public HandlerRecargaTM(MonitorarHandler proximo) {
		super(proximo);
	}	

	@Override
	public Double executar(List<Termometro> termometros, List<Double> historico) {
		System.out.println("Monitoramento Recarga");
		return +0.5;
	};

	@Override
	public boolean isAplicavel(Double bateria) {
		return true;
	};

}
