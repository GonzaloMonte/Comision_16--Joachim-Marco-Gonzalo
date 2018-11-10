package ragnarok.powerups.objetospreciosos;

import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.powerups.ObjetoPrecioso;
import ragnarok.principal.Mapa;

public class EscudoKamikaze extends ObjetoPrecioso {
	
	public EscudoKamikaze(Posicion pos) {
		super(pos);
	}
	
	public void activar() {
		Mapa.getMapa().getHeroe().activarEscudo();
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("idle","img/powerup/Escudo.png",2,0.5f);
		grafico.setAnimacion("idle");
		grafico.setDefault("idle");
		grafico.setHitbox("powerup");
	}
}