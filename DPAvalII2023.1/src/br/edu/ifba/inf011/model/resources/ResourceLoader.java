package br.edu.ifba.inf011.model.resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.MusicaNotas;

public class ResourceLoader {
	
	public static String DIR_NAME = "D:\\workspace\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
		
	
	public static ResourceLoader loader;
	
	public static ResourceLoader instance() {
		if(ResourceLoader.loader == null)
			ResourceLoader.loader = new ResourceLoader();
		return ResourceLoader.loader;
	}
	
	public MusicaNotas createMusica(String nome) throws IOException {
		MusicaNotas musica = new MusicaNotas(nome);
		musica.setAcordes(this.loadNotas(nome));
		return musica;
	}
	
	public List<String> loadNotas(String nome) throws IOException {
		return this.loadResource(nome, "notas");
	}
	
	public List<String> loadLetra(String nome) throws IOException {
		return this.loadResource(nome, "letra");
	}

	public List<String> loadResource(String nome, String extensao) throws IOException {
		List<String> resource = new ArrayList<String>();
        Path path = Paths.get(ResourceLoader.DIR_NAME + nome + "." + extensao);
        Files.lines(path, StandardCharsets.ISO_8859_1).forEach(resource::add);
        return resource;
	}	

}
