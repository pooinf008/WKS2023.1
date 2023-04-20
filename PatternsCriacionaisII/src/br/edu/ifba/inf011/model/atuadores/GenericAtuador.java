package br.edu.ifba.inf011.model.atuadores;

import java.io.PrintStream;
import br.edu.ifba.inf011.model.Ambiente;

public class GenericAtuador {
	
	protected PrintStream saidaAtuacao;
	protected Integer tabsAtuacao;
	
	public GenericAtuador(GenericAtuador atuador) {
		this(null, atuador.saidaAtuacao, atuador.tabsAtuacao);
	}
	
	public GenericAtuador(Ambiente ambiente, PrintStream saidaAtuacao, Integer tabsAtuacao) {
		super();
		this.saidaAtuacao = saidaAtuacao;
		this.tabsAtuacao = tabsAtuacao;
	}
	
	public GenericAtuador(Ambiente ambiente) {
		super();
	}
	

	public GenericAtuador() {
	}
	
	public void relatar(Double temperatura) {
		this.saidaAtuacao.println(this.getMensagemAtuacao(temperatura));
	}
	
	public void relatar(Double temperatura, String tipo) {
		this.saidaAtuacao.println(this.getMensagemAtuacao(temperatura, tipo));
	}
	
	
	public String getMensagemAtuacao(Double temperatura) {
		String tabs = "";
		for(int iCont = 0; iCont < tabsAtuacao; iCont++)
			tabs = tabs + "\t";
		return String.format("%s>>ATUA��O: %.2f�C<<", tabs, temperatura);
	}
	
	public String getMensagemAtuacao(Double temperatura, String tipo) {
		String tabs = "";
		for(int iCont = 0; iCont < tabsAtuacao; iCont++)
			tabs = tabs + "\t";
		return String.format("%s>>ATUA��O (%s): %.2f�C<<", tabs, tipo, temperatura);
	}		
	
	public void setSaidaAlarme(PrintStream saidaAtuacao, Integer tabsAtuacao) {
		this.saidaAtuacao = saidaAtuacao;
		this.tabsAtuacao = tabsAtuacao;
	}
	

}
