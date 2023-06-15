package br.edu.ifba.inf011;

//CONCRETEDECORATOR em um DECORATOR
public class EmbalagemProduto extends BaseRemetivelDecorator{
	
	public EmbalagemProduto(RemetivelDecoravel decoravel) {
		super(decoravel);
	}
	
	public Double getPreco() {
		return super.getPreco() * 1.05;
	}
	
	public Double getPeso() {
		return super.getPeso() * 1.05;
	}
	

}
