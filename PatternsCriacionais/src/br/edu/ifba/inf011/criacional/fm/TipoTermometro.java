package br.edu.ifba.inf011.criacional.fm;

public enum TipoTermometro {
	
	BASICO{
		@Override
		TermometroConcreteCreator getConcreteCreator() {
			return new TermometroBasicoConcreteCreator();
		}

		@Override
		String getConcreteCreatorClassName() {
			return "br.edu.ifba.inf011.criacional.fm.TermometroBasicoConcreteCreator";
		}
		
	},
	
	ALTA{
		@Override
		TermometroConcreteCreator getConcreteCreator() {
			return new TermometroAltaConcreteCreator();
		}

		@Override
		String getConcreteCreatorClassName() {
			return "br.edu.ifba.inf011.criacional.fm.TermometroAltaConcreteCreator";
		}
		
	};

	abstract TermometroConcreteCreator getConcreteCreator(); 
	
	abstract String getConcreteCreatorClassName();
	
	

}
