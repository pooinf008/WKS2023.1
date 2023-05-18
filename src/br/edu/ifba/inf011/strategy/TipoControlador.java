package br.edu.ifba.inf011.strategy;

public enum TipoControlador{
	
	MEDIA{	
		@Override
		public CalculoTemperaturaStrategy getStrategy() {
			return new CalculoTemperaturaMedia();
		}
	},
	
	MAXIMA{	
		@Override
		public CalculoTemperaturaStrategy getStrategy() {
			return new CalculoTemperaturaMaxima();
		}
	};
	
	public abstract CalculoTemperaturaStrategy getStrategy();

	


}
