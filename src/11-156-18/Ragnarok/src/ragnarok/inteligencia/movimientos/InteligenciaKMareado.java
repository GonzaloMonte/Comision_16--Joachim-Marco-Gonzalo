package ragnarok.inteligencia.movimientos;

import java.util.Random;

import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.principal.Juego;

public class InteligenciaKMareado extends Inteligencia {
	private int movimiento;
	private int cont;
	private int cantPasos;
	private Random rnd = new Random();
	
	public InteligenciaKMareado() {
		movimiento = rnd.nextInt(3)-1;
		cont = 0;
		cantPasos = rnd.nextInt(151);
	}
	
	public void mover(Entidad e) {
		if (!e.getGrafico().getAnimacionActual().estaAnimando()) {
			e.getGrafico().setAnimacion("mover");
		}
		Posicion pos = e.getPos();
		float y = pos.getY();
		float x = pos.getX();
		if (movimiento == 1) {
			y=y+e.getVelocidad();
			cont++;
		}
		else {
			if (movimiento == -1) {
				y=y-e.getVelocidad();
				cont++;
			}
			else {
				cont++;
			}
		}
		
		x=x-e.getVelocidad();
		
		checkBordes(e,pos);
		
		if (x == (-e.getGrafico().getAncho())) {
			x = Juego.ANCHO;
		}
		
		if (cont == cantPasos) {
			cambiarPos();
		}
		pos.setPos(x, y);
		e.setPosicion(pos.getX(), pos.getY());
	}
	
	private void cambiarPos() {
		cont = 0;
		movimiento = rnd.nextInt(3)-1;
		cantPasos = rnd.nextInt(151);
	}
	
	private void checkBordes(Entidad e, Posicion pos) {
		if (pos.limiteUp(e)) {
			movimiento = -1;
		}
		
		if (pos.limiteDown(e)) {
			movimiento = 1;
		}
	}
}
