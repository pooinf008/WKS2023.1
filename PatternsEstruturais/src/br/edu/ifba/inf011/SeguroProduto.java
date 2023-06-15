package br.edu.ifba.inf011;

//CONCRETEDECORATOR em um DECORATOR
public class SeguroProduto extends BaseRemetivelDecorator{
	
	public SeguroProduto(RemetivelDecoravel decoravel) {
		super(decoravel);
	}
	
	public Double getPreco() {
		return super.getPreco() * 1.1;
	}
	
	public String hashValidator() {
		return String.valueOf(super.getPreco().hashCode()) +
				String.valueOf(super.getPeso().hashCode());	
	}

}
