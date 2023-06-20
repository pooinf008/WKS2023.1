package br.edu.ifba.inf011;

import java.util.Objects;

//ADAPTER em um ADAPTER
public class Product2Produto implements RemetivelDecoravel{

	
	private Product product;
	
	public Product2Produto(Product product){
		this.product = product;
	}
	
	@Override
	public Double getPeso() {
		return this.product.getWeight() / 35.274;
	}

	@Override
	public Double getPreco() {
		return this.product.getPrice() * 4.81;
	}

	@Override
	public void adicionar(Remetivel remetivel) {
		
	}

	@Override
	public String getId() {
		return this.product.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product2Produto other = (Product2Produto) obj;
		return Objects.equals(product, other.product);
	}
	
	
	

}
