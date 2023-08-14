package br.edu.ifba.inf011.strategy;

import java.util.List;

import br.edu.ifba.inf011.composite.Tocavel;

public class PlayerAllStrategy implements PlayerStrategy{

	@Override
	public boolean temProximo(Integer index, List<Tocavel> tocaveis) {
		return index < tocaveis.size();
	}

	@Override
	public String proximo(Integer index, List<Tocavel> tocaveis) {
		return tocaveis.get(index).execute();
	}

}
