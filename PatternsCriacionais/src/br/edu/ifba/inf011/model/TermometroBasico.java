package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Termometro;

public class TermometroBasico implements Termometro{
	


	private Ambiente ambiente;

	public TermometroBasico() {
	}
	
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}	
	
	public TermometroBasico(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public void lerTemperatura() {
		double temperatura = this.ambiente.getTemperatura();
		System.out.println(String.format("%.2fC", temperatura));
	}

}
