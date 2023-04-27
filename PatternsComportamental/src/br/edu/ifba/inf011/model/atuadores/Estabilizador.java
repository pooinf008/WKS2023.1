package br.edu.ifba.inf011.model.atuadores;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;

public class Estabilizador extends GenericAtuador  implements Atuador{

	private Double tempMinimaAtuacao;
	private Double tempMaximaAtuacao; 
	
	public Estabilizador(Estabilizador atuador) {
		this(null, atuador.tempMaximaAtuacao, atuador.tempMinimaAtuacao,  atuador.saidaAtuacao, atuador.tabsAtuacao);
	}
	
	public Estabilizador(Ambiente ambiente, Double tempMaximaAtuacao, Double tempMinimaAtuacao) {
		super(ambiente);
		this.tempMaximaAtuacao = tempMaximaAtuacao;
		this.tempMinimaAtuacao = tempMinimaAtuacao;
	}
	
	public Estabilizador(Ambiente ambiente, Double tempMaximaAtuacao, Double tempMinimaAtuacao, PrintStream saidaAtuacao, Integer tabsAtuacao) {
		super(ambiente, saidaAtuacao, tabsAtuacao);
		this.tempMaximaAtuacao = tempMaximaAtuacao;
		this.tempMinimaAtuacao = tempMinimaAtuacao;
	}

	@Override
	public Double definirTemperatura(Double temperaturaAtual) {
		Double temperatura;
		if(temperaturaAtual > this.tempMaximaAtuacao) {
			temperatura = temperaturaAtual - this.tempMaximaAtuacao;
			this.relatar(temperatura, "RESFRIAR");
			return -temperatura;
		}
		if(temperaturaAtual < this.tempMinimaAtuacao) {
			temperatura =  this.tempMinimaAtuacao - temperaturaAtual;
			this.relatar(temperatura, "AQUECER");
			System.err.println("\t>>AQUECER: " + temperatura + "°C<<");
			return temperatura;
		}		
		return 0.0;
	}



}
