package ragnarok.colisiones;

import ragnarok.disparos.Flecha;

public class ColisionadorPowerUp extends Colisionador{

	public void afectarDisparoJugador(Flecha f) {
		//Un disparo de jugador fue chocado por un power up
		f.eliminar();
	}
}
