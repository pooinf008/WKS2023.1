package br.edu.ifba.inf011.tm;

import java.util.List;

import br.edu.ifba.inf011.cor.MonitorarHandler;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMedia;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;


public class HandlerHalfMediaTM extends HandlerTemplateMethod{
	
	public Boolean ciclo = true;
	
	public HandlerHalfMediaTM(MonitorarHandler proximo) {
		super(proximo);
	}	
	
	public Double monitorar(Double bateria, List<Termometro> termometros, List<Double> historico) {
		return super.monitorar(bateria, termometros, historico);	
	}

	@Override
	public Double executar(List<Termometro> termometros, List<Double> historico) {
		Double consumo = 0.0;
		System.out.println("Monitoramento Half Media");
		CalculoTemperaturaStrategy strategy = new CalculoTemperaturaMedia();
		if(this.ciclo) {
			strategy.getTemperaturaAtuacao(termometros, historico);
			consumo -= 1.0;
		}else {
			historico.add(historico.get(historico.size() - 1));
		}
		this.ciclo = !this.ciclo; 
		return consumo;
	}

	@Override
	public boolean isAplicavel(Double bateria) {
		return bateria > 30;
	}

}
