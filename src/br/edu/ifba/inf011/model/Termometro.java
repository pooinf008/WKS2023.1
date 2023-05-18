package br.edu.ifba.inf011.model;

import java.io.PrintStream;

public interface Termometro{
	public double lerTemperatura();
	public void setAmbiente(Ambiente ambiente);
	public void setSaidaPadrao(PrintStream saidaPadrao);
	public void setSaidaAlarme(PrintStream saidaAlarme, Integer tabs);
};
