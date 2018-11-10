package ragnarok.colisiones;

import ragnarok.disparos.Flecha;
import ragnarok.disparos.FlechaE;
import ragnarok.entidades.enemigos.Kamikaze;

public class ColisionadorObstaculo extends Colisionador {

	public void afectarKamikaze(Kamikaze k) {
		//Un kamikaze fue chocado por obstaculo
		k.eliminar();
	}

	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por un obstaculo
		f.eliminar();
	}

	public void afectarDisparoEnemigo(FlechaE f) {
		//Un disparo enemigo fue chocado por un obstaculo
		f.eliminar();
	}
}