package br.edu.ifba.inf011.tm;

import java.util.List;

import br.edu.ifba.inf011.cor.MonitorarHandler;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMaxima;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;


public class HandlerFullMaximaTM extends HandlerTemplateMethod{
	
	public HandlerFullMaximaTM(MonitorarHandler proximo) {
		super(proximo);
	}	
	
	@Override
	public Double executar(List<Termometro> termometros, List<Double> historico) {
		System.out.println("Monitoramento Full Maxima");
		CalculoTemperaturaStrategy strategy = new CalculoTemperaturaMaxima();
		strategy.getTemperaturaAtuacao(termometros, historico);
		return -1.0;
	}

	@Override
	public boolean isAplicavel(Double bateria) {
		return bateria > 60;
	}
	
	

	

}
