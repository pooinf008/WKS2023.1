package br.edu.ifba.inf011;

import java.util.ArrayList;

public class App {
	
	private void run2() throws Exception {
		Cesta cesta = new CestaProxy(new CestaService(), "USER", "PWD");
		
		cesta.adicionar(new Caixa("Cx01"));
		cesta.adicionar("Cx01",	new SeguroProduto(new Product2Produto(new Product("G01", "Vision Pro", 3500.0, 1.0))));
		cesta.adicionar(new Caixa("Cx02"));
		cesta.adicionar("Cx02", new Produto("M01", "Martelo", 15.0, 0.6));
		cesta.adicionar(new Caixa("Cx04"));
		cesta.adicionar("Cx04", new EmbalagemProduto(new Produto("T01", "Telefone", 300.0, 0.15)));
		cesta.adicionar("Cx04", new EmbalagemProduto(new SeguroProduto(new Produto("H01", "Fone de Ouvido", 500.0, 0.05))));
		cesta.adicionar(new Caixa("Cx05"));
		cesta.adicionar("Cx05", new SeguroProduto(new Produto("C01", "Carregador", 200.0, 0.10)));
		
		System.out.println(cesta.getPreco());
		System.out.println(cesta.getPeso());
		
		
	}	
	
	
	
	private void run() {
		
		Remetivel martelo = new Produto("M01", "Martelo", 15.0, 0.6);
		Remetivel telefone =  new EmbalagemProduto(new Produto("T01", "Telefone", 300.0, 0.15));
		Remetivel foneOuvido =  new EmbalagemProduto(new SeguroProduto(new Produto("H01", "Fone de Ouvido", 500.0, 0.05)));
		SeguroProduto carregador =  new SeguroProduto(new Produto("C01", "Carregador", 200.0, 0.10));
		Remetivel recibo =  new Produto("F01", "Recibo", 0.0, 0.01);
		
		Remetivel oculos = new SeguroProduto(new Product2Produto(new Product("G01", "Vision Pro", 3500.0, 1.0)));
		
		Caixa caixa01 = new Caixa("Cx01");
		Caixa caixa02 = new Caixa("Cx02");
		Caixa caixa03 = new Caixa("Cx03");
		Caixa caixa04 = new Caixa("Cx04");
		Caixa caixa05 = new Caixa("Cx05");
		
		caixa02.adicionar(martelo);
		caixa04.adicionar(telefone);
		caixa04.adicionar(foneOuvido);
		caixa05.adicionar(carregador);
		caixa03.adicionar(caixa04);
		caixa03.adicionar(caixa05);
		caixa01.adicionar(caixa02);
		caixa01.adicionar(caixa03);
		caixa01.adicionar(recibo);
		caixa01.adicionar(oculos);
		
		System.out.println(caixa01.getPreco());
		System.out.println(caixa01.getPeso());
		
		
	}	
	
	
	public static void main(String[] args) throws Exception {
		(new App()).run2();
	}



}
