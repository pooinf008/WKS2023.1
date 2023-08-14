package br.edu.ifba.inf011.decorator;

import java.io.IOException;

import br.edu.ifba.inf011.model.Musica;

public class MusicaTituloOnly extends MusicaDecorator implements Musica {
	
	public MusicaTituloOnly(Musica musica) throws IOException {
		super(musica);
	}	
	
	@Override
	public String execute() {
		return this.getNome();	
	}	

}

