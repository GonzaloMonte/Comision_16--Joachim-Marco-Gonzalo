package ragnarok.graficos;

import ragnarok.entidades.Entidad;
import ragnarok.principal.Juego;

public class Posicion {
	private float x;
	private float y;
	
	public Posicion() {
		x=0;
		y=0;
	}
	 public Posicion(float x, float y) {
		 this.x=x;
		 this.y=y;
	 }
	
	public void setPos(float x, float y) {
		this.x=x;
		this.y=y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	//Limites de los bordes del juego
	
	public boolean limiteUp(Entidad e) {
		float y = e.getPos().getY();
		
		return Juego.ALTO-e.getGrafico().getAlto()-Juego.caminable <= y;
	}
	
	public boolean limiteDown(Entidad e) {
		float y = e.getPos().getY();
		
		return 0 >= y;
	}
	
	public boolean limiteRight(Entidad e) {
		float x = e.getPos().getX();
		
		return Juego.ANCHO-e.getGrafico().getAncho() <= x;
	}
	
	public boolean limiteLeft(Entidad e) {
		float x = e.getPos().getX();
		
		return 0 >= x;
	}
}
