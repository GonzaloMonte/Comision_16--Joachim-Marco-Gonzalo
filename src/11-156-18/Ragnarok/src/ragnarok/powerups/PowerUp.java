package ragnarok.powerups;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorPowerUp;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;

public abstract class PowerUp extends Entidad {
	
	protected final int tiempoMax = 300;
	protected int contador;
	
	public PowerUp(Posicion pos) {
		Posicion posicion = new Posicion(pos.getX(),pos.getY());
		grafico.setPosicion(posicion.getX(), posicion.getY());
		
		colisionador = new ColisionadorPowerUp();
		contador = 0;
	}
	
	public void actualizar() {
		contador++;
		if (contador == tiempoMax) {
			this.eliminar();
		}
	}
	
	public abstract void activar();
	
	public void serChocado(Colisionador col) {
		col.afectarPowerUp(this);
	}
	
}
