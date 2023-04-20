package br.edu.ifba.inf011.model.termometros;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.prototype.Prototipo;

public class TermometroComTrava extends GenericTermometro implements Termometro{
	
	private double tempMaxima;
	private boolean trava;
	
	public TermometroComTrava(TermometroComTrava termometroComTrava) {
		this((Ambiente)termometroComTrava.ambiente.prototipar(), termometroComTrava.tempMaxima,
				termometroComTrava.saida, termometroComTrava.alarme, termometroComTrava.tabsAlarme);
		this.trava = termometroComTrava.trava;
	}		
		
	public TermometroComTrava(Ambiente ambiente, Double tempMaxima, PrintStream saida, PrintStream alarme, Integer tabsAlarme) {
		super(ambiente, saida, alarme, tabsAlarme);
		this.tempMaxima = tempMaxima;
		this.trava = false;		
	}
	
	public TermometroComTrava(Ambiente ambiente, Double tempMaxima) {
		super(ambiente);
		this.tempMaxima = tempMaxima;
		this.trava = false;
	}	
	
	@Override
	public double lerTemperatura() {
		Double temperatura = this.ambiente.getTemperatura();
		if(temperatura > this.tempMaxima || this.trava) {
			this.alarmar(temperatura);
			this.trava = true;
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
	
	public void reiniciar() {
		this.trava = false;
	}

	@Override
	public Prototipo prototipar() {
		return new TermometroComTrava(this);
	}
		




}
