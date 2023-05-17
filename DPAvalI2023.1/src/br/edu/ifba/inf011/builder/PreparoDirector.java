package br.edu.ifba.inf011.builder;

import br.edu.ifba.inf011.exception.NutrienteNaoEncontradoException;
import br.edu.ifba.inf011.model.Alimento;
import br.edu.ifba.inf011.model.Nutriente;
import br.edu.ifba.inf011.singleton.CatalogoNutriente;

public class PreparoDirector {
	
	private PreparoBuilder builder;
	private Nutriente cho;
	private Nutriente lib;
	
	public PreparoDirector(PreparoBuilder builder) {
		this.builder = builder;
		CatalogoNutriente.instance().create("CARBOIDRATO", "GRAMA", 4.0);
		CatalogoNutriente.instance().create("PROTEINA", "GRAMA", 4.0);
		CatalogoNutriente.instance().create("GORDURA", "GRAMA", 9.0);
		
	}
	
	public void setBuilder(PreparoBuilder builder) {
		this.builder = builder;
	}

	
	public void fazerOvoFrito() throws NutrienteNaoEncontradoException {
		Alimento ovo = new Alimento("OVO", 0.24, 1.95, 7.28);
		Alimento manteiga = new Alimento("MANTEIGA", 0.01, 0.08, 8.11);	
		
		Nutriente sodio = CatalogoNutriente.instance().create("SODIO", "MICROGRAMA", 0.0);
		
		Alimento sal = new Alimento("SAL");
		sal.addNutriente(sodio, 400.0);
		
		this.builder.reset();
		this.builder.addAlimento(ovo);
		this.builder.addAlimento(manteiga);
		this.builder.addAlimento(sal);
		this.builder.lowCarb();
		this.builder.semGluten();
		this.builder.setNome("OVO FRITO");
		
		
	}

}
