package br.edu.ifba.inf011.builder;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.Alimento;
import br.edu.ifba.inf011.model.Preparo;

public class PreparoObjectBuilder implements PreparoBuilder{

	
	
	private String nome;
	private List<Alimento> alimentos;
	private boolean lowCarb;
	private boolean vegano;
	private boolean semLactose;
	private boolean semGluten;
	private boolean reduzidoSodio;
	private String modoDeFazer;	
	
	@Override
	public void reset() {
		this.nome = null;
		this.alimentos = new ArrayList<Alimento>();
		this.lowCarb = false;
		this.vegano = false;
		this.semLactose = false;
		this.semGluten = false;
		this.reduzidoSodio = false;
		this.modoDeFazer = "";
		
		
	}

	@Override
	public void addAlimento(Alimento alimento) {
		this.alimentos.add(alimento);
	}

	@Override
	public void lowCarb() {
		this.lowCarb = true;
	}

	@Override
	public void semGluten() {
		this.semGluten = true;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Preparo get() {
		return new Preparo(this.nome, this.alimentos, this.lowCarb, 
						   this.vegano, this.semLactose, this.semGluten,
						   this.reduzidoSodio, this.modoDeFazer);
	}

}
