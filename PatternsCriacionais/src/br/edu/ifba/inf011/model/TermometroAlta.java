package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Termometro;

public class TermometroAlta implements Termometro{
	
	private Ambiente ambiente;
	private double tempMaxima;
	
	public TermometroAlta(Ambiente ambiente, double tempMaxima) {
		this.ambiente = ambiente;
		this.tempMaxima = tempMaxima;
	}
	
	public void lerTemperatura() {
		double temperatura = this.ambiente.getTemperatura();
		if(temperatura > this.tempMaxima) {
			System.err.println(String.format("<<ALARME: %.2fC>>", temperatura));
			return;
		}	
		System.out.println(String.format("%.2fC", temperatura));
	}

	public double getTempMaxima() {
		return tempMaxima;
	}

	public void setTempMaxima(double tempMaxima) {
		this.tempMaxima = tempMaxima;
	}
	
	

}
