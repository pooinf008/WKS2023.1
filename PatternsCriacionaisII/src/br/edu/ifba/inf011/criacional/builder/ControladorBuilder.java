package br.edu.ifba.inf011.criacional.builder;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.model.atuadores.Resfriador;

public interface ControladorBuilder {

	public void adicionaTermometro(Termometro termometro);
	public void adicionaAtuador(Atuador atuador);
	public void setSaidaRelato(PrintStream out);
	public void setSaidaAlarme(PrintStream err, Integer i);
	public void setAmbiente(Ambiente ambiente);
	

}
