package ragnarok.inteligencia.movimientos;

import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;

public class InteligenciaMamut extends Inteligencia{
	
	protected boolean quieto;
	protected final int xFinal = 50;
	protected int xActual;
	
	public InteligenciaMamut(Entidad e) {
		quieto = false;
		xActual = 0;
	}
	
	public void mover(Entidad e) {
		if (!quieto) {
			if (!e.getGrafico().getAnimacionActual().estaAnimando()) {
				e.getGrafico().setAnimacion("mover");
			}
			Posicion pos = e.getPos();
			float x = pos.getX();
			float y = pos.getY();
			x=x-e.getVelocidad();
			e.setPosicion(x,y);
			if (xActual >= xFinal) {
				quieto = true;
				e.getGrafico().setAnimacion("idle");
			}
		}
		xActual++;
	}
}
