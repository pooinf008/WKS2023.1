package br.edu.ifba.inf011.strategy;

import java.util.List;

import br.edu.ifba.inf011.composite.Tocavel;

public class RepeatAllStrategy implements PlayerStrategy{

	@Override
	public boolean temProximo(Integer index, List<Tocavel> tocaveis) {
		return true;
	}

	@Override
	public String proximo(Integer index, List<Tocavel> tocaveis) {
		return tocaveis.get(index % tocaveis.size()).execute();
	}

}
