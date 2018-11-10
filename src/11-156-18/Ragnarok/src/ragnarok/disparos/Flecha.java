package ragnarok.disparos;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorDisparoHeroe;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.movimientos.InteligenciaDHeroe;

public class Flecha extends Disparo{
	
	public Flecha (Posicion pos,int daño) {
		super();
		
		colisionador = new ColisionadorDisparoHeroe(daño);
		
		grafico.setPosicion(pos.getX()+grafico.getAncho(), pos.getY());
		
		velocidad = 5;
		
		inteligenciaMovimiento = new InteligenciaDHeroe();
		
	}
	
	public void serChocado(Colisionador col) {
		col.afectarDisparoJugador(this);
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
