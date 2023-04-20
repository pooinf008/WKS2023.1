package br.edu.ifba.inf011.criacional.builder.builders;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.inf011.criacional.builder.ControladorBuilder;
import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;
import br.edu.ifba.inf011.model.Termometro;

public class EspecificacaoBuilder implements ControladorBuilder{

	private Double tempMaxima;
	private Map<String, Integer> termometros;
	private String atuador;
	private String saidaRelato;
	private String saidaAlarme;
	private Integer qtdeTabsAlarme;
	private String ambiente;
	
	@Override
	public void adicionaTermometro(Termometro termometro) {
		Integer qtdeTermometros = this.termometros.get("TERMOMETRO_ALTA");
		if(qtdeTermometros == null)
			qtdeTermometros = 0;
		qtdeTermometros += 1;
		this.termometros.put("TERMOMETRO_ALTA", qtdeTermometros);
	}

	@Override
	public void adicionaAtuador(Atuador atuador) {
		this.atuador = "Resfriador";
	}

	@Override
	public void setSaidaRelato(PrintStream out) {
		this.saidaRelato = out.toString();
	}

	@Override
	public void setSaidaAlarme(PrintStream err, Integer i) {
		this.saidaAlarme = err.toString();	
		this.qtdeTabsAlarme = i;
	}

	@Override
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente.getId();
	}
	
	public String getEspecificacao() {
		String especificacao = "ControladorAlta{\n";
		especificacao += "\t Temperatura de Atuação : " + this.tempMaxima + "\n";
		especificacao += "\t Termometros : \n";
		especificacao += "\t\t " + this.getTermometros()  + "\n";
		especificacao += "\t Tipo de Atuador : " + this.atuador + "\n";
		especificacao += "\t Saída de Notificacões : " + this.saidaRelato + "\n";		
		especificacao += "\t Saída de Alarme : " + this.saidaAlarme + " tabs (" + this.qtdeTabsAlarme + ")\n";
		especificacao += "\t Ambiente de Atuação : " + this.ambiente + "\n";
		return especificacao + "}\n";
	}
	
	private String getTermometros() {
		String termometros = "";
		for(String key : this.termometros.keySet())
			termometros = termometros + key + this.termometros.get(key);
		return termometros;
	}
	

}
