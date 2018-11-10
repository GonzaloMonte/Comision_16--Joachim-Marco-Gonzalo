package ragnarok.colisiones;

import ragnarok.disparos.FlechaE;
import ragnarok.entidades.enemigos.EnemigoArmado;
import ragnarok.entidades.enemigos.Kamikaze;
import ragnarok.powerups.PowerUp;

public class ColisionadorJugador extends Colisionador {

	public void afectarEnemigoArmado(EnemigoArmado e) {
		//El enemigo fue chocado por un jugador.
		e.eliminar();
	}
	
	public void afectarKamikaze(Kamikaze k) {
		//Un kamikaze fue chocado por un jugador
		k.eliminar();
	}

	public void afectarDisparoEnemigo(FlechaE f) {
		//Un disparo enemigo fue chocado por un jugador
		f.eliminar();
	}
	
	public void afectarPowerUp(PowerUp p) {
		p.activar();
		p.eliminar();
	}
}