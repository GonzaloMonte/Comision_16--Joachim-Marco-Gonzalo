package ragnarok.colisiones;

import ragnarok.disparos.Flecha;
import ragnarok.entidades.Heroe;
import ragnarok.obstaculos.Obstaculo;

public class ColisionadorKamikaze extends Colisionador{
	
	protected int da�o;
	
	public ColisionadorKamikaze(int d) {
		da�o = d;
	}
	
	public void afectarHeroe(Heroe h) {
		//El heroe fue chocado por un kamikaze
		if (h.getEscudo()) {
			h.desactivarEscudo();
		}
		else {
			h.da�ar(da�o);
			if (h.getVida() <= 0) {
				h.eliminar();
			}
		}
	}

	public void afectarObstaculo(Obstaculo o) {
		//El obstaculo fue chocado por un kamikaze
		o.da�ar(da�o);
		if (o.getVida() <= 0) {
			o.eliminar();
		}
	}
	
	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por un kamikaze
		f.eliminar();
	}
}