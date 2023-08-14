package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.composite.Tocavel;

public interface Musica extends Tocavel{
	public void reset();
	public Boolean finish();
	public String play();
}
