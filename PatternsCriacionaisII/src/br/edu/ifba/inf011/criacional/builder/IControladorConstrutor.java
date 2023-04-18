package br.edu.ifba.inf011.criacional.builder;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Controlador;

public interface IControladorConstrutor {

	public IControladorConstrutor reset();
	public IControladorConstrutor setTemperaturaMaxima(Double d);
	public IControladorConstrutor adicionaTermometroAlta();
	public IControladorConstrutor adicionaResfriador();
	public IControladorConstrutor setSaidaRelato(PrintStream out);
	public IControladorConstrutor setSaidaAlarme(PrintStream err, Integer i);
//	public IControladorConstrutor setAmbiente(Ambiente ambiente);
	public Controlador getControlador(Ambiente ambiente);
	

}
