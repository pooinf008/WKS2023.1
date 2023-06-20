package br.edu.ifba.inf011;

public interface Cesta {
	
	public void adicionar(Remetivel remetivel) throws Exception;
	public void adicionar(String continente,
			  Remetivel conteudo) throws Exception;
	public Double getPreco();
	public Double getPeso();

}
