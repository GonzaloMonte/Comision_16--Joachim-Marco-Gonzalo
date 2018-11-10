package ragnarok.inteligencia.movimientos;

import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.principal.Juego;

public class InteligenciaDisparoIncremental extends Inteligencia{
	
	public void mover(Entidad h) {
		Posicion pos = h.getPos();
		float x = pos.getX();
		float y = pos.getY();
		x=x+h.getVelocidad();
		y=y+h.getVelocidad()/2;
		pos.setPos(x, y);
		if (pos.getX()>Juego.ANCHO || pos.getY()>Juego.ALTO) {
			h.eliminar();
		}
		h.setPosicion(pos.getX(), pos.getY());
	}
}
