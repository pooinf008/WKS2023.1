package br.edu.ifba.inf011.tm;

import java.util.List;

import br.edu.ifba.inf011.cor.MonitorarHandler;
import br.edu.ifba.inf011.model.Termometro;

public abstract class HandlerTemplateMethod implements MonitorarHandler{

	private MonitorarHandler proximo;
	
	public HandlerTemplateMethod(MonitorarHandler proximo) {
		this.setProximo(proximo);
	}
	
	public HandlerTemplateMethod() {
		this(null);
	}	
	
	public void setProximo(MonitorarHandler proximo) {
		this.proximo = proximo;
	}
	
	public Double monitorar(Double bateria, List<Termometro> termometros, List<Double> historico) {
		if(this.isAplicavel(bateria)) {
			Double value = this.executar(termometros, historico);
			if(!this.encadear())
				return value; 
		}
		if (this.proximo != null)
			return this.proximo.monitorar(bateria, termometros, historico);
		return Double.NaN;
	}

	public boolean encadear() {
		return false;
	};

	public abstract Double executar(List<Termometro> termometros, List<Double> historico);

	public abstract boolean isAplicavel(Double bateria);

	


}
