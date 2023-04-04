package br.edu.ifba.inf011.model.atuadores;

import br.edu.ifba.inf011.Atuador;

public class Estabilizador implements Atuador{

	private double tempMaxAtuacao = 29;
	private double tempMinAtuacao = 26;
	
	public Estabilizador() {
		
	}
	
	@Override
	public double definirTemperatura(double temperaturaAtual) {
		double temperatura;
		if(temperaturaAtual > this.tempMaxAtuacao) {
			temperatura = temperaturaAtual - this.tempMaxAtuacao;
			System.err.println("\t>>RESFRIAR: " + temperatura + "°C<<");
			return -temperatura;
		}
		if(temperaturaAtual < this.tempMinAtuacao) {
			temperatura =  this.tempMinAtuacao - temperaturaAtual;
			System.err.println("\t>>AQUECER: " + temperatura + "°C<<");
			return temperatura;
		}	
		
		return 0;
	}

}
