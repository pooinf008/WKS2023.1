package br.edu.ifba.inf011.model.atuadores;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;

public class Resfriador extends GenericAtuador implements Atuador{

	private Double tempMaximaAtuacao; 
	
	public Resfriador() {
		
	}
	
	public Resfriador(Ambiente ambiente, Double tempMaximaAtuacao) {
		super(ambiente);
		this.tempMaximaAtuacao = tempMaximaAtuacao;
	}
	
	public Resfriador(Ambiente ambiente, Double tempMaximaAtuacao,  PrintStream saidaAtuacao, Integer tabsAtuacao) {
		super(ambiente, saidaAtuacao, tabsAtuacao);
		this.tempMaximaAtuacao = tempMaximaAtuacao;
	}	
	
	@Override
	public Double definirTemperatura(Double temperaturaAtual) {
		double temperatura = temperaturaAtual - this.tempMaximaAtuacao;
		if(temperaturaAtual > this.tempMaximaAtuacao) {
			this.relatar(temperatura);
			return -temperatura;
		}	
		return 0.0;
	}

	public Double getTempAtuacao() {
		return tempMaximaAtuacao;
	}

	public void setTempAtuacao(Double tempMaximaAtuacao) {
		this.tempMaximaAtuacao = tempMaximaAtuacao;
	}
	
	

}
