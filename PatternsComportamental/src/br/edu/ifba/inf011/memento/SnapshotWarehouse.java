package br.edu.ifba.inf011.memento;

import java.util.Map;
import java.util.HashMap;

import br.edu.ifba.inf011.model.Controlador;

public class SnapshotWarehouse {
	
	private Map<String, NarrowSnapshot> snapshots;
	private Controlador controlador;
	
	public SnapshotWarehouse(Controlador controlador) {
		this.controlador = controlador;
		this.snapshots = new HashMap<String, NarrowSnapshot>();
	}
	
	public void save(String id) {
		NarrowSnapshot memento = this.controlador.save(id);
		this.snapshots.put(id, memento);
	}
	
	public void undo(String id) {
		NarrowSnapshot snapshot =  this.snapshots.get(id);
		this.controlador.restore(snapshot);
		
	}	

}
