package br.ifba.inf011.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import br.ifba.inf011.model.exception.RHException;

public class Funcionario implements FuncionarioIF{
	
	private FichaCadastral ficha;
	
	public Funcionario(String matricula, String nome, BigDecimal salario, Classe classe) {
		this.ficha = new FichaCadastral(matricula, nome, salario, classe);
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(ficha, other.ficha);
	}




	@Override
	public String toString() {
		return "Funcionario [matricula=" + ficha.getMatricula() + ", nome=" + ficha.getNome() + ", salario=" + ficha.getSalario() + ", classe=" + ficha.getClasse()
				+ "]";
	}
	
	public void reajustar(BigDecimal novoSalario) throws RHException {
		this.ficha.setSalario(novoSalario);
		this.ficha.setDataUltimoReajuste(LocalDate.now());
	}

	public BigDecimal getSalario() {
		return this.ficha.getSalario() ;
	}

	public void reclassificar() {
		this.ficha.reclassificar();
	}

	
	
}
