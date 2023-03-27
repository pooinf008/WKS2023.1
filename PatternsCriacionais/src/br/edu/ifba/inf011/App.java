package br.edu.ifba.inf011;

import br.edu.ifba.inf011.criacional.fm.TermometroBaseFactory;
import br.edu.ifba.inf011.criacional.fm.TermometroLockFactory;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		(new Aplicacao(0, new TermometroLockFactory())).monitorar();
	}

}
