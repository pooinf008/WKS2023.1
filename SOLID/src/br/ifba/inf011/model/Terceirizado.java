package br.ifba.inf011.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.ifba.inf011.model.exception.RHException;

public class Terceirizado extends Funcionario{

	public Terceirizado(String matricula, String nome, BigDecimal salario, Cargo cargo) {
		super(matricula, nome, salario, cargo);
	}

	public void reajustar(BigDecimal novoSalario) throws RHException {
		throw new RHException("OPERAÇÃO INVALIDA");
	}	
	
}
