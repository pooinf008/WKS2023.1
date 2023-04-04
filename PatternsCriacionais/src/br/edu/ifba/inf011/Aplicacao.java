package br.edu.ifba.inf011;

import br.edu.ifba.inf011.criacional.fm.TermometroFactory;
import br.edu.ifba.inf011.criacional.fm.TermometroBaseFactory;
import br.edu.ifba.inf011.model.AmbienteBasico;

public class Aplicacao {
	
	private Ambiente ambiente;
	private Termometro termometro;
	
	public Aplicacao(int valor, TermometroFactory factory) {
		this.ambiente = new AmbienteBasico("AMB01");
		this.termometro = factory.getTermometro(this.ambiente, valor);
	}
	
	public void monitorar() throws InterruptedException {
		
		while(true) {
			this.ambiente.randomizar(2);
			this.termometro.lerTemperatura();
			
			Thread.sleep(100);
		}		
	}
}
