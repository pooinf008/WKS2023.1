package br.edu.ifba.inf011;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import br.edu.ifba.inf011.observer.BateriaBaixaListener;
import br.edu.ifba.inf011.observer.NovoCicloListener;

public class LogFile implements NovoCicloListener, BateriaBaixaListener{


  public String fileName;
  
  public LogFile(String fileName) {
	  this.fileName = fileName;
  }
  
@Override
	public void onNovoCiclo(Integer ciclo, Double temperatura, Double bateria) {
		  String str = "LogFile:\\> " + ciclo + " - " +
						temperatura + " - " + bateria + "\n";
		  Path p = Paths.get(this.fileName);
		  try {
			Files.write(p, str.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onBateriaBaixa(Integer ciclo, Double bateria) {
		  String str = "BATERIA BAIXA!!!! \\> " + ciclo + " - " +
				  	   " - " + bateria + "\n";
	  Path p = Paths.get(this.fileName);
	  try {
		Files.write(p, str.getBytes(), StandardOpenOption.APPEND);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	}
}
