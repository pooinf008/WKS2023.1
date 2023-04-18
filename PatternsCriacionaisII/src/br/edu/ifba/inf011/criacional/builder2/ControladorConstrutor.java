package br.edu.ifba.inf011.criacional.builder2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.criacional.builder.ControladorBuilder;
import br.edu.ifba.inf011.criacional.builder.IControladorConstrutor;
import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Controlador;
import br.edu.ifba.inf011.model.atuadores.Resfriador;
import br.edu.ifba.inf011.model.controladores.ControladorBasico;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;

public class ControladorConstrutor implements IControladorConstrutor{
	
	private Double tempMaxima;
	private List<TermometroAlta> termometros;
	private Resfriador atuador;
	private PrintStream saidaRelato;
	private PrintStream saidaAlarme;
	private Integer tabAlarme;
//	private Ambiente ambiente;
	
	
	public static IControladorConstrutor builder() {
		return new ControladorConstrutor();
	}
	
	public ControladorConstrutor() {
		this.termometros = new ArrayList<TermometroAlta>();
		this.reset();
	}
	
	@Override
	public IControladorConstrutor reset() {
		this.tempMaxima = 30.0;
		this.termometros = new ArrayList<TermometroAlta>();
		this.atuador = null;
		this.saidaRelato = System.out;
		this.saidaAlarme = System.out;
		this.tabAlarme = 3;
//		this.ambiente = null;
		return this;
	}	
	
	@Override
	public IControladorConstrutor setTemperaturaMaxima(Double tempMaxima) {
		this.tempMaxima = tempMaxima;
		return this;
	}

	@Override
	public IControladorConstrutor adicionaTermometroAlta() {
		this.termometros.add(new TermometroAlta());
		return this;
	}

	@Override
	public IControladorConstrutor adicionaResfriador() {
		this.atuador = new Resfriador();
		return this;
	}

	@Override
	public IControladorConstrutor setSaidaRelato(PrintStream saidaRelato) {
		this.saidaRelato = saidaRelato;
		return this;
	}

	@Override
	public IControladorConstrutor setSaidaAlarme(PrintStream saidaAlarme, Integer tabAlarme) {
		this.saidaAlarme = saidaAlarme;
		this.tabAlarme = tabAlarme;
		return this;
		
	}

//	@Override
//	public IControladorConstrutor setAmbiente(Ambiente ambiente) {
//		this.ambiente = ambiente;
//		return this;
//	}
	
	public Controlador getControlador(Ambiente ambiente) {
		if(this.termometros.size() == 0)
			this.termometros.add(new TermometroAlta());
		for(TermometroAlta termometro : this.termometros) {
			termometro.setAmbiente(ambiente);
			termometro.setSaidaPadrao(this.saidaRelato);
			termometro.setSaidaAlarme(this.saidaAlarme, this.tabAlarme);
			termometro.setTempMaxima(this.tempMaxima);
		}
		if(atuador == null)
			atuador = new Resfriador();
		
		atuador.setSaidaAlarme(this.saidaAlarme, this.tabAlarme);
		atuador.setTempAtuacao(this.tempMaxima);
		
		Controlador controlador = new ControladorBasico(ambiente, 
														this.termometros, 
														this.atuador);
		return controlador;
			
	}


}
