package br.edu.ifba.inf011.criacional.builder;

import java.io.PrintStream;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;
import br.edu.ifba.inf011.model.Controlador;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.model.atuadores.Resfriador;

public interface IControladorConstrutor {

	public IControladorConstrutor reset();
	public IControladorConstrutor adicionaTermometro(Termometro termometro);
	public IControladorConstrutor adicionaAtuador(Atuador atuador);
	public IControladorConstrutor setSaidaRelato(PrintStream out);
	public IControladorConstrutor setSaidaAlarme(PrintStream err, Integer i);
	public Controlador getControlador(Ambiente ambiente);
	

}
