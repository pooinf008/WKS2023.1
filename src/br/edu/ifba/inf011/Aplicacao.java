package br.edu.ifba.inf011;

import br.edu.ifba.inf011.cor.HandlerFullMaxima;
import br.edu.ifba.inf011.cor.HandlerFullMedia;
import br.edu.ifba.inf011.cor.HandlerHalfMaxima;
import br.edu.ifba.inf011.cor.HandlerHalfMedia;
import br.edu.ifba.inf011.cor.HandlerRecarga;
import br.edu.ifba.inf011.cor.MonitorarHandler;
import br.edu.ifba.inf011.model.AmbienteBasico;
import br.edu.ifba.inf011.model.controladores.ControladorBasico;
import br.edu.ifba.inf011.strategy.TipoControlador;
import br.edu.ifba.inf011.tm.HandlerFullMaximaTM;
import br.edu.ifba.inf011.tm.HandlerFullMediaTM;
import br.edu.ifba.inf011.tm.HandlerHalfMaximaTM;
import br.edu.ifba.inf011.tm.HandlerHalfMediaTM;
import br.edu.ifba.inf011.tm.HandlerRecargaTM;

public class Aplicacao {

	public void executar() throws Exception{
		int iCont = 1;
		AmbienteBasico ambiente = new AmbienteBasico("AMB01", 27.0);
		
		MonitorarHandler handler = new HandlerFullMediaTM(
				new HandlerFullMaximaTM(
						new HandlerHalfMediaTM(
								new HandlerHalfMaximaTM(
										new HandlerRecargaTM(null)))));
		
		ControladorBasico controlador = new ControladorBasico(TipoControlador.MAXIMA, 
															  ambiente , 
															  5, 28.0,
															  handler);
		while(true) {
			if(iCont % 30 == 0)
				controlador.setTipo(TipoControlador.MEDIA);
			if(iCont%50 == 0) {
				controlador.desligar();
				controlador.recarregar();
			}
			if(iCont%100 == 0)
				controlador.ligar();
			
			controlador.monitorar();
			Thread.sleep(100);
			iCont++;
		}	
		
	}	
	

}
