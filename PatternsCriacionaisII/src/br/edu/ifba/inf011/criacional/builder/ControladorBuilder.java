package br.edu.ifba.inf011.criacional.builder;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;

public interface ControladorBuilder {

	public void setTemperaturaMaxima(Double d);
	public void adicionaTermometroAlta();
	public void adicionaResfriador();
	public void setSaidaRelato(PrintStream out);
	public void setSaidaAlarme(PrintStream err, Integer i);
	public void setAmbiente(Ambiente ambiente);
	

}
