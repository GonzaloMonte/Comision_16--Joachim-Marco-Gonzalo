package ragnarok.obstaculos;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorObstaculo;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Grafico;
import ragnarok.principal.Mapa;

public class Obstaculo extends Entidad {
	
	public Obstaculo() {
		
		super();
		
		colisionador = new ColisionadorObstaculo();
		
		vida = 125;
		
		valor = 5;
		
	}

	public void serChocado(Colisionador col) {
		col.afectarObstaculo(this);
		
	}
	
	public void eliminar() {
		super.eliminar();
		Mapa.getMapa().getHeroe().sumarPuntaje(getValor());
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("idle","img/hitbox/Barrera.png",1,10f);
		grafico.cargarAnimaciones("morir","img/barreras/hieloMuerte.png",17,1f);
		grafico.setAnimacion("idle");
		grafico.setDefault("idle");
		grafico.setHitbox("barrera");
	}

	public void actualizar() {}
	
}
