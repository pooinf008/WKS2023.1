package br.edu.ifba.inf011.model.controladores;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;
import br.edu.ifba.inf011.model.Controlador;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.prototype.Prototipo;

public class ControladorBasico implements Controlador{
	
	private Ambiente ambiente;
	private List<Termometro> termometros;
	private Atuador atuador;
	
	
	public ControladorBasico(ControladorBasico cb) {
		this.ambiente = (Ambiente) cb.ambiente.prototipar();
		this.termometros = new ArrayList<>();
		for(Termometro termometro : cb.termometros)
			this.termometros.add((Termometro)termometro.prototipar());
		this.atuador = (Atuador) cb.atuador.prototipar();
	}
	
	public ControladorBasico(Ambiente ambiente, List<Termometro> termometros2, 
							  Atuador atuador) {
		this.ambiente = ambiente;
		this.termometros = termometros2;
		this.atuador = atuador;
	}
	
	public void monitorar() throws Exception{
		while(true) {
			double temperatura;
			this.ambiente.randomizar(2);
			temperatura = this.getTemperatura();
			this.ambiente.setTemperaturaAtuacao(this.atuador.definirTemperatura(temperatura));
			Thread.sleep(100);
		}		
	}	
	
	@Override
	public void monitorar(Ambiente ambiente) throws Exception {
		while(true) {
			double temperatura;
			ambiente.randomizar(2);
			for(Termometro termometro : this.termometros)
				termometro.setAmbiente(ambiente);
			temperatura = this.getTemperatura();
			ambiente.setTemperaturaAtuacao(this.atuador.definirTemperatura(temperatura));
			Thread.sleep(100);
		}		
	}	
	
	public double getTemperatura() {
		double temperatura = 0;
		for(Termometro termometro : this.termometros)
			temperatura +=termometro.lerTemperatura();
		return temperatura / this.termometros.size();
	}

	@Override
	public Prototipo prototipar() {
		return new ControladorBasico(this);
	}
	
	public String getEspecificacao() {
		String especificacao = this.getClass().getSimpleName()  + " {\n";
		especificacao += "\t Quantidade de Termometros : \n";
		especificacao += "\t\t " + this.termometros.size()  + "\n";
		for(Termometro t : this.termometros)
			especificacao += "\t\t"+ t + "\n"; 
		especificacao += "\t Tipo de Atuador : " + this.atuador + "\n";
		especificacao += "\t Ambiente de Atuação : " + this.ambiente + "\n";
		return especificacao + "}\n";
	}	
	

}
