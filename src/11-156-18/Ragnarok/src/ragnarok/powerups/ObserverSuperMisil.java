package ragnarok.powerups;

import ragnarok.armas.ArmaHeroe;
import ragnarok.entidades.Heroe;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueDañoDoble;
import ragnarok.memento.Caretaker;
import ragnarok.principal.Mapa;

public class ObserverSuperMisil extends Observer {
	
	private Caretaker caretaker;

	public ObserverSuperMisil(Mapa juego) {
		suject=(Mapa) juego;
		contador=0;
		suject.agregarObservadores(this,1);
			
		caretaker = new Caretaker();
			
	}
		
	public void actualizar() {
		if (estado) {
			contador++;
			if (contador==300) {
				estado=false;
				desactivarPoder();
			}
		}	
	}
	
	public void actualizarPowerUp() {
		if(estado) {
			contador=0;
		}
		else {
			estado=true;
			activarPoder();
		}
	}
	
	public void activarPoder() {
		Heroe e = Mapa.getMapa().getHeroe();
		caretaker.addMemento(e.saveToMemento());
		e.setInteligenciaAtaque(new InteligenciaAtaqueDañoDoble(new ArmaHeroe()));
	}
	
	public void desactivarPoder(){
		Heroe e = Mapa.getMapa().getHeroe();
		e.restoreFromMemento(caretaker.getMemento(0));
	}
		
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean est) {
		estado = est;
	}
}