package br.edu.ifba.inf011;

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

}
