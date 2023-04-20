package br.edu.ifba.inf011.model;

import java.util.Random;

import br.edu.ifba.inf011.prototype.Prototipo;

public class AmbienteBasico implements Ambiente{

	private	String id;
	public Double ultimaMedicao;

	public AmbienteBasico(AmbienteBasico ambiente) {
		this(ambiente.id, ambiente.ultimaMedicao);
	}
	
	public AmbienteBasico(String id) {
		this(id, 27.0);
	}	
	
	public AmbienteBasico(String id, Double ultimaMedicao) {
		this.id = id;
		this.ultimaMedicao = ultimaMedicao;
	}
	
	public String getId() {
		return this.id;
	}
	
	public double getTemperatura() {
		return this.ultimaMedicao; 
	}
	
	public void aquecer(double intensidade) {
		this.ultimaMedicao += this.getVariacao(intensidade);
	}
	
	public void esfriar(double intensidade) {
		this.ultimaMedicao -= this.getVariacao(intensidade);
	}
	

	private double getVariacao(double intensidade) {
		Random random = new Random();
		double variacao = random.nextDouble() * intensidade;
		return variacao;
	}	

	
	public void randomizar(int maximo) {
		Random random = new Random();
		int valor = random.nextInt(maximo);
		if (random.nextBoolean()) 
			this.esfriar(valor); 
		else
			this.aquecer(valor); 
	}

	@Override
	public void setTemperaturaAtuacao(double temperaturaAtuacao) {
		Random random = new Random();
		double temperatura = random.nextDouble() * temperaturaAtuacao;
		this.ultimaMedicao += temperatura;
	}

	@Override
	public Prototipo prototipar() {
		return new AmbienteBasico(this);
	}
	
	
}