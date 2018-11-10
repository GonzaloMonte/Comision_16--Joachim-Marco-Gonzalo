package ragnarok.inteligencia.movimientos;

import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.principal.Juego;

public class InteligenciaKBuscador extends Inteligencia {
	
	public void mover(Entidad kb) {
		if (!kb.getGrafico().getAnimacionActual().estaAnimando()) {
			kb.getGrafico().setAnimacion("mover");
		}
		Posicion pos = kb.getPos();
		float yH =kb.getPosHeroe().getY();
		float y = pos.getY();
		float x = pos.getX();
		float ancho = kb.getGrafico().getAncho();
		if (y < yH) {
			y=y+kb.getVelocidad();
		}
		else {
			if (y > yH) {
				y=y-kb.getVelocidad();
			}
		}
		x=x-kb.getVelocidad();
		if (x <= (-ancho)) {
			x = Juego.ANCHO;
		}
		pos.setPos(x, y);
		kb.setPosicion(pos.getX(), pos.getY());
	}
}
