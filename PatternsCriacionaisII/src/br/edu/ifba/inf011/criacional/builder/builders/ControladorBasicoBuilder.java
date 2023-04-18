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
	private List<TermometroAlta> termometros;
	private Resfriador atuador;
	private PrintStream saidaRelato;
	private PrintStream saidaAlarme;
	private Integer tabAlarme;
	private Ambiente ambiente;
	
	
	public ControladorBasicoBuilder() {
		this.termometros = new ArrayList<TermometroAlta>();
	}
	
	@Override
	public void setTemperaturaMaxima(Double tempMaxima) {
		this.tempMaxima = tempMaxima;
	}

	@Override
	public void adicionaTermometroAlta() {
		this.termometros.add(new TermometroAlta());
	}

	@Override
	public void adicionaResfriador() {
		this.atuador = new Resfriador();
		
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
		for(TermometroAlta termometro : this.termometros) {
			termometro.setAmbiente(ambiente);
			termometro.setSaidaPadrao(this.saidaRelato);
			termometro.setSaidaAlarme(this.saidaAlarme, this.tabAlarme);
			termometro.setTempMaxima(this.tempMaxima);
		}
		Resfriador resfriador = atuador;
		resfriador.setSaidaAlarme(this.saidaAlarme, this.tabAlarme);
		resfriador.setTempAtuacao(this.tempMaxima);
		
		Controlador controlador = new ControladorBasico(this.ambiente, 
														this.termometros, 
														this.atuador);
		return controlador;
			
	}
	
}
