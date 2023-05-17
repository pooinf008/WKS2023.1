package br.edu.ifba.inf011.exception;

public class NutrienteNaoEncontradoException extends Exception {
	
	private String nome;
	
	public NutrienteNaoEncontradoException(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	

}
