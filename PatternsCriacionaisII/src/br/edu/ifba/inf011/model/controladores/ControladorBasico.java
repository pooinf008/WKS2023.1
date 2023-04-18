package br.edu.ifba.inf011.model.controladores;

import java.util.List;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;
import br.edu.ifba.inf011.model.Controlador;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;

public class ControladorBasico implements Controlador{
	
	private Ambiente ambiente;
	private List<? extends Termometro> termometros;
	private Atuador atuador;
	
	public ControladorBasico(Ambiente ambiente, List<? extends Termometro> termometros2, 
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


	

}
