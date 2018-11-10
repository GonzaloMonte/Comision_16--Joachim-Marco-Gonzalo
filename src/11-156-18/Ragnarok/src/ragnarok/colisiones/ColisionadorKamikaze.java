package ragnarok.colisiones;

import ragnarok.disparos.Flecha;
import ragnarok.entidades.Heroe;
import ragnarok.obstaculos.Obstaculo;

public class ColisionadorKamikaze extends Colisionador{
	
	protected int daño;
	
	public ColisionadorKamikaze(int d) {
		daño = d;
	}
	
	public void afectarHeroe(Heroe h) {
		//El heroe fue chocado por un kamikaze
		if (h.getEscudo()) {
			h.desactivarEscudo();
		}
		else {
			h.dañar(daño);
			if (h.getVida() <= 0) {
				h.eliminar();
			}
		}
	}

	public void afectarObstaculo(Obstaculo o) {
		//El obstaculo fue chocado por un kamikaze
		o.dañar(daño);
		if (o.getVida() <= 0) {
			o.eliminar();
		}
	}
	
	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por un kamikaze
		f.eliminar();
	}
}