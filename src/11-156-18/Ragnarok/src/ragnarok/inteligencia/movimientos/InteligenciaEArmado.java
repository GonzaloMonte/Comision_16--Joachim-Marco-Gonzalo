package ragnarok.inteligencia.movimientos;

import java.util.Random;

import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;

public class InteligenciaEArmado extends Inteligencia {
	private final int cantPasos = 150;
	private int cont;
	private boolean subir;
	
	public InteligenciaEArmado() {
		cont = 0;
		Random rnd = new Random();
		subir = rnd.nextBoolean();
	}
	
	public void mover(Entidad e) {
		Posicion pos = e.getPos();
		float y = pos.getY();
		float x = pos.getX();
		if (!e.getGrafico().getAnimacionActual().estaAnimando()) {
			e.getGrafico().setAnimacion("mover");
		}
		
		if (subir) {
			if (pos.limiteUp(e)) {
				subir = !subir;
			}
			else {
				y=y+e.getVelocidad();
			}
		}
		else {
			if (pos.limiteDown(e)) {
				subir = !subir;
			}
			else {
				y=y-e.getVelocidad();
			}
		}
		
		cont++;
		
		if (cont == cantPasos) {
			cont=0;
			subir = !subir;
		}
		
		pos.setPos(x, y);
		e.setPosicion(pos.getX(), pos.getY());;
	}
	
}
