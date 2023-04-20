package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.prototype.Prototipo;

public interface Controlador extends Prototipo{
	public void monitorar() throws Exception;
	public void monitorar(Ambiente ambiente) throws Exception;	
	public String getEspecificacao();
}