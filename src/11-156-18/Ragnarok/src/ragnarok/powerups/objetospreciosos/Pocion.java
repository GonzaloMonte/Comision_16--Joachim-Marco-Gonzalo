package ragnarok.powerups.objetospreciosos;

import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.powerups.ObjetoPrecioso;
import ragnarok.principal.Mapa;

public class Pocion extends ObjetoPrecioso {
	
	public Pocion(Posicion pos) {
		super(pos);
	}
	
	public void activar() {
		Mapa.getMapa().getHeroe().curar(20);
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("idle","img/powerup/Pocion.png",2,0.5f);
		grafico.setAnimacion("idle");
		grafico.setDefault("idle");
		grafico.setHitbox("powerup");
	}
}