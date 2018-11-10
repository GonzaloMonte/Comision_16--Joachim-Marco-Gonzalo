package ragnarok.powerups.magiastemporales;

import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.powerups.MagiaTemporal;
import ragnarok.principal.Mapa;

public class MTCongelarTiempo extends MagiaTemporal{
	
	
	public MTCongelarTiempo(Posicion pos) {
		super(pos);
		
		obs = Mapa.getMapa().getObsList(0);
	}
	

	public void activar() {
		obs.actualizarPowerUp();
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("idle","img/powerup/Reloj.png",2,0.5f);
		grafico.setAnimacion("idle");
		grafico.setDefault("idle");
		grafico.setHitbox("powerup");
	}
	
}
