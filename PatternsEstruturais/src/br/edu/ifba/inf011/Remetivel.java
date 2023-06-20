package br.edu.ifba.inf011;

//COMPONENT em um COMPOSITE
public interface Remetivel {
	public String getId();
	public Double getPeso();
	public Double getPreco();
	public void adicionar(Remetivel remetivel);
}
