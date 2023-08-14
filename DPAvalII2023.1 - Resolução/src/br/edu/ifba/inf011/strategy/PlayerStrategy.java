package br.edu.ifba.inf011.strategy;

import java.util.List;

import br.edu.ifba.inf011.composite.Tocavel;

public interface PlayerStrategy {

	public boolean temProximo(Integer index, List<Tocavel> tocaveis);
	public String proximo(Integer index, List<Tocavel> tocaveis);
}
