package br.edu.ifba.inf011.model.atuadores;

import br.edu.ifba.inf011.Atuador;

public class Resfriador implements Atuador{

	private double tempAtuacao = 29;
	
	public Resfriador() {
		
	}
	
	@Override
	public double definirTemperatura(double temperaturaAtual) {
		double temperatura = temperaturaAtual - this.tempAtuacao;
		if(temperaturaAtual > this.tempAtuacao) {
			System.err.println("\t>>ATUAÇÃO: " + temperatura + "°C<<");
			return -temperatura;
		}	
		return 0;
	}

}
