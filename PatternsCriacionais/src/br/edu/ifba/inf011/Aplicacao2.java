package br.edu.ifba.inf011;

import br.edu.ifba.inf011.criacional.fm.TermometroFactory;
import br.edu.ifba.inf011.criacional.fm.TipoTermometro;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.edu.ifba.inf011.criacional.fm.TermometroBaseFactory;
import br.edu.ifba.inf011.criacional.fm.TermometroCreator;
import br.edu.ifba.inf011.model.AmbienteBasico;

public class Aplicacao2 {
	
	private Ambiente ambiente;
	private Termometro termometro;
	
	public Aplicacao2(TipoTermometro tipo) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException, IOException {
		
		TermometroCreator factory = new TermometroCreator();
		
		this.ambiente = new AmbienteBasico("AMB01");
		this.termometro = factory.getTermometroWithProp("TRAVA", this.ambiente);
	}
	
	public void monitorar() throws InterruptedException {
		
		while(true) {
			this.ambiente.randomizar(2);
			this.termometro.lerTemperatura();
			Thread.sleep(100);
		}		
	}
}
