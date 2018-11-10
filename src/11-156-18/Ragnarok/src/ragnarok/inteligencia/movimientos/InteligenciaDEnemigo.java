package ragnarok.inteligencia.movimientos;

import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;

public class InteligenciaDEnemigo extends Inteligencia {
	
	public void mover(Entidad h) {
		Posicion pos = h.getPos();
		float x = pos.getX();
		x=x-h.getVelocidad();
		pos.setPos(x, pos.getY());
		if (pos.getX()<0) {
			h.eliminar();
		}
		h.setPosicion(pos.getX(), pos.getY());
	}
}
