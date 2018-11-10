package ragnarok.powerups.magiastemporales;


import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.powerups.MagiaTemporal;
import ragnarok.principal.Mapa;


public class SuperMisil extends MagiaTemporal {
	
	public SuperMisil(Posicion pos) {
		super(pos);
		obs=Mapa.getMapa().getObsList(1);
	}
	
	public void activar() {
		obs.actualizarPowerUp();
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("idle","img/powerup/Fuego.png",2,0.5f);
		grafico.setAnimacion("idle");
		grafico.setDefault("idle");
		grafico.setHitbox("powerup");
	}
}