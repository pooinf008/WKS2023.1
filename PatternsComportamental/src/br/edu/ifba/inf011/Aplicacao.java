package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.AmbienteBasico;
import br.edu.ifba.inf011.model.controladores.ControladorBasico;
import br.edu.ifba.inf011.strategy.TipoControlador;

public class Aplicacao {

	public void executar() throws Exception{
		int iCont = 1;
		AmbienteBasico ambiente = new AmbienteBasico("AMB01", 27.0);
		ControladorBasico controlador = new ControladorBasico(TipoControlador.MAXIMA, ambiente , 5, 28.0);
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
