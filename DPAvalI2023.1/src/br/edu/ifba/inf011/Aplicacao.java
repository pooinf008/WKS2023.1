package br.edu.ifba.inf011;

import br.edu.ifba.inf011.builder.PreparoDirector;
import br.edu.ifba.inf011.builder.PreparoObjectBuilder;
import br.edu.ifba.inf011.builder.ValorNutricionalBuilder;
import br.edu.ifba.inf011.exception.NutrienteNaoEncontradoException;
import br.edu.ifba.inf011.model.Alimento;
import br.edu.ifba.inf011.model.Nutriente;
import br.edu.ifba.inf011.model.Preparo;
import br.edu.ifba.inf011.model.ValorNutricional;
import br.edu.ifba.inf011.singleton.CatalogoNutriente;

public class Aplicacao {
	
	
	public void q1() {
		try {
			Nutriente nutriente = CatalogoNutriente.instance().create("CARBOIDRATO");
			System.out.println(nutriente);
		} catch (NutrienteNaoEncontradoException e) {
			System.out.println(e.getNome() + " não encontrado"); 
		}
		
		Nutriente cho = CatalogoNutriente.instance().create("CARBOIDRATO", "GRAMA", 4.5);
		Nutriente ptn = CatalogoNutriente.instance().create("PROTEINA", "GRAMA", 4.0);
		Nutriente lip = CatalogoNutriente.instance().create("GORDURA", "GRAMA", 9.0);		
		
		System.out.println(cho);		
		
		CatalogoNutriente.instance().create("CARBOIDRATO", "GRAMA", 4.0);
		
		System.out.println(cho);	
		
		Alimento ovo = new Alimento("OVO");
		ovo.addNutriente(cho, 0.24);
		ovo.addNutriente(ptn, 1.95);
		ovo.addNutriente(lip, 7.28);
		
		System.out.println(ovo);

		Alimento manteiga = new Alimento("MANTEIGA");
		manteiga.addNutriente(cho, 0.01);
		manteiga.addNutriente(ptn, 0.08);
		manteiga.addNutriente(lip, 8.11);
		
		System.out.println(manteiga);
		
		
	}
	
	public void q2() throws NutrienteNaoEncontradoException {
		PreparoObjectBuilder builder01 = new PreparoObjectBuilder();
		ValorNutricionalBuilder builder02 = new ValorNutricionalBuilder();
		
		PreparoDirector director = new PreparoDirector(builder01);
		director.fazerOvoFrito();
		Preparo preparo = builder01.get();
		
		director.setBuilder(builder02);
		director.fazerOvoFrito();
		ValorNutricional valorNutricional = builder02.get(); 
		
		System.out.println(preparo.ingredientes());
		
		System.out.println(valorNutricional);
		
		
		
	}	
	
	
	public static void main(String[] args) throws NutrienteNaoEncontradoException {
		(new Aplicacao()).q2();
	}
	

}
