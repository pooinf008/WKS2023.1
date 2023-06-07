package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist{
	
	private String nome;
	private List<Musica> musicas;
	private List<Playlist> playlists;
	
	public Playlist(String nome) {
		this.nome = nome;
		this.musicas = new ArrayList<Musica>();
		this.playlists = new ArrayList<Playlist>();
	}
	
	public void insert(Musica musica) {
		this.musicas.add(musica);
	}
	
	public void insert(Playlist playlist) {
		this.playlists.add(playlist);
	}	
	
	public String getNome() {
		return this.nome;
	};
	
	public String randomize() {
		return null;
	};
	
	public String execute() {
		return null;
	}	

}
