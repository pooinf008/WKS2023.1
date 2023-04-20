package br.edu.ifba.inf011;
import br.edu.ifba.inf011.criacional.builder.ControladorDirector;
import br.edu.ifba.inf011.criacional.builder.IControladorConstrutor;
import br.edu.ifba.inf011.criacional.builder.builders.ControladorBasicoBuilder;
import br.edu.ifba.inf011.criacional.builder.builders.EspecificacaoBuilder;
import br.edu.ifba.inf011.criacional.builder2.ControladorConstrutor;
import br.edu.ifba.inf011.model.AmbienteBasico;
import br.edu.ifba.inf011.model.Controlador;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;

public class Aplicacao {

	public void executar2() throws Exception{
		AmbienteBasico ambiente = new AmbienteBasico("AMB01", 27.0);
		
		IControladorConstrutor b = ControladorConstrutor.builder();
		
		Controlador controlador = b.reset()
							       .adicionaTermometro(new TermometroAlta(ambiente, 28.0))
							       .adicionaTermometro(new TermometroAlta(ambiente, 28.0))
							       .adicionaTermometro(new TermometroAlta(ambiente, 28.0))
								   .getControlador(ambiente);
		
		Controlador controlador2 = (Controlador) controlador.prototipar();
		
		System.out.println(controlador);
		System.out.println(controlador.getEspecificacao());
		System.out.println(controlador2);
		System.out.println(controlador2.getEspecificacao());
		
		controlador.monitorar();
		
	}	
	
	
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
