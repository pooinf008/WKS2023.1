package br.edu.ifba.inf011;
import br.edu.ifba.inf011.criacional.builder.ControladorDirector;
import br.edu.ifba.inf011.criacional.builder.builders.ControladorBasicoBuilder;
import br.edu.ifba.inf011.criacional.builder.builders.EspecificacaoBuilder;
import br.edu.ifba.inf011.model.AmbienteBasico;
import br.edu.ifba.inf011.model.Controlador;

public class Aplicacao {

	public void executar() throws Exception{
		EspecificacaoBuilder especificacaoBuilder = new EspecificacaoBuilder();
		ControladorDirector director = new ControladorDirector(especificacaoBuilder);
		AmbienteBasico ambiente = new AmbienteBasico("AMB01", 27.0);
		director.makeControladorAlta(ambiente, 5);
		String especificao = especificacaoBuilder.getEspecificacao();
		
		System.out.println(especificao);
		
		ControladorBasicoBuilder builder = new ControladorBasicoBuilder();
		director.setBuilder(builder);
		director.makeControladorAlta(ambiente, 5);
		
		Controlador controlador = builder.getControlador();
		controlador.monitorar();
		
	}

}
