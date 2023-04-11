package br.edu.ifba.inf011.criacional.afv2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Atuador;
import br.edu.ifba.inf011.Termometro;
import br.edu.ifba.inf011.criacional.fm.AtuadorCreator;
import br.edu.ifba.inf011.criacional.fm.TermometroCreator;

public abstract class AbstractKitTermometroAtuador implements KitTermometroAtuador{

	private AtuadorCreator atuadorFactory;
	private TermometroCreator termometroFactory;
	private Ambiente ambiente;
	
	public AbstractKitTermometroAtuador(Ambiente ambiente) {
		this.atuadorFactory = new AtuadorCreator();
		this.termometroFactory = new TermometroCreator();
		this.ambiente = ambiente;
	}
	
	public Termometro getTermometro(String chave) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException, IOException {
		return this.termometroFactory.getTermometroWithProp(chave, this.ambiente);
	}

	public Atuador getAtuador(String chave) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException, IOException {
		return this.atuadorFactory.getAtuadorWithProp(chave);
	}

}
