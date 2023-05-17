package br.edu.ifba.inf011.builder;

import br.edu.ifba.inf011.model.Alimento;

public interface PreparoBuilder {

	public void reset();
	public void addAlimento(Alimento alimento);
	public void lowCarb();
	public void semGluten();
	public void setNome(String string);

}
