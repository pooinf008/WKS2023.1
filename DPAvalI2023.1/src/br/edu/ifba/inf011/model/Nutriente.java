package br.edu.ifba.inf011.model;

import java.util.Objects;

public class Nutriente {
	
	private String nome;
	private String unidade;
	private Double caloriaPorUnidade;
	
	public Nutriente(String nome) {
		this(nome, null, 0.0);
	}
	
	public Nutriente(String nome, String unidade, Double caloriaPorUnidade) {
		super();
		this.nome = nome;
		this.unidade = unidade;
		this.caloriaPorUnidade = caloriaPorUnidade;
	}


	public String getNome() {
		return nome;
	}

	public String getUnidade() {
		return unidade;
	}

	public Double getCaloriaPorUnidade() {
		return caloriaPorUnidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public void setCaloriaPorUnidade(Double caloriaPorUnidade) {
		this.caloriaPorUnidade = caloriaPorUnidade;
	}
	
	public String toString() {
		return this.nome + " - " + this.caloriaPorUnidade + " calorias por " + this.unidade;  
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nutriente other = (Nutriente) obj;
		return Objects.equals(nome, other.nome);
	}
	
	
	
	

}
