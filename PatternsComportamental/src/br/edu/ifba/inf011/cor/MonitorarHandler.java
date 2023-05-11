package br.edu.ifba.inf011.cor;

import java.util.List;

import br.edu.ifba.inf011.model.Termometro;

public interface MonitorarHandler {

	public void setProximo(MonitorarHandler proximo);
	public Double monitorar(Double bateria, List<Termometro> termometros, List<Double> historico);

}
