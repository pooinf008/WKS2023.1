package br.edu.ifba.inf011;

import br.edu.ifba.inf011.criacional.fm.TermometroFactory;
import br.edu.ifba.inf011.criacional.fm.TipoTermometro;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.edu.ifba.inf011.criacional.af.KitTermometroAtuador;
import br.edu.ifba.inf011.criacional.fm.AtuadorCreator;
import br.edu.ifba.inf011.criacional.fm.TermometroBaseFactory;
import br.edu.ifba.inf011.criacional.fm.TermometroCreator;
import br.edu.ifba.inf011.model.AmbienteBasico;
import br.edu.ifba.inf011.model.atuadores.AtuadorDummy;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.atuadores.Resfriador;

public class Aplicacao3 {
	
	private Ambiente ambiente;
	private Termometro termometro;
	private Atuador atuador;
	
	public Aplicacao3(KitTermometroAtuador kit) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException, IOException {
		this.ambiente = new AmbienteBasico("AMB01");
		this.termometro = kit.getTermometro();
		this.atuador = kit.getAtuador();
		this.termometro.setAmbiente(ambiente);
		
	}
	
	public void monitorar() throws InterruptedException {
		
		while(true) {
			double temperatura;
			this.ambiente.randomizar(2);
			temperatura = this.termometro.lerTemperatura();
			this.ambiente.setTemperaturaAtuacao(this.atuador.definirTemperatura(temperatura));
			Thread.sleep(100);
		}		
	}
}
