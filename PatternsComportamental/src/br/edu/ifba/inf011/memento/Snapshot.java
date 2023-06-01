package br.edu.ifba.inf011.memento;

import java.util.ArrayList;
import java.util.List;

public class Snapshot implements NarrowSnapshot{

	private String id;
	private Double bateria;
	private Integer ciclo;
	private List<Double> historico;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBateria(Double bateria) {
		this.bateria = bateria;
	}

	public Double getBateria() {
		return this.bateria;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	public Integer getCiclo() {
		return this.ciclo;
	}

	public void setHistorico(List<Double> historico) {
		this.historico = new ArrayList<Double>(historico);
	}

	public List<Double> getHistorico() {
		return this.historico;
	}
	
}
