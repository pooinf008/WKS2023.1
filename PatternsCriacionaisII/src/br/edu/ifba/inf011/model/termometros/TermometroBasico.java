package br.edu.ifba.inf011.model.termometros;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.prototype.Prototipo;

public class TermometroBasico extends GenericTermometro implements Termometro{
	
	public TermometroBasico(TermometroBasico termometroBasico) {
		this((Ambiente)termometroBasico.ambiente.prototipar(),
				termometroBasico.saida, termometroBasico.alarme,
				termometroBasico.tabsAlarme);
	}		
	
	public TermometroBasico(Ambiente ambiente) {
		super(ambiente);
	}		

	public TermometroBasico(Ambiente ambiente, PrintStream saida, PrintStream alarme, Integer tabsAlarme) {
		super(ambiente, saida, alarme, tabsAlarme);
	}
	
	public TermometroBasico(Ambiente ambiente, PrintStream saida) {
		super(ambiente, saida, null, 0);
	}	
	
	public double lerTemperatura() {
		Double temperatura = this.ambiente.getTemperatura();
		this.relatar(temperatura);
		return temperatura;
	}

	@Override
	public Prototipo prototipar() {
		return new TermometroBasico(this);
	}

}
