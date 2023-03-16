package br.ifba.inf011.model;

public enum Classe {
	
	JUNIOR {
		@Override
		public Classe proximo() {
			return PLENO;
		}
	} ,
	PLENO {
		@Override
		public Classe proximo() {
			return SENIOR;
		}
	},
	SENIOR {
		@Override
		public Classe proximo() {
			return MENTOR;
		}
	},
	MENTOR {
		@Override
		public Classe proximo() {
			return MENTOR;
		}
	};
	
	
	public abstract Classe proximo();
	


}
