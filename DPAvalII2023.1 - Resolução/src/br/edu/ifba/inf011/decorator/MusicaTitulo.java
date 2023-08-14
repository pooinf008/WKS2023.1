package br.edu.ifba.inf011.decorator;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class MusicaTitulo extends MusicaDecorator implements Musica {
	
	public MusicaTitulo(Musica musica) throws IOException {
		super(musica);
	}	
	
	@Override
	public String execute() {
		return this.getNome() + "\n" + super.execute();	
	}	

}
