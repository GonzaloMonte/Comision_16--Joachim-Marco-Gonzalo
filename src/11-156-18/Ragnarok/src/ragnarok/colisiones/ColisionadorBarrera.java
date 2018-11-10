package ragnarok.colisiones;

import ragnarok.disparos.Flecha;

public class ColisionadorBarrera extends Colisionador {

	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por barrera
		f.eliminar();
	}
}