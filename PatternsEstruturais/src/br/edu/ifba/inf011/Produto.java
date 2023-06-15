package br.edu.ifba.inf011;

import java.util.Objects;


//LEAF em um COMPOSITE
//CONCRETECOMPONENT em um DECORATOR
public class Produto implements Remetivel, RemetivelDecoravel{
	
	private String id;
	private String descricao;
	private Double preco;
	private Double peso;
	
	
	public Produto(String id, String descricao, Double preco, Double peso) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.peso = peso;
	}
	public String getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public Double getPeso() {
		return peso;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
