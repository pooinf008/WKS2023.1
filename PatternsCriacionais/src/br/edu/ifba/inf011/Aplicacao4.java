package br.edu.ifba.inf011;

import br.edu.ifba.inf011.criacional.fm.TermometroFactory;
import br.edu.ifba.inf011.criacional.fm.TipoTermometro;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.edu.ifba.inf011.criacional.afv2.KitAlta;
import br.edu.ifba.inf011.criacional.afv2.KitFaixa;
import br.edu.ifba.inf011.criacional.afv2.KitTermometroAtuador;
import br.edu.ifba.inf011.criacional.fm.AtuadorCreator;
import br.edu.ifba.inf011.criacional.fm.TermometroBaseFactory;
import br.edu.ifba.inf011.criacional.fm.TermometroCreator;
import br.edu.ifba.inf011.model.AmbienteBasico;
import br.edu.ifba.inf011.model.atuadores.AtuadorDummy;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.atuadores.Resfriador;

public class Aplicacao4 {
	
	private Termometro termometro;
	private Atuador atuador;
	private KitTermometroAtuador kit;
	private Ambiente ambiente;

	public Aplicacao4() {
		this.ambiente = new AmbienteBasico("AMB01");
		this.kit = new KitFaixa(this.ambiente);
		this.termometro = this.kit.getTermometro();
		this.atuador = this.kit.getAtuador();
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
