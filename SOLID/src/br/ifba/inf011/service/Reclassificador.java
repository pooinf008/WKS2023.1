package br.ifba.inf011.service;

import br.ifba.inf011.model.Reclassificavel;

public class Reclassificador {
	
	
	public void reclassificar(Reclassificavel funcionario) {
		// REGRA PARA VERIFICAR SE É POSSIVEL RECLASSIFICAR
		funcionario.reclassificar();
	}

}
