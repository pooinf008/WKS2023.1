package br.edu.ifba.inf011.model;

import java.util.HashSet;
import java.util.Set;

import br.edu.ifba.inf011.exception.NutrienteNaoEncontradoException;
import br.edu.ifba.inf011.singleton.CatalogoNutriente;

public class Alimento {
	
	
	class QuantidadeNutriente{
		private Double fracaoUnidade;
		private Nutriente nutriente;
		
		private QuantidadeNutriente(Nutriente nutriente, Double fracaoUnidade) {
			this.nutriente = nutriente;
			this.fracaoUnidade = fracaoUnidade;
		}

		public String getNome() {
			return this.nutriente.getNome();
		}		

		
		public Double getFracaoUnidade() {
			return this.fracaoUnidade;
		}		
		
		public String toString() {
			return this.nutriente.getNome() + ": " + this.fracaoUnidade * this.nutriente.getCaloriaPorUnidade();
		}
		
	}
	
	private String nome;
	private Set<QuantidadeNutriente> quantidadeNutrientes;
	
	public Alimento(String nome) {
		this.nome = nome;
		this.quantidadeNutrientes = new HashSet<QuantidadeNutriente>();
	}
	
	public Alimento(String nome, 
					Double qtdeCHO, 
					Double qtdePTN,
					Double qtdeLIP) throws NutrienteNaoEncontradoException {
		this(nome);
		this.addNutriente(CatalogoNutriente.instance().create("CARBOIDRATO"), qtdeCHO);
		this.addNutriente(CatalogoNutriente.instance().create("PROTEINA"), qtdePTN);
		this.addNutriente(CatalogoNutriente.instance().create("GORDURA"), qtdeLIP);
	}	
	
	public void addNutriente(Nutriente nutriente, Double fracaoUnidade) {
		this.quantidadeNutrientes.add(new QuantidadeNutriente(nutriente, fracaoUnidade));
	}
	
	public Double getQuantidadeNutriente(String nutriente) {
		for(QuantidadeNutriente qtdeNutriente : this.quantidadeNutrientes)
			if(qtdeNutriente.getNome().equals(nutriente))
				return qtdeNutriente.getFracaoUnidade();
		return 0.0;
	}
	
	
	public String toString() {
		StringBuffer str = new StringBuffer(this.nome + "\n");
		for(QuantidadeNutriente nutriente : this.quantidadeNutrientes)
			str.append("\t" + nutriente.toString() + "\n");
		return str.toString();
	}
	
	

}
