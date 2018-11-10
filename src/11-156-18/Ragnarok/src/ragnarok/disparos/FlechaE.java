package ragnarok.disparos;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorDisparoEnemigo;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.movimientos.InteligenciaDEnemigo;

public class FlechaE extends Disparo{
	
	public FlechaE (Posicion pos,int daño) {
		super();
		
		colisionador = new ColisionadorDisparoEnemigo(daño);
		
		grafico.setPosicion(pos.getX()-grafico.getAncho(), pos.getY());
		
		velocidad = 5;
		
		inteligenciaMovimiento = new InteligenciaDEnemigo();
	}

	public void serChocado(Colisionador col) {
		col.afectarDisparoEnemigo(this);
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("mover", "img/flechas/flecha.png", 4, 0.5f);
		grafico.setDefault("mover");
		grafico.setAnimacion("mover");
		grafico.setHitbox("flecha");
	}
	
	public String getRutaHitbox() {
		return "img/muertos/flecha.png";
	}
}
