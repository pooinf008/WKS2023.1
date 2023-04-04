package br.edu.ifba.inf011.model.termometros;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Termometro;

public class TermometroFaixa implements Termometro{
	
	private Ambiente ambiente;
	private double tempMaxima;
	private double tempMinima;
	
	public TermometroFaixa() {
		this.tempMaxima = 29;
		this.tempMinima = 26;
	}
	
	public TermometroFaixa(Ambiente ambiente, double tempMaxima, double tempMinima) {
		this.ambiente = ambiente;
		this.tempMaxima = tempMaxima;
		this.tempMinima = tempMinima;
	}
	
	
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}	
		
	
	public double lerTemperatura() {
		double temperatura = this.ambiente.getTemperatura();
		if(temperatura > this.tempMaxima) {
			System.err.println(String.format("<<ALARME ALTA: %.2fC>>", temperatura));
			return temperatura;
		}
		if(temperatura < this.tempMinima) {
			System.err.println(String.format("<<ALARME BAIXA: %.2fC>>", temperatura));
			return temperatura;
		}
		System.out.println(String.format("%.2fC", temperatura));
		return temperatura;		
	}

	public double getTempMaxima() {
		return tempMaxima;
	}

	public void setTempMaxima(double tempMaxima) {
		this.tempMaxima = tempMaxima;
	}
	
	

}
