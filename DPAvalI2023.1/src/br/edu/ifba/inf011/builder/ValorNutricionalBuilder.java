package br.edu.ifba.inf011.builder;

import br.edu.ifba.inf011.model.Alimento;
import br.edu.ifba.inf011.model.ValorNutricional;

public class ValorNutricionalBuilder implements PreparoBuilder{

	private Double cho;
	private Double ptn;
	private Double lip;	
	
	@Override
	public void reset() {
		this.cho = 0.0;
		this.ptn = 0.0;
		this.lip = 0.0;
	}

	@Override
	public void addAlimento(Alimento alimento) {
		this.cho += alimento.getQuantidadeNutriente("CARBOIDRATO");
		this.ptn += alimento.getQuantidadeNutriente("PROTEINA");
		this.lip += alimento.getQuantidadeNutriente("GORDURA");
	}

	@Override
	public void lowCarb() {
	}

	@Override
	public void semGluten() {
	}

	@Override
	public void setNome(String string) {
	}
	
	public ValorNutricional get() {
		return new ValorNutricional(this.cho, this.ptn, this.lip);
	}

}
