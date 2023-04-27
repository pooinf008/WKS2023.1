package br.edu.ifba.inf011.model.controladores;

import java.util.List;
import java.io.PrintStream;
import java.util.ArrayList;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.Atuador;
import br.edu.ifba.inf011.model.Controlador;
import br.edu.ifba.inf011.model.Termometro;
import br.edu.ifba.inf011.model.TipoControlador;
import br.edu.ifba.inf011.model.atuadores.Resfriador;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;

public class ControladorBasico implements Controlador{
	
	protected Ambiente ambiente;
	protected List<Termometro> termometros;
	protected Atuador atuador;
	protected List<Double> historico;
	protected TipoControlador tipo;
	
	
	public ControladorBasico(TipoControlador tipo, Ambiente ambiente, Integer qtdeTermometros, Double tempMaxima) {
			this.ambiente = ambiente;
			this.termometros = new ArrayList<Termometro>();
			
			for(int iCont = 0; iCont < qtdeTermometros; iCont++)
				this.termometros.add(new TermometroAlta(ambiente, tempMaxima, System.out, System.err, 1));
			
			this.atuador = new Resfriador(ambiente, tempMaxima, System.err, 1);
			this.historico = new ArrayList<Double>();
			
			this.tipo = tipo;
	}	
	
	
	
	public void setTipo(TipoControlador tipo) {
		this.tipo = tipo;
	}



	public ControladorBasico(Ambiente ambiente, List<Termometro> termometros2, 
							  Atuador atuador) {
		this.ambiente = ambiente;
		this.termometros = termometros2;
		this.atuador = atuador;
	}
	
	public void monitorar() throws Exception{
		double temperatura;
		this.ambiente.randomizar(2);
		temperatura = this.getTemperatura();
		this.historico.add(temperatura);
		System.out.println(">>TEMPERATURA AMBIENTE "+ this.ambiente.getTemperatura() + "<<");
		this.ambiente.setTemperaturaAtuacao(this.atuador.definirTemperatura(temperatura));
	}
	
	
	public double getTemperatura() {
		if(tipo == TipoControlador.MEDIA)
			return this.getTempMedia();
		if(tipo == TipoControlador.MAXIMA)
			return this.getTempMaxima();		
		return 0;
	}

	private double getTempMedia() {
		double temperatura = 0;
		System.out.println("Politica: Media");
		for(Termometro termometro : this.termometros)
			temperatura +=termometro.lerTemperatura();
		return temperatura / this.termometros.size();
	}
	
	private double getTempMaxima() {
		double temperatura = 0;
		double tempMaxima = 0;
		System.out.println("Politica: Maxima");
		for(Termometro termometro : this.termometros) {
			temperatura = termometro.lerTemperatura();
			if(tempMaxima < temperatura)
				tempMaxima = temperatura;
		}	
		return tempMaxima;
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
