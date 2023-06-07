package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Musica> musicas;
	private List<Playlist> playlists;
	private PlayerMode mode;
	private Integer index;
	
	public Player() {
		this.setMode(PlayerMode.PlayerAll);
		this.reset();
		this.musicas = new ArrayList<Musica>();
	}
	
	public void insert(Musica musica) {
		this.musicas.add(musica);
	}
	
	public void insert(Playlist playlist) {
		this.playlists.add(playlist);
	}
	
	
	public boolean temProximo() {
		return false;
	}
	
	public String proximo() {
		return null;
	}
	
	public void reset() {
		this.index = 0;
	}
	
	public void setMode(PlayerMode mode) {
		this.mode = mode;
	}


}
