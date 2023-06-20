package br.edu.ifba.inf011;

public class CestaProxy implements Cesta{

	private CestaService service;
	private String user;
	private String pwd;
	
	public CestaProxy(CestaService service, String user, String pwd) {
		this.service = service;
		this.user = user;
		this.pwd = pwd;
	}
	
	@Override
	public void adicionar(Remetivel remetivel) throws Exception {
		this.service.adicionar(remetivel);
		
	}

	@Override
	public void adicionar(String continente, Remetivel conteudo) throws Exception {
		this.service.adicionar(continente, conteudo);
		
	}

	@Override
	public Double getPreco() {
		if(user.equalsIgnoreCase("USER") && pwd.equals("PWD"))
			return this.service.getPreco();
		return 0.0;
	}

	@Override
	public Double getPeso() {
		if(user.equalsIgnoreCase("USER") && pwd.equals("PWD"))
			return this.service.getPeso();
		return 0.0;

	}

}
