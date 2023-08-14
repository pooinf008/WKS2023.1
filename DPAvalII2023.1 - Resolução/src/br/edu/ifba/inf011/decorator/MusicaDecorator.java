package br.edu.ifba.inf011.decorator;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.composite.Tocavel;
import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public abstract class MusicaDecorator implements Musica{
	
	private Musica musica;
	
	public MusicaDecorator(Musica musica) {
		this.musica = musica;
	}

	@Override
	public String getNome() {
		return this.musica.getNome();
	}

	@Override
	public void reset() {
		this.musica.reset();
	}

	@Override
	public Boolean finish() {
		return this.musica.finish();
	}

	@Override
	public String play() {
		return this.musica.play();
	}
	
	@Override
	public String execute() {
		StringBuffer str = new StringBuffer();
		this.reset();
		while(!this.finish())
			str.append(this.play() + "\n");
		return str.toString();	
	}
	
	@Override
	public String randomize() {
		return this.execute();
	}


}
