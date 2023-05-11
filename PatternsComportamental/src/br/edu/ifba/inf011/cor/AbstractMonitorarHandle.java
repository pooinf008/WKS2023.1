package br.edu.ifba.inf011.cor;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public abstract class AbstractMonitorarHandle implements MonitorarHandler{
	
	private MonitorarHandler proximo;
	
	public AbstractMonitorarHandle(MonitorarHandler proximo) {
		this.setProximo(proximo);
	}
	
	public AbstractMonitorarHandle() {
		this(null);
	}	
	
	public void setProximo(MonitorarHandler proximo) {
		this.proximo = proximo;
	}
	
	public Double monitorar(Double bateria, List<Termometro> termometros, List<Double> historico) {
		if(this.proximo != null)
			return this.proximo.monitorar(bateria, termometros, historico);
		else
			return Double.NaN;
	}; 
	
	

}
