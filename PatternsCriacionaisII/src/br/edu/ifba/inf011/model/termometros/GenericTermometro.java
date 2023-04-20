package br.edu.ifba.inf011.model.termometros;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Termometro;

public abstract class GenericTermometro implements Termometro{
	
	protected Ambiente ambiente;
	protected PrintStream saida;
	protected PrintStream alarme;
	protected Integer tabsAlarme;
	
	
	public GenericTermometro(GenericTermometro termometro) {
		this((Ambiente)termometro.ambiente.prototipar(), termometro.saida,
			  termometro.saida, termometro.tabsAlarme);
	}
	
	public GenericTermometro(Ambiente ambiente, PrintStream saida, PrintStream alarme, Integer tabsAlarme) {
		super();
		this.ambiente = ambiente;
		this.saida = saida;
		this.alarme = alarme;
		this.tabsAlarme = tabsAlarme;
	}
	
	public GenericTermometro(Ambiente ambiente) {
		super();
		this.ambiente = ambiente;
	}
	

	public GenericTermometro() {
	}
	
	@Override
	public void setSaidaPadrao(PrintStream saidaPadrao) {
		this.saida = saidaPadrao;
	}

	@Override
	public void setSaidaAlarme(PrintStream saidaAlarme, Integer tabs) {
		this.alarme = saidaAlarme;
		this.tabsAlarme = tabs;
	}	
	
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}	
	
	public String getMensagemPadrao(Double temperatura) {
		return String.format("%.2f°C", temperatura);
	}
	
	public String getMensagemAlarme(Double temperatura) {
		String tabs = "";
		for(int iCont = 0; iCont < tabsAlarme; iCont++)
			tabs = tabs + "\t";
		return String.format("%s<<ALARME: %.2f°C>>", tabs, temperatura);
	}
	
	public String getMensagemAlarme(Double temperatura, String tipo) {
		String tabs = "";
		for(int iCont = 0; iCont < tabsAlarme; iCont++)
			tabs = tabs + "\t";
		return String.format("%s<<ALARME %s: %.2fºC>>", tabs, tipo, temperatura);
	}	
	
	public void relatar(Double temperatura) {
		if(this.saida != null)
			this.saida.println(this.getMensagemPadrao(temperatura));
	}
	
	public void alarmar(Double temperatura) {
		if(this.saida != null)
			this.alarme.println(this.getMensagemAlarme(temperatura));
	}
	
	public void alarmar(Double temperatura, String tipo) {
		if(this.saida != null)
			this.alarme.println(this.getMensagemAlarme(temperatura, tipo));
	}	

	


}
