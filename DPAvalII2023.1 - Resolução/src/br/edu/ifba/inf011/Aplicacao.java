package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.composite.Tocavel;
import br.edu.ifba.inf011.decorator.MusicaLetra;
import br.edu.ifba.inf011.decorator.MusicaTitulo;
import br.edu.ifba.inf011.decorator.MusicaTituloOnly;
import br.edu.ifba.inf011.decorator.MusicaTraducaoPT;
import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.MusicaNotas;
import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.Playlist;
import br.edu.ifba.inf011.model.resources.ResourceLoader;
import br.edu.ifba.inf011.observer.ChanceStrategyObserver;
import br.edu.ifba.inf011.strategy.PlayerAllStrategy;
import br.edu.ifba.inf011.strategy.PlayerMode;
import br.edu.ifba.inf011.strategy.RepeatAllStrategy;
import br.edu.ifba.inf011.strategy.RandomStrategy;

public class Aplicacao implements ChanceStrategyObserver{

	
	private void musica() throws IOException {

		ResourceLoader.DIR_NAME = "D:\\workspace\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
		
		Musica musica =  new MusicaTraducaoPT(new MusicaLetra(new MusicaNotas("GodSaveTheQueen")));
		System.out.println(musica.execute());
		
		
	}
	
	
	private void teste() throws IOException {

		ResourceLoader.DIR_NAME = "D:\\workspace\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
		Player player = new Player();
		player.addNovaMusicaObserver(this);
		
		Playlist playlist = new Playlist("Internacionais");
		playlist.insert(new MusicaTituloOnly(new MusicaTraducaoPT(new MusicaLetra(new MusicaNotas("ReelAroundFountain")))));
		playlist.insert(new MusicaTituloOnly(new MusicaTraducaoPT(new MusicaLetra(new MusicaNotas("Lullaby")))));
		
		Playlist playlist2 = new Playlist("Internacionais - v2");
		playlist2.insert(new MusicaTitulo(new MusicaLetra(new MusicaNotas("GodSaveTheQueen"))));
		playlist2.insert(playlist);
		
		player.insert(new MusicaTitulo(new MusicaLetra(new MusicaNotas("AndreaDorea"))));
		player.insert(playlist2);
		player.setMode(PlayerMode.PlayerAll);

		int iCount = 0;
		while(player.temProximo() && iCount < 30) {
			System.out.println(player.proximo());
			iCount++;
		}
		
	}
	
	@Override
	public void onChangeStrategy(PlayerMode oldMode, PlayerMode newMode) {
		System.out.println(">>>Mudança de Modo de Operação<<<<");
		System.out.println("Modo Antigo: " + oldMode);
		System.out.println("Modo Novo: " + newMode);
	}

	
	public static void main(String[] args) throws IOException{
		(new Aplicacao()).teste();
	}






	

}
