package br.edu.ifba.inf011.model;


public interface Controlador {
	public void monitorar() throws Exception;
	public String getEspecificacao();
	public void ligar();
	public void desligar();
	public void economizar();
	public void recarregar();
}