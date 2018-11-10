package ragnarok.obstaculos;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorBarrera;
import ragnarok.graficos.Grafico;
import ragnarok.inteligencia.movimientos.InteligenciaMamut;

public class Barrera extends Obstaculo {
	
	protected boolean quieto;
	
	public Barrera() {
		super();
		
		valor = 4;
		
		colisionador = new ColisionadorBarrera();
		
		inteligenciaMovimiento = new InteligenciaMamut(this);
		
		velocidad = 1;
		
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("mover","img/barreras/mamutCaminando.png",14,1f);
		grafico.cargarAnimaciones("morir","img/barreras/mamutMorir.png",7,1f);
		grafico.cargarAnimaciones("idle","img/barreras/mamutQuieto.png",1,10f);
		grafico.setAnimacion("mover");
		grafico.setDefault("idle");
		grafico.setHitbox("mamut");
	}
	
	public void serChocado(Colisionador col) {
		col.afectarBarrera(this);
	}
	
	public void actualizar() {
		mover();
	}
	
	protected void mover() {
		inteligenciaMovimiento.mover(this);
	}
	
}
