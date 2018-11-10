package ragnarok.colisiones;

import ragnarok.disparos.Flecha;

public class ColisionadorEnemigoArmado extends Colisionador {

	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por un enemigo armado
		f.eliminar();
	}

}
