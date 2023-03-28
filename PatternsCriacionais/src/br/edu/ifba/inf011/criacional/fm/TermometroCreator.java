package br.edu.ifba.inf011.criacional.fm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Termometro;

public class TermometroCreator {
	
	
	private String loadConf(String nome) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("C:\\Users\\fredericojorge\\Documents\\GitHub\\WKS2023.1\\PatternsCriacionais\\src\\br\\edu\\ifba\\inf011\\factory.conf"));
		for(Object key : prop.keySet())
			if(nome.equals(key))
				return (String) prop.get(key);
		return null;
	}
	
	
	public Termometro getTermometro(TipoTermometro tipo, Ambiente ambiente) {
		TermometroConcreteCreator creator = tipo.getConcreteCreator();
		Termometro termometro = creator.getTermometro();
		termometro.setAmbiente(ambiente);
		return termometro;
	}
	
	public Termometro getTermometroWithName(TipoTermometro tipo, Ambiente ambiente) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		String className = tipo.getConcreteCreatorClassName();
		TermometroConcreteCreator creator =  (TermometroConcreteCreator) Class.forName(className).getConstructor().newInstance();
		Termometro termometro = creator.getTermometro();
		termometro.setAmbiente(ambiente);
		return termometro;
	}
	
	public Termometro getTermometroWithProp(String nomeTermometro, Ambiente ambiente) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException, IOException {
		this.loadConf(nomeTermometro);
		String className = this.loadConf(nomeTermometro);
		TermometroConcreteCreator creator =  (TermometroConcreteCreator) Class.forName(className).getConstructor().newInstance();
		Termometro termometro = creator.getTermometro();
		termometro.setAmbiente(ambiente);
		return termometro;
	}	
	

}
