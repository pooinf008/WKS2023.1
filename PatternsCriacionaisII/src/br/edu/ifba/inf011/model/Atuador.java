package br.edu.ifba.inf011.model;

import java.io.PrintStream;

public interface Atuador {
	public Double definirTemperatura(Double temperaturaAtual);
	public void setSaidaAlarme(PrintStream saidaAlarme, Integer tabs);
}
