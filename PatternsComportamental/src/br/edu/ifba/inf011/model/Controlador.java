package br.edu.ifba.inf011.model;

import java.util.List;

import br.edu.ifba.inf011.memento.NarrowSnapshot;

public interface Controlador {
	public void monitorar() throws Exception;
	public String getEspecificacao();
	public void ligar();
	public void desligar();
	public void economizar();
	public void recarregar();
	public void restore(NarrowSnapshot snapshot);
	public NarrowSnapshot save(String id);
	
	public Double getBateria();
	public Integer getCiclos();
	public List<Double> getHistorico();
	
}