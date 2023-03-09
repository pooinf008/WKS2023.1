package br.ifba.inf011.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import br.ifba.inf011.model.exception.RHException;

public class Funcionario {
	private String matricula;
	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;
	private Cargo cargo;
	private String email;
	
	public Funcionario(String matricula, String nome, BigDecimal salario, Cargo cargo) {
		this.matricula = matricula;
		this.nome = nome;
		this.salario = salario;
		this.cargo = cargo;
		this.dataAdmissao = LocalDate.now();
		this.dataUltimoReajuste = LocalDate.now();
		this.email = matricula + "@minhaempresa.com";
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
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
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", nome=" + nome + ", salario=" + salario + ", cargo=" + cargo
				+ "]";
	}
	
	public void reajustar(BigDecimal novoSalario) throws RHException {
		this.salario = novoSalario;
		this.dataUltimoReajuste = LocalDate.now();
	}

	public BigDecimal getSalario() {
		return this.salario ;
	}
	
	
}
