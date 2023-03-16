package br.ifba.inf011.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class FichaCadastral {
	
	private String matricula;
	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;
	private LocalDate dataUltimoReajuste;
	private Classe classe;
	private String email;

	public FichaCadastral(String matricula, String nome, BigDecimal salario, Classe classe) {
		this.matricula = matricula;
		this.nome = nome;
		this.salario = salario;
		this.classe = classe;
		this.dataAdmissao = LocalDate.now();
		this.dataUltimoReajuste = LocalDate.now();
		this.email = matricula + "@minhaempresa.com";		
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public Classe getClasse() {
		return this.classe;
	}

	public String getEmail() {
		return email;
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
		FichaCadastral other = (FichaCadastral) obj;
		return Objects.equals(matricula, other.matricula);
	}

	public void setSalario(BigDecimal novoSalario) {
		this.salario = novoSalario;
	}

	public void setDataUltimoReajuste(LocalDate now) {
		this.dataUltimoReajuste = now;
	}
	
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public void reclassificar() {
		this.setClasse(this.getClasse().proximo());
	}


	
	
	
}