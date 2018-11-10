package ragnarok.entidades.enemigos;

import ragnarok.armas.ArmaKamikaze;
import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorKamikaze;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueKamikaze;

public abstract class Kamikaze extends Enemigo {
	
	protected final int vidaMax = 50;
	
	public Kamikaze() {
		super();
		
		valor = 3;
		
		arma = new ArmaKamikaze();
		
		vida = 50;
		
		inteligenciaAtaque = new InteligenciaAtaqueKamikaze(new ArmaKamikaze());
		
		colisionador = new ColisionadorKamikaze(arma.getDaño());
	}
	
	public void actualizar() {
		mover();
	}
	
	public void serChocado(Colisionador col) {
		col.afectarKamikaze(this);
	}
}
