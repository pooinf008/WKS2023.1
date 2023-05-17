package br.edu.ifba.inf011.singleton;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.inf011.exception.NutrienteNaoEncontradoException;
import br.edu.ifba.inf011.model.Nutriente;

public class CatalogoNutriente implements ArmazemNutrientes{
	
	public static CatalogoNutriente catalogoNutriente;
	
	
	public static CatalogoNutriente instance() {
		if(CatalogoNutriente.catalogoNutriente == null)
			CatalogoNutriente.catalogoNutriente = new CatalogoNutriente();
		return CatalogoNutriente.catalogoNutriente;
	}

	private Map<String, Nutriente> catalogo;

	
	private CatalogoNutriente() {
		this.catalogo = new HashMap<String, Nutriente>();
		this.init();
	}
	
	public void init() {
		this.create("CARBOIDRATO", "GRAMA", 4.0);
		this.create("PROTEINA", "GRAMA", 4.0);
		this.create("GORDURA", "GRAMA", 9.0);		
	}
	
	public Nutriente create(String nome, String unidade, Double caloriaPorUnidade) {
		Nutriente nutriente = this.catalogo.get(nome);
		if(nutriente == null)
			nutriente = new Nutriente(nome);
		nutriente.setCaloriaPorUnidade(caloriaPorUnidade);
		nutriente.setUnidade(unidade);
		this.catalogo.put(nutriente.getNome(), nutriente);
		return nutriente;
	}
	
	public Nutriente create(String nome) throws NutrienteNaoEncontradoException {
		Nutriente nutriente = this.catalogo.get(nome);
		if(nutriente == null)
			throw new NutrienteNaoEncontradoException(nome);
		return nutriente;
	}
	

}
