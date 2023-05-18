package br.edu.ifba.inf011.model.controladores;

import java.util.List;
import java.io.PrintStream;
import java.util.ArrayList;

import br.edu.ifba.inf011.cor.HandlerFullMaxima;
import br.edu.ifba.inf011.cor.HandlerFullMedia;
import br.edu.ifba.inf011.cor.HandlerHalfMaxima;
import br.edu.ifba.inf011.cor.HandlerHalfMedia;
import br.edu.ifba.inf011.cor.HandlerRecarga;
import br.edu.ifba.inf011.cor.MonitorarHandler;
import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;
import br.edu.ifba.inf011.model.Controlador;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.model.atuadores.Resfriador;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.state.ControladorState;
import br.edu.ifba.inf011.state.LigadoState;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaMedia;
import br.edu.ifba.inf011.strategy.CalculoTemperaturaStrategy;
import br.edu.ifba.inf011.strategy.TipoControlador;

public class ControladorBasico implements Controlador{
	
	protected Ambiente ambiente;
	protected List<Termometro> termometros;
	protected Atuador atuador;
	protected List<Double> historico;
	protected Double bateria;
	
	protected CalculoTemperaturaStrategy strategy;
	protected ControladorState state;
	protected Integer ciclos;
	
	protected Boolean ciclo;
	
	protected MonitorarHandler handler;
	
	
	public ControladorBasico(TipoControlador tipo, Ambiente ambiente, Integer qtdeTermometros, Double tempMaxima,
							 MonitorarHandler handler) {
			this.ambiente = ambiente;
			this.termometros = new ArrayList<Termometro>();
			
			for(int iCont = 0; iCont < qtdeTermometros; iCont++)
				this.termometros.add(new TermometroAlta(ambiente, tempMaxima, System.out, System.err, 1));
			
			this.atuador = new Resfriador(ambiente, tempMaxima, System.err, 1);
			this.historico = new ArrayList<Double>();
			
			this.strategy = tipo.getStrategy();
			this.state = new LigadoState();
			this.bateria = 100.0;
			this.ciclos = 0;
			this.ciclo = true;
			
			this.handler = handler;
			
	}	
	
	public void setTipo(TipoControlador tipo) {
		this.strategy = tipo.getStrategy();
	}



	public ControladorBasico(Ambiente ambiente, List<Termometro> termometros2, 
							  Atuador atuador) {
		this.ambiente = ambiente;
		this.termometros = termometros2;
		this.atuador = atuador;
	}
	
	public void monitorar() throws Exception{
		double temperatura = 0;
		boolean comAtuacao = false; 
		this.ambiente.randomizar(2);
		
		double consumo = this.handler.monitorar(this.bateria, this.termometros, this.historico);
		
		if(consumo != Double.NaN) {
			temperatura = this.historico.get(this.historico.size() - 1);
			bateria += consumo;
		}else
			temperatura =  0;
		this.ciclos++;
		System.out.println(">>" + this.ciclos + " TEMPERATURA AMBIENTE "+ this.ambiente.getTemperatura() +  " Bateria: " + this.bateria +" <<");
		this.ambiente.setTemperaturaAtuacao(this.atuador.definirTemperatura(temperatura));
	}
	
	
	
/*	public void monitorar() throws Exception{
		double temperatura = 0;
		boolean comAtuacao = false; 
		this.ambiente.randomizar(2);
		if(this.bateria > 70) { 
			bateria += this.monitorarFullMedia();
			comAtuacao = true;
		}
		if(this.bateria > 50) { 
			bateria += this.monitorarFullMaxima();
			comAtuacao = true;
		}	
		else if(this.bateria > 30) {
			bateria += this.monitorarHalfMedia();
			comAtuacao = true;
		}
		else if(this.bateria > 15) {
			bateria += this.monitorarHalfMaxima();
			comAtuacao = true;
		}	
		else
			bateria += this.recharge();
		
		if(comAtuacao)
			temperatura = this.historico.get(this.historico.size() - 1);
		else
			temperatura =  0;
		this.ciclos++;
		System.out.println(">>" + this.ciclos + " TEMPERATURA AMBIENTE "+ this.ambiente.getTemperatura() +  " Bateria: " + this.bateria +" <<");
		this.ambiente.setTemperaturaAtuacao(this.atuador.definirTemperatura(temperatura));
	}
*/ 
	
/*	public void monitorar() throws Exception{
		double temperatura = 0;
		this.ambiente.randomizar(2);
		if(this.bateria > 0) {
			bateria += this.state.monitorar(this.strategy, this.termometros, this.historico);
			temperatura = this.historico.get(this.historico.size() - 1);
		}
		this.ciclos++;
		System.out.println(">>" + this.ciclos + " TEMPERATURA AMBIENTE "+ this.ambiente.getTemperatura() +  " Bateria: " + this.bateria +" <<");
		this.ambiente.setTemperaturaAtuacao(this.atuador.definirTemperatura(temperatura));
	}	
*/	

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

	@Override
	public void ligar() {
		this.state = this.state.ligar();
	}

	@Override
	public void desligar() {
		this.state = this.state.desligar();		
	}

	@Override
	public void economizar() {
		this.state = this.state.economizar();		
	}

	@Override
	public void recarregar() {
		this.state = this.state.recarregar();
	}
	
	public double monitorarFullMedia() {
		System.out.println("Monitoramento Full Media");
		this.setTipo(TipoControlador.MEDIA);
		this.strategy.getTemperaturaAtuacao(this.termometros, this.historico);
		return -1.0;
	}
	
	public double monitorarFullMaxima() {
		System.out.println("Monitoramento Full Maxima");
		this.setTipo(TipoControlador.MAXIMA);
		this.strategy.getTemperaturaAtuacao(this.termometros, this.historico);
		return -1.0;
	}

	public double monitorarHalfMaxima() {
		System.out.println("Monitoramento Half Maxima");
		this.setTipo(TipoControlador.MAXIMA);
		Double consumo = 0.0;
		if(this.ciclo) {
			strategy.getTemperaturaAtuacao(termometros, historico);
			consumo -= 1.0;
		}else {
			historico.add(historico.get(historico.size() - 1));
		}
		this.ciclo = !this.ciclo; 
		return consumo;
	}	
	
	
	public double monitorarHalfMedia() {
		System.out.println("Monitoramento Half Media");
		this.setTipo(TipoControlador.MEDIA);
		Double consumo = 0.0;
		if(this.ciclo) {
			strategy.getTemperaturaAtuacao(termometros, historico);
			consumo -= 1.0;
		}else {
			historico.add(historico.get(historico.size() - 1));
		}
		this.ciclo = !this.ciclo; 
		return consumo;
	}	
	
	public double recharge() {
		System.out.println("Recarga");
		return +0.5;
	}	

}
