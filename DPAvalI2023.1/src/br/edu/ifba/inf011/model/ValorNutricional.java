package br.edu.ifba.inf011.model;

public class ValorNutricional {
	
	private Double cho;
	private Double ptn;
	private Double lip;
	
	public ValorNutricional(Double cho, Double ptn, Double lip) {
		super();
		this.cho = cho;
		this.ptn = ptn;
		this.lip = lip;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer("VALOR NUTRICIONAL\n");
		str.append("\tCARBOIDRATO: " + this.cho + "\n");
		str.append("\tPROTEINA: " + this.ptn + "\n");
		str.append("\tGORDURA: " + this.lip + "\n");
		return str.toString();
	}
	
	

}
