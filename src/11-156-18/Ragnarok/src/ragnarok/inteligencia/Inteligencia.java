package ragnarok.inteligencia;

import ragnarok.entidades.Entidad;

public abstract class Inteligencia {
	protected boolean lapso;
	protected final int contadorMax = 30;
	protected int relojLocal;
	
	public Inteligencia() {
		relojLocal = 0;
		lapso = false;
	}
	
	public void mover(Entidad e) {}
	public void atacar(Entidad e) {}
}
