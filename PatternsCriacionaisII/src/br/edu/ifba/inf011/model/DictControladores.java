package br.edu.ifba.inf011.model;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.inf011.criacional.builder.IControladorConstrutor;
import br.edu.ifba.inf011.criacional.builder2.ControladorConstrutor;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.atuadores.Resfriador;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.model.termometros.TermometroFaixa;

public class DictControladores {
	
	private Map<String, Controlador> controladores;
	private Ambiente ambiente;
	
	private static DictControladores dicionario = null;
	
	
	public static DictControladores instance(Ambiente ambiente) {
		if(DictControladores.dicionario == null)
			dicionario = new DictControladores(ambiente);
		return dicionario; 
	}
	
	private DictControladores(Ambiente ambiente) {
		this.controladores = new HashMap<String, Controlador>();
		this.ambiente = ambiente;
		this.init();
	}
	
	public void init() {
		IControladorConstrutor b = ControladorConstrutor.builder();
		
		this.registrar("ALTA", b.reset()
			       				.adicionaTermometro(new TermometroAlta(this.ambiente, 28.0))
			       				.adicionaTermometro(new TermometroAlta(this.ambiente, 28.0))
			       				.adicionaTermometro(new TermometroAlta(this.ambiente, 28.0))
			       				.getControlador(this.ambiente));
		
		this.registrar("FAIXA", b.reset()
   				.adicionaTermometro(new TermometroFaixa(this.ambiente, 26.0, 28.0))
   				.adicionaAtuador(new Estabilizador(this.ambiente, 26.0, 28.0))
   				.getControlador(this.ambiente));		
		
		this.registrar("FAIXA-ALTA", b.reset()
   				.adicionaTermometro(new TermometroFaixa(this.ambiente, 26.0, 28.0))
   				.adicionaTermometro(new TermometroAlta(this.ambiente, 30.0))
   				.adicionaAtuador(new Estabilizador(this.ambiente, 26.0, 28.0))
   				.getControlador(this.ambiente));		
		
		
	}
	
	public void registrar(String apelido, Controlador controlador) {
		this.controladores.put(apelido, controlador);
	}
	
	public Controlador get(String apelido) {
		return (Controlador) this.controladores.get(apelido).prototipar();
	}
	
	

}
