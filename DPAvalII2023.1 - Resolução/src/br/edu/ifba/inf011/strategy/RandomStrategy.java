package br.edu.ifba.inf011.strategy;

import java.util.List;
import java.util.Random;

import br.edu.ifba.inf011.composite.Tocavel;

public class RandomStrategy implements PlayerStrategy{

	@Override
	public boolean temProximo(Integer index, List<Tocavel> tocaveis) {
		return true;
	}

	@Override
	public String proximo(Integer index, List<Tocavel> tocaveis) {
		return tocaveis.get((new Random()).nextInt(tocaveis.size())).randomize() ; 
	}

}
