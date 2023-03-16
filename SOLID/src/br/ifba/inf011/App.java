package br.ifba.inf011;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.ifba.inf011.model.Classe;
import br.ifba.inf011.model.Funcionario;
import br.ifba.inf011.model.Reajustavel;
import br.ifba.inf011.model.Terceirizado;
import br.ifba.inf011.model.exception.RHException;
import br.ifba.inf011.model.regras.Regra;
import br.ifba.inf011.model.regras.RegraMaiorIndice;
import br.ifba.inf011.model.regras.RegraMenorIndice;
import br.ifba.inf011.service.Reajustador;
import br.ifba.inf011.service.Reclassificador;

public class App {

	public void run(){
		
		List<Regra> regras = new ArrayList<Regra>();
		regras.add(new RegraMaiorIndice());
		regras.add(new RegraMenorIndice());
		
		
		Reclassificador reclassificador = new Reclassificador();
		
		Reajustador reajustador = new Reajustador(regras);
		
		Funcionario funcionario = new Funcionario("0001", 
												  "Uncle Bob",
												  new BigDecimal(10000),
												  Classe.JUNIOR);

		Terceirizado terceirizado = new Terceirizado("0002", 
				  									"Gamma",
				  									new BigDecimal(8000),
				  									Classe.JUNIOR,
				  									"Design Patterns Cia.");
		
		
		System.out.println(funcionario);
		System.out.println(terceirizado);
		
		reclassificador.reclassificar(funcionario);
		
		reclassificador.reclassificar(terceirizado);
		
		this.reajustar(reajustador, funcionario);
		
		
		System.out.println(funcionario);
		System.out.println(terceirizado);
		
	}



	private void reajustar(Reajustador reajustador, Reajustavel funcionario) {
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
