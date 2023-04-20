package br.edu.ifba.inf011.model;

import java.io.PrintStream;

import br.edu.ifba.inf011.prototype.Prototipo;

public interface Atuador extends Prototipo{
	public Double definirTemperatura(Double temperaturaAtual);
	public void setSaidaAlarme(PrintStream saidaAlarme, Integer tabs);
}
