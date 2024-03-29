package br.edu.ifba.inf011;

import java.util.ArrayList;
import java.util.List;

//COMPOSITE em um COMPOSITE
public class Caixa implements Remetivel{
	
	public List<Remetivel> remetiveis;
	private String id;
	
	
	public Caixa(String id) {
		this.id = id;
		this.remetiveis = new ArrayList<Remetivel>();
	}

	public void adicionar(Remetivel remetivel) {
		this.remetiveis.add(remetivel);
	}
	

	@Override
	public Double getPeso() {
		Double peso = 0.0;
		for(Remetivel remetivel : this.remetiveis)
			peso += remetivel.getPeso();
		peso += 0.01;
		return peso;
	}


	@Override
	public Double getPreco() {
		Double preco = 0.0;
		for(Remetivel remetivel : this.remetiveis)
			preco += remetivel.getPreco();
		return preco;
	}

	@Override
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
