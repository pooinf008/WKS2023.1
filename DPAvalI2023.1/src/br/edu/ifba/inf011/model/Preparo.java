package br.edu.ifba.inf011.model;

import java.util.List;

public class Preparo {
	
	private String nome;
	private List<Alimento> alimentos;
	private boolean lowCarb;
	private boolean lowVegano;
	private boolean semLactose;
	private boolean semGluten;
	private boolean reduzidoSodio;
	private String modoDeFazer;
	
	public Preparo(String nome, List<Alimento> alimentos, boolean lowCarb, boolean lowVegano, boolean semLactose,
			boolean semGluten, boolean reduzidoSodio, String modoDeFazer) {
		super();
		this.nome = nome;
		this.alimentos = alimentos;
		this.lowCarb = lowCarb;
		this.lowVegano = lowVegano;
		this.semLactose = semLactose;
		this.semGluten = semGluten;
		this.reduzidoSodio = reduzidoSodio;
		this.modoDeFazer = modoDeFazer;
	}
	
	
	
	public String ingredientes() {
		StringBuffer str = new StringBuffer(this.nome + "\n");
		for(Alimento alimento : this.alimentos)
			str.append("\t" + alimento.toString() + "\n");
		return str.toString();
	}
	
	

}
