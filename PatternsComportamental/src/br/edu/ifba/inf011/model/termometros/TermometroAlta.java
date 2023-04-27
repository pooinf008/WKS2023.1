package br.edu.ifba.inf011.model.termometros;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Termometro;
import java.util.Random;

public class TermometroAlta extends GenericTermometro implements Termometro{
	
	private Double tempMaxima;


	public TermometroAlta() {
		
	}
	
	public TermometroAlta(Ambiente ambiente, Double tempMaxima, PrintStream saida, PrintStream alarme, Integer tabsAlarme) {
		super(ambiente, saida, alarme, tabsAlarme);
		this.tempMaxima = tempMaxima;
	}
	
	public TermometroAlta(Ambiente ambiente, Double tempMaxima) {
		super(ambiente);
		this.tempMaxima = tempMaxima;
	}	
	
	public double lerTemperatura() {
		Random random = new Random();
		Double erro = random.nextDouble(-2, 2);
		Double temperatura = this.ambiente.getTemperatura();
		temperatura += erro;
		if(temperatura > this.tempMaxima) {
			this.alarmar(temperatura);
			return temperatura;
		}
		this.relatar(temperatura);
		return temperatura;		
	}

	public double getTempMaxima() {
		return tempMaxima;
	}

	public void setTempMaxima(double tempMaxima) {
		this.tempMaxima = tempMaxima;
	}


}
