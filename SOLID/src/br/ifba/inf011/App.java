package br.ifba.inf011;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.model.Cargo;
import br.ifba.inf011.model.Funcionario;
import br.ifba.inf011.model.Terceirizado;
import br.ifba.inf011.model.exception.RHException;
import br.ifba.inf011.model.regras.Regra;
import br.ifba.inf011.model.regras.RegraMaiorIndice;
import br.ifba.inf011.model.regras.RegraMenorIndice;
import br.ifba.inf011.service.Reajustador;

public class App {

	public void run(){
		
		List<Regra> regras = new ArrayList<Regra>();
		regras.add(new RegraMaiorIndice());
		regras.add(new RegraMenorIndice());
		
		Reajustador reajustador = new Reajustador(regras);
		
		Funcionario funcionario = new Funcionario("0001", 
												  "Uncle Bob",
												  new BigDecimal(10000),
												  Cargo.JUNIOR);

		Funcionario terceirizado = new Terceirizado("0002", 
				  									"Gamma",
				  									new BigDecimal(8000),
				  									Cargo.JUNIOR);
		
		
		System.out.println(funcionario);
		System.out.println(terceirizado);
		
		this.reajustar(reajustador, funcionario);
		
		this.reajustar(reajustador, terceirizado);		
		
		System.out.println(funcionario);
		System.out.println(terceirizado);
		
	}



	private void reajustar(Reajustador reajustador, Funcionario funcionario) {
		try {
			reajustador.reajustar(funcionario, 0.03);
		} catch (RHException e) {
			System.err.println("ERRO NA OPERAÇÃO: " + e.getMessage());
		}
	}
	
	
	
	public static void main(String[] args) {
		(new App()).run();
	}
	
	
}
