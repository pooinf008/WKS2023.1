package br.edu.ifba.inf011.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.composite.Tocavel;
import br.edu.ifba.inf011.observer.ChanceStrategyObserver;
import br.edu.ifba.inf011.strategy.PlayerMode;
import br.edu.ifba.inf011.strategy.PlayerStrategy;

public class Player {
	
	private List<Tocavel> tocaveis;
	private PlayerStrategy strategy;
	private PlayerMode mode;
	private Integer index;
	
	private List<ChanceStrategyObserver> novaMusicaObservers;
	
	public Player() {
		this.tocaveis = new ArrayList<Tocavel>();
		this.novaMusicaObservers = new ArrayList<ChanceStrategyObserver>();
		this.setMode(PlayerMode.PlayerAll);
		this.reset();
	}
	
	public void insert(Tocavel tocavel) {
		this.tocaveis.add(tocavel);
	}
	
	public boolean temProximo() {
		return this.strategy.temProximo(this.index, this.tocaveis);
	}
	
	public String proximo() {
		return this.strategy.proximo(this.index++, this.tocaveis);

	}
	
	public void reset() {
		this.index = 0;
		
	}
	
	public void setMode(PlayerMode mode) {
		if(this.mode != null && !this.mode.equals(mode))
			this.fireChangeMode(this.mode, mode);
		this.mode = mode;
		this.strategy = mode.getStrategy();
	}
	
	public void addNovaMusicaObserver(ChanceStrategyObserver observer) {
		this.novaMusicaObservers.add(observer);
	}

	public void removeNovaMusicaObserver(ChanceStrategyObserver observer) {
		this.novaMusicaObservers.remove(observer);
	}
	
	public void fireChangeMode(PlayerMode oldMode, PlayerMode newMode){
		for(ChanceStrategyObserver observer : this.novaMusicaObservers)
			observer.onChangeStrategy(oldMode, newMode);
	}
	

}
