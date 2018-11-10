package ragnarok.powerups;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import ragnarok.entidades.Entidad;
import ragnarok.inteligencia.InteligenciaNula;
import ragnarok.memento.Caretaker;
import ragnarok.principal.Mapa;

public class ObserverCongelar extends Observer {
	
	private Map<Entidad,Caretaker> mapeo;
	
	public ObserverCongelar(Mapa juego) {
		suject = (Mapa) juego;
		contador = 0;
		suject.agregarObservadores(this,0);
		mapeo = new HashMap<Entidad,Caretaker>();
		
	}
	
	public void actualizar() {
		if (estado) {
			contador++;
		 if(contador==150) {
				estado=false;
				contador=0;
				restaurar();
			}
		}
		
	}
	
	public void actualizarPowerUp() {
		if (estado) {
			contador=0;
		}
		else{
			estado=true;
			congelar();
			contador=0;
		}
	}	
	
	public void congelar() {
		
		Collection<Entidad> coleccionAux = new LinkedList<Entidad>();
		coleccionAux = Mapa.getMapa().getEntidades();
		for (Entidad e: coleccionAux) {
			if(e!=Mapa.getMapa().getHeroe()) {
				Caretaker caretaker = new Caretaker();
				caretaker.addMemento(e.saveToMemento());
				mapeo.put(e,caretaker);
				e.setInteligenciaAtaque(new InteligenciaNula());
				e.setInteligenciaMovimiento(new InteligenciaNula());
			}
		}
	}
	
	public void restaurar() {
		Collection<Entidad> coleccionAux = new LinkedList<Entidad>();
		coleccionAux = Mapa.getMapa().getEntidades();
		for (Entidad e: coleccionAux) {
			if(e!=Mapa.getMapa().getHeroe()) {
				if(mapeo.get(e)!=null) {
				e.restoreFromMemento(mapeo.get(e).getMemento(0));
				}
			}
		}
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void setEstado(boolean est) {
		estado=est;
	}
}
