package br.edu.ifba.inf011.model;

public interface Ambiente{
	public void randomizar(int maximo);
	public double getTemperatura();
	public void setTemperaturaAtuacao(double temperaturaAtuacao);
	public String getId();
}
