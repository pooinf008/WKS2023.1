package br.edu.ifba.inf011.model.termometros;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Termometro;

public class TermometroFaixa extends GenericTermometro implements Termometro{
	
	private Double tempMaxima;
	private Double tempMinima;
	
	public TermometroFaixa(Ambiente ambiente, Double tempMaxima, Double tempMinima, PrintStream saida, PrintStream alarme, Integer tabsAlarme) {
		super(ambiente, saida, alarme, tabsAlarme);
		this.tempMaxima = tempMaxima;
		this.tempMinima = tempMinima;
	}
	
	public TermometroFaixa(Ambiente ambiente, Double tempMaxima, Double tempMinima) {
		super(ambiente);
		this.tempMaxima = tempMaxima;
		this.tempMinima = tempMinima;
	}	
	

	@Override
	public double lerTemperatura() {
		Double temperatura = this.ambiente.getTemperatura();
		if(temperatura > this.tempMaxima) {
			this.alarmar(temperatura, "ALTA");
			return temperatura;
		}
		if(temperatura < this.tempMinima) {
			this.alarmar(temperatura, "BAIXA");
			return temperatura;
		}
		this.relatar(temperatura);
		return temperatura;		
	}	

	public Double getTempMaxima() {
		return tempMaxima;
	}

	public void setTempMaxima(Double tempMaxima) {
		this.tempMaxima = tempMaxima;
	}
	
	public Double getTempMinima() {
		return this.tempMinima;
	}

	public void setTempMinima(double tempMinima) {
		this.tempMinima = tempMinima;
	}
	

}
