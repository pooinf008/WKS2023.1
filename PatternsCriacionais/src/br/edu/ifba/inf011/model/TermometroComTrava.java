package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Termometro;

public class TermometroComTrava implements Termometro{
	
	private Ambiente ambiente;
	private double tempMaxima;
	private boolean trava;
		
	public TermometroComTrava() {
		this.tempMaxima = 28;
	}
	
	public TermometroComTrava(Ambiente ambiente, double tempMaxima) {
		this.ambiente = ambiente;
		this.tempMaxima = tempMaxima;
		this.trava = false;
	}
	
	
	
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}	
		
	
	public void reiniciar() {
		this.trava = false;
	}
		
	@Override
	public void lerTemperatura() {
		double temperatura = this.ambiente.getTemperatura();
		if(temperatura > this.tempMaxima || this.trava) {
			System.err.println(String.format("<<ALARME: %.2fC>>", temperatura));
			this.trava = true;
			return;
		}	
		System.out.println(String.format("%.2fC", temperatura));
		
	}



}
