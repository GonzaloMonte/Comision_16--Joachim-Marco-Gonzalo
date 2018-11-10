package ragnarok.powerups.objetospreciosos;

import ragnarok.armas.ArmaHeroe;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueHeroeTriple;
import ragnarok.powerups.ObjetoPrecioso;
import ragnarok.principal.Mapa;

public class DisparoTriple extends ObjetoPrecioso {

	public DisparoTriple(Posicion pos) {
		super(pos);
	}

	public void activar() {
		Mapa.getMapa().getHeroe().setInteligenciaAtaque(new InteligenciaAtaqueHeroeTriple(new ArmaHeroe()));
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("idle","img/powerup/FlechaTriple.png",2,0.5f);
		grafico.setAnimacion("idle");
		grafico.setDefault("idle");
		grafico.setHitbox("powerup");
	}
}