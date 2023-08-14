package br.edu.ifba.inf011.strategy;

public enum PlayerMode {
	
	
	PlayerAll(new PlayerAllStrategy()), RepeatAll(new RepeatAllStrategy()), RandomMode(new RandomStrategy());
	
	PlayerStrategy strategyClass; 
	
	private PlayerMode (PlayerStrategy strategy) {
		this.strategyClass = strategy; 
	}
	
	public PlayerStrategy getStrategy() {
		return this.strategyClass;
	}


}
