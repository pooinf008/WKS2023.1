package br.edu.ifba.inf011.observer;

import br.edu.ifba.inf011.strategy.PlayerMode;

public interface ChanceStrategyObserver {
	
	public void onChangeStrategy(PlayerMode oldMode, PlayerMode newMode);

}
