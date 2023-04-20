package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.prototype.Prototipo;

public interface Ambiente extends Prototipo{
	public void randomizar(int maximo);
	public double getTemperatura();
	public void setTemperaturaAtuacao(double temperaturaAtuacao);
	public String getId();
}
