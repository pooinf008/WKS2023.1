package br.edu.ifba.inf011;

import br.edu.ifba.inf011.model.Ambiente;
import br.edu.ifba.inf011.model.AmbienteBasico;
import br.edu.ifba.inf011.model.TipoControlador;
import br.edu.ifba.inf011.model.controladores.ControladorBasico;
import br.edu.ifba.inf011.model.controladores.ControladorBasicoMedia;
import br.edu.ifba.inf011.model.controladores.ControladorBasicoMaxima;

public class Aplicacao {

	public void executar() throws Exception{
		int iCont = 1;
		AmbienteBasico ambiente = new AmbienteBasico("AMB01", 27.0);
		ControladorBasico controlador = new ControladorBasico(TipoControlador.MAXIMA, ambiente , 5, 28.0);
		while(true) {
			if(iCont % 100 == 0)
				controlador.setTipo(TipoControlador.MEDIA);
			controlador.monitorar();
			Thread.sleep(100);
			iCont++;
		}	
		
	}	
	

}
