package br.edu.ifba.inf011.criacional.builder;

import br.edu.ifba.inf011.model.Ambiente;

public class ControladorDirector {
	
	private ControladorBuilder builder;
	
	public ControladorDirector(ControladorBuilder builder) {
		this.builder = builder;
	}
	
	public void setBuilder(ControladorBuilder builder) {
		this.builder = builder;
		
	}
	
	public void makeControladorAlta(Ambiente ambiente, int qtdeTermometros) {
		
		this.builder.setTemperaturaMaxima(28.0);
		for(int iCount = 0; 
			iCount < qtdeTermometros;
				iCount++)
		  this.builder.adicionaTermometroAlta();
		this.builder.adicionaResfriador();
		this.builder.setSaidaRelato(System.out);
		this.builder.setSaidaAlarme(System.err, 1);
		this.builder.setAmbiente(ambiente);
		
		
	}
	

}
