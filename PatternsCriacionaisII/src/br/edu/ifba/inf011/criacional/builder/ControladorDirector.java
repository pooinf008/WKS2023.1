package br.edu.ifba.inf011.criacional.builder;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.atuadores.Resfriador;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;

public class ControladorDirector {
	
	private ControladorBuilder builder;
	
	public ControladorDirector(ControladorBuilder builder) {
		this.builder = builder;
	}
	
	public void setBuilder(ControladorBuilder builder) {
		this.builder = builder;
		
	}
	
	public void makeControladorAlta(Ambiente ambiente, int qtdeTermometros) {
		
		for(int iCount = 0; 
			iCount < qtdeTermometros;
				iCount++)
		  this.builder.adicionaTermometro(new TermometroAlta(ambiente, 28.0));
		this.builder.adicionaAtuador(new Resfriador(ambiente, 28.0));
		this.builder.setSaidaRelato(System.out);
		this.builder.setSaidaAlarme(System.err, 1);
		this.builder.setAmbiente(ambiente);
		
		
	}
	

}
