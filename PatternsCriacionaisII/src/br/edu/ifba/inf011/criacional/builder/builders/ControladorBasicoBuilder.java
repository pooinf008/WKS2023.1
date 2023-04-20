package br.edu.ifba.inf011.criacional.builder.builders;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.criacional.builder.ControladorBuilder;
import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;
import br.edu.ifba.inf011.model.Controlador;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.model.atuadores.Resfriador;
import br.edu.ifba.inf011.model.controladores.ControladorBasico;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;

public class ControladorBasicoBuilder implements ControladorBuilder{

	private Double tempMaxima;
	private List<Termometro> termometros;
	private Atuador atuador;
	private PrintStream saidaRelato;
	private PrintStream saidaAlarme;
	private Integer tabAlarme;
	private Ambiente ambiente;
	
	
	public ControladorBasicoBuilder() {
		this.termometros = new ArrayList<Termometro>();
	}
	
	@Override
	public void adicionaTermometro(Termometro termometro) {
		this.termometros.add(termometro);
	}

	@Override
	public void adicionaAtuador(Atuador atuador) {
		this.atuador = atuador;
		
	}

	@Override
	public void setSaidaRelato(PrintStream saidaRelato) {
		this.saidaRelato = saidaRelato;
	}

	@Override
	public void setSaidaAlarme(PrintStream saidaAlarme, Integer tabAlarme) {
		this.saidaAlarme = saidaAlarme;
		this.tabAlarme = tabAlarme;
		
	}

	@Override
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public Controlador getControlador() {
		for(Termometro termometro : this.termometros) {
			termometro.setAmbiente(ambiente);
			termometro.setSaidaPadrao(this.saidaRelato);
			termometro.setSaidaAlarme(this.saidaAlarme, this.tabAlarme);
		}
		atuador.setSaidaAlarme(this.saidaAlarme, this.tabAlarme);
		
		Controlador controlador = new ControladorBasico(this.ambiente, 
														this.termometros, 
														this.atuador);
		return controlador;
			
	}
	
}
