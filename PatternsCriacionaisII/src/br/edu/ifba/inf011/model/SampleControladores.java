package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.criacional.builder.IControladorConstrutor;
import br.edu.ifba.inf011.criacional.builder2.ControladorConstrutor;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.atuadores.Resfriador;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.model.termometros.TermometroFaixa;

public class SampleControladores {
	
	private static Integer index;
	
	private static List<Controlador> dicionario = null;
	
	
	public static Controlador instance(Ambiente ambiente) {
		
		
		if(SampleControladores.dicionario == null) {
			SampleControladores.dicionario = new ArrayList<Controlador>();
			init(ambiente);
			SampleControladores.index = 0;
		}	
		SampleControladores.index++;
		SampleControladores.index %= 3;
		return SampleControladores.dicionario.get(SampleControladores.index); 
	}

	
	private static void init(Ambiente ambiente) {
		
		
		
		IControladorConstrutor b = ControladorConstrutor.builder();
		
		SampleControladores.registrar(b.reset()
			       				.adicionaTermometro(new TermometroAlta(ambiente, 28.0))
			       				.adicionaTermometro(new TermometroAlta(ambiente, 28.0))
			       				.adicionaTermometro(new TermometroAlta(ambiente, 28.0))
			       				.getControlador(ambiente));
		
		SampleControladores.registrar(b.reset()
   				.adicionaTermometro(new TermometroFaixa(ambiente, 26.0, 28.0))
   				.adicionaAtuador(new Estabilizador(ambiente, 26.0, 28.0))
   				.getControlador(ambiente));		
		
		SampleControladores.registrar(b.reset()
   				.adicionaTermometro(new TermometroFaixa(ambiente, 26.0, 28.0))
   				.adicionaTermometro(new TermometroAlta(ambiente, 30.0))
   				.adicionaAtuador(new Estabilizador(ambiente, 26.0, 28.0))
   				.getControlador(ambiente));		
		
		
	}
	
	private static void registrar(Controlador controlador) {
		SampleControladores.dicionario.add(controlador);
	}

	
	

}
