package ragnarok.colisiones;

import ragnarok.disparos.Flecha;
import ragnarok.disparos.FlechaE;
import ragnarok.entidades.Heroe;
import ragnarok.entidades.enemigos.EnemigoArmado;
import ragnarok.entidades.enemigos.Kamikaze;
import ragnarok.obstaculos.Barrera;
import ragnarok.obstaculos.Obstaculo;
import ragnarok.powerups.PowerUp;

public abstract class Colisionador {
	
	public void afectarHeroe(Heroe h) {}
	
	public void afectarEnemigoArmado(EnemigoArmado e) {}
	
	public void afectarKamikaze(Kamikaze k) {}
	
	public void afectarObstaculo(Obstaculo o) {}
	
	public void afectarBarrera(Barrera b) {}
	
	public void afectarPowerUp(PowerUp p) {}
	
	public void afectarDisparoJugador(Flecha f) {}
	
	public void afectarDisparoEnemigo(FlechaE f) {}
}
