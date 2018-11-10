package ragnarok.inteligencia.movimientos;

import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.principal.Juego;

public class InteligenciaDHeroe extends Inteligencia{
	
	public void mover(Entidad h) {
		Posicion pos = h.getPos();
		float x = pos.getX();
		x=x+h.getVelocidad();
		pos.setPos(x, pos.getY());
		if (pos.getX()>Juego.ANCHO) {
			h.eliminar();
		}
		h.setPosicion(pos.getX(), pos.getY());
	}
}
