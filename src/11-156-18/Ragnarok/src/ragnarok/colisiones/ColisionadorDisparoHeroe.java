package ragnarok.colisiones;

import ragnarok.disparos.FlechaE;
import ragnarok.entidades.enemigos.EnemigoArmado;
import ragnarok.entidades.enemigos.Kamikaze;
import ragnarok.obstaculos.Barrera;
import ragnarok.obstaculos.Obstaculo;
import ragnarok.powerups.PowerUp;

public class ColisionadorDisparoHeroe extends Colisionador {
	
	protected int daño;
	public ColisionadorDisparoHeroe(int d) {
		daño = d;
	}

	public void afectarEnemigoArmado(EnemigoArmado e) {
		//"Un enemigo fue chocado por el disparo del heroe
		e.dañar(daño);
		if (e.getVida() <= 0) {
			e.eliminar();
		}
	}

	public void afectarObstaculo(Obstaculo o) {
		//Un obstaculo fue chocado por el disparo del heroe
		o.dañar(daño);
		if (o.getVida() <= 0) {
			o.eliminar();
		}
	}
	
	public void afectarBarrera(Barrera b) {
		//Una barrera fue chocada por el disparo del heroe
		b.dañar(daño);
		if (b.getVida() <= 0) {
			b.eliminar();
		}
	}
	
	public void afectarKamikaze(Kamikaze k) {
		//Un kamikaze fue chocado por un disparo de heroe
		k.dañar(daño);
		if (k.getVida() <= 0) {
			k.eliminar();
		}
	}

	public void afectarDisparoEnemigo(FlechaE f) {
		//Un disparo enemigo fue chocado por un disparo de heroe
		f.eliminar();
	}

	public void afectarPowerUp(PowerUp p) {
		//Un power up fue chocado por un disparo enemigo
		p.activar();
		p.eliminar();
	}
}
