package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.inf011.composite.Tocavel;

public class Playlist implements Tocavel{
	
	private String nome;
	private List<Tocavel> tocaveis;
	
	public Playlist(String nome) {
		this.nome = nome;
		this.tocaveis = new ArrayList<Tocavel>();
	}
	
	public void insert(Tocavel musica) {
		this.tocaveis.add(musica);
	}
	
	public String getNome() {
		return this.nome;
	};
	
	public String randomize() {
		int numero = (new Random()).nextInt(this.tocaveis.size()); 
		return this.tocaveis.get(numero).randomize();
	};
	
	public String execute() {
		StringBuffer str = new StringBuffer();
		for(Tocavel tocavel : this.tocaveis)
			str.append(tocavel.execute() + "\n");
		return str.toString();	
	}	

}
