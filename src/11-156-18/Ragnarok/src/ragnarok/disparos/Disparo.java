package ragnarok.disparos;

import ragnarok.entidades.Entidad;

public abstract class Disparo extends Entidad{
	
	public void actualizar() {
		mover();
	}
	
	private void mover() {
		inteligenciaMovimiento.mover(this);
	}
	
	public void setDisparo(String disparo, int cantFrames, float ciclo) {
		grafico.cargarAnimaciones("mover", "img/flechas/"+disparo+".png", cantFrames, ciclo);
		grafico.setAnimacion("mover");
		grafico.setDefault("mover");
	}
}
