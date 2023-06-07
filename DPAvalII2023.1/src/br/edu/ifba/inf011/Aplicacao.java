package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.MusicaNotas;
import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

public class Aplicacao{

	
	private void musica() throws IOException {

		ResourceLoader.DIR_NAME = "D:\\workspace\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
		
		Musica musica =  new MusicaNotas("GodSaveTheQueen");
		System.out.println(musica.execute());
		
		
	}
	
	
	private void teste() throws IOException {

		ResourceLoader.DIR_NAME = "D:\\workspace\\DPAvalII2023.1\\src\\br\\edu\\ifba\\inf011\\model\\resources\\data\\";
		Player player = new Player();
		int iCount = 0;

		//......
		
		while(player.temProximo() && iCount < 30) {
			System.out.println(player.proximo());
			iCount++;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		Aplicacao app = new Aplicacao();
		app.musica();
		app.teste();
	}






	

}
