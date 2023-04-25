package br.edu.ifba.inf011;
import br.edu.ifba.inf011.criacional.builder.ControladorDirector;
import br.edu.ifba.inf011.criacional.builder.IControladorConstrutor;
import br.edu.ifba.inf011.criacional.builder.builders.ControladorBasicoBuilder;
import br.edu.ifba.inf011.criacional.builder.builders.EspecificacaoBuilder;
import br.edu.ifba.inf011.criacional.builder2.ControladorConstrutor;
import br.edu.ifba.inf011.model.AmbienteBasico;
import br.edu.ifba.inf011.model.Controlador;
import br.edu.ifba.inf011.model.DictControladores;
import br.edu.ifba.inf011.model.SampleControladores;
import br.edu.ifba.inf011.model.atuadores.AtuadorDummy;
import br.edu.ifba.inf011.model.atuadores.Estabilizador;
import br.edu.ifba.inf011.model.termometros.TermometroAlta;
import br.edu.ifba.inf011.model.termometros.TermometroBasico;
import br.edu.ifba.inf011.model.termometros.TermometroFaixa;

public class Aplicacao {

	public void executar2() throws Exception{
		AmbienteBasico ambiente = new AmbienteBasico("AMB01", 27.0);
		DictControladores dicionario = DictControladores.instance(ambiente);
		
		Controlador nulo =  ControladorConstrutor.builder().reset()
							.adicionaTermometro(new TermometroBasico(ambiente))
							.adicionaAtuador(new AtuadorDummy())
							.getControlador(ambiente);
		
		
		dicionario.registrar("NULO", nulo);
		
		Controlador controlador = dicionario.get("NULO");
		Controlador controlador2 = dicionario.get("NULO");
		
		System.out.println(controlador);
		System.out.println(controlador.getEspecificacao());
		System.out.println(controlador2);
		System.out.println(controlador2.getEspecificacao());
		
		
		///
		
		///
		
		///
		
		///
		
		dicionario = DictControladores.instance(ambiente);
		Controlador controlador3 = dicionario.get("NULO");
		System.out.println(controlador3);
		System.out.println(controlador3.getEspecificacao());		
//		controlador.monitorar();
		
	}	
	
	public void executar3() throws Exception{
		AmbienteBasico ambiente = new AmbienteBasico("AMB01", 27.0);
		
		Controlador controlador = SampleControladores.instance(ambiente);
		Controlador controlador2 = SampleControladores.instance(ambiente);
		Controlador controlador3 = SampleControladores.instance(ambiente);
		
		System.out.println(controlador);
		System.out.println(controlador.getEspecificacao());
		System.out.println(controlador2);
		System.out.println(controlador2.getEspecificacao());
		System.out.println(controlador3);
		System.out.println(controlador3.getEspecificacao());		
		

		controlador =  SampleControladores.instance(ambiente);
		controlador2 =  SampleControladores.instance(ambiente);
		controlador3 =  SampleControladores.instance(ambiente);
		
		System.out.println(controlador);
		System.out.println(controlador.getEspecificacao());
		System.out.println(controlador2);
		System.out.println(controlador2.getEspecificacao());
		System.out.println(controlador3);
		System.out.println(controlador3.getEspecificacao());		
		
		
		///
		
		///
		
		///
		
		///
		
//		controlador.monitorar();
		
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
