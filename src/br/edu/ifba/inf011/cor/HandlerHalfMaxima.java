package br.edu.ifba.inf011.cor;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMaxima;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMedia;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;


public class HandlerHalfMaxima extends AbstractMonitorarHandle{

	
	public Boolean ciclo = true;

	public HandlerHalfMaxima(MonitorarHandler proximo) {
		this.setProximo(proximo);
	}
	
	public Double monitorar(Double bateria, List<Termometro> termometros, List<Double> historico) {
		Double consumo = 0.0;
		CalculoTemperaturaStrategy strategy = new CalculoTemperaturaMaxima();
		if(bateria > 15) {
			if(this.ciclo) {
				strategy.getTemperaturaAtuacao(termometros, historico);
				consumo -= 1.0;
			}else {
				historico.add(historico.get(historico.size() - 1));
			}
			this.ciclo = !this.ciclo; 
			return consumo;
		}	
		return super.monitorar(bateria, termometros, historico);	
	};

}
