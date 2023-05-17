package br.edu.ifba.inf011.singleton;

import br.edu.ifba.inf011.exception.NutrienteNaoEncontradoException;
import br.edu.ifba.inf011.model.Nutriente;

public interface ArmazemNutrientes {

	public Nutriente create(String nome, String unidade, Double caloriaPorUnidade) ;
	public Nutriente create(String nome) throws NutrienteNaoEncontradoException;
	
}
