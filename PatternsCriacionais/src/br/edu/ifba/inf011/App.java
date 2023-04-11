package br.edu.ifba.inf011;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import br.edu.ifba.inf011.criacional.af.KitAlta;
import br.edu.ifba.inf011.criacional.af.KitFaixa;
import br.edu.ifba.inf011.criacional.fm.TermometroBaseFactory;
import br.edu.ifba.inf011.criacional.fm.TermometroLockFactory;
import br.edu.ifba.inf011.criacional.fm.TipoTermometro;

public class App {
	
	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, FileNotFoundException, IOException {
		(new Aplicacao4()).monitorar();
	}

}
