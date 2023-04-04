package br.edu.ifba.inf011.criacional.fm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import br.edu.ifba.inf011.Ambiente;
import br.edu.ifba.inf011.Atuador;
import br.edu.ifba.inf011.Termometro;

public class AtuadorCreator {
	
	
	private String loadConf(String nome) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("C:\\Users\\fredericojorge\\Documents\\GitHub\\WKS2023.1\\PatternsCriacionais\\src\\br\\edu\\ifba\\inf011\\atuador.conf"));
		for(Object key : prop.keySet())
			if(nome.equals(key))
				return (String) prop.get(key);
		return null;
	}
	
	public Atuador getAtuadorWithProp(String nomeAtuador) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException, IOException {
		this.loadConf(nomeAtuador);
		String className = this.loadConf(nomeAtuador);
		AtuadorConcreteCreator creator =  (AtuadorConcreteCreator) Class.forName(className).getConstructor().newInstance();
		Atuador atuador = creator.getAtuador();
		return atuador;
	}	
	

}
