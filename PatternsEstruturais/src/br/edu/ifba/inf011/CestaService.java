package br.edu.ifba.inf011;

import java.util.ArrayList;
import java.util.List;

public class CestaService implements Cesta {
	
	private List<Remetivel> remetiveis;
	
	public CestaService() {
		this.remetiveis = new ArrayList<Remetivel>();
	}
	
	public void adicionar(Remetivel remetivel) throws Exception{
		this.remetiveis.add(remetivel);
	}
	
	public void adicionar(String continente,
						  Remetivel conteudo) throws Exception{
		for(Remetivel remetivel : this.remetiveis)
			if(remetivel.getId().equals(continente)) {
				remetivel.adicionar(conteudo);
				return;
			}	
		throw new Exception("Caixa inexistente");
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
	
	
}
