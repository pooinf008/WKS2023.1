package br.edu.ifba.inf011.decorator;

import java.io.IOException;
import java.util.List;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class MusicaTraducaoPT extends MusicaDecorator implements Musica {
	
	private List<String> letras;
	private Integer linha;
	
	public MusicaTraducaoPT(Musica musica) throws IOException {
		super(musica);
		this.letras = ResourceLoader.instance().loadResource(musica.getNome(), "pt");
	}	

	@Override
	public void reset() {
		super.reset();
		this.linha = 0;
	}

	@Override
	public String play() {
		return super.play() + "\n" + this.letras.get(this.linha++);
	}	

}
