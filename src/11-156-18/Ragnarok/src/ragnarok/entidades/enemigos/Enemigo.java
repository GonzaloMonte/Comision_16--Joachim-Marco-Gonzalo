package ragnarok.entidades.enemigos;

import java.util.Random;

import ragnarok.armas.Arma;
import ragnarok.armas.ArmaEnemigo;
import ragnarok.entidades.Entidad;
import ragnarok.powerups.PowerUp;
import ragnarok.powerups.magiastemporales.MTCongelarTiempo;
import ragnarok.powerups.magiastemporales.SuperMisil;
import ragnarok.powerups.objetospreciosos.ArmaDoble;
import ragnarok.powerups.objetospreciosos.DisparoTriple;
import ragnarok.powerups.objetospreciosos.EscudoKamikaze;
import ragnarok.powerups.objetospreciosos.Pocion;
import ragnarok.principal.Mapa;

public abstract class Enemigo extends Entidad{
	
	protected Arma arma;
	
	public Enemigo() {
		super();
		
		velocidad = 1;
		
		arma = new ArmaEnemigo();
	}
	
	public void actualizar() {
		mover();
	}
	
	protected void mover() {
		inteligenciaMovimiento.mover(this);
	}
	
	public void dropearPowerUp() {
		Random rnd = new Random();
		boolean drop = rnd.nextBoolean() && rnd.nextBoolean();
		if (drop) {
			int num = rnd.nextInt(6);
			if (num == 0) {
				PowerUp premio = new MTCongelarTiempo(grafico.getPosicion());
				Mapa.getMapa().agregarEntidad(premio);
			}
			if(num==1) {
				PowerUp premio = new Pocion(grafico.getPosicion());
				Mapa.getMapa().agregarEntidad(premio);
			}
			if(num==2) {
				PowerUp premio = new EscudoKamikaze(grafico.getPosicion());
				Mapa.getMapa().agregarEntidad(premio);
			}
			if(num==3) {
				PowerUp premio = new ArmaDoble(grafico.getPosicion());
				Mapa.getMapa().agregarEntidad(premio);
			}
			if(num==4) {
				PowerUp premio = new DisparoTriple(grafico.getPosicion());
				Mapa.getMapa().agregarEntidad(premio);
			}
			if(num==5) {
				PowerUp premio = new SuperMisil(grafico.getPosicion());
				Mapa.getMapa().agregarEntidad(premio);
			}
		}
	}
	
	public void eliminar() {
		super.eliminar();
		dropearPowerUp();
		Mapa.getMapa().getHeroe().sumarPuntaje(getValor());
		Mapa.getMapa().decrementarContEnemigo();
	}
	
}
