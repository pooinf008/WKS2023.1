package br.ifba.inf011.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import br.ifba.inf011.model.exception.RHException;

public class Terceirizado implements Reclassificavel{
	
	private FichaCadastral ficha;
	private String empresa;

	public Terceirizado(String matricula, String nome, BigDecimal salario, Classe classe, String empresa) {
		this.ficha = new FichaCadastral(matricula, nome, salario, classe);		
		this.empresa = empresa;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ficha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terceirizado other = (Terceirizado) obj;
		return Objects.equals(ficha, other.ficha);
	}


	@Override
	public String toString() {
		return "Terceirizado [matricula=" + this.ficha.getMatricula() + 
				", nome=" + this.ficha.getNome() + 
				", salario=" + this.ficha.getSalario() + 
				", cargo=" + this.ficha.getClasse()
				+ "]";
	}

	public BigDecimal getSalario() {
		return this.ficha.getSalario() ;
	}
	
	public void reclassificar() {
		this.ficha.reclassificar();
	}

	
	
}
