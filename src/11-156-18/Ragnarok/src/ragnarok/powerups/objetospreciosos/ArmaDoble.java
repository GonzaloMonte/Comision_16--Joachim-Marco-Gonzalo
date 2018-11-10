package ragnarok.powerups.objetospreciosos;

import ragnarok.armas.ArmaHeroe;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueHeroeDoble;
import ragnarok.powerups.ObjetoPrecioso;
import ragnarok.principal.Mapa;

public class ArmaDoble extends ObjetoPrecioso {

	public ArmaDoble(Posicion pos) {
		super(pos);
	}

	public void activar() {
		Mapa.getMapa().getHeroe().setInteligenciaAtaque(new InteligenciaAtaqueHeroeDoble(new ArmaHeroe()));
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("idle","img/powerup/FlechaDoble.png",2,0.5f);
		grafico.setAnimacion("idle");
		grafico.setDefault("idle");
		grafico.setHitbox("powerup");
	}
}
