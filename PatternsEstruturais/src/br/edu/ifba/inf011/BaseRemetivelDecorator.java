package br.edu.ifba.inf011;

//DECORATOR em um DECORATOR
public abstract class BaseRemetivelDecorator implements RemetivelDecoravel{
	
	private RemetivelDecoravel decoravel;
	

	public BaseRemetivelDecorator(RemetivelDecoravel decoravel) {
		super();
		this.decoravel = decoravel;
	}

	@Override
	public Double getPeso() {
		return decoravel.getPeso();
	}

	@Override
	public Double getPreco() {
		return decoravel.getPreco();
	}
	
	

}
