package ragnarok.entidades.enemigos;

import ragnarok.graficos.Grafico;
import ragnarok.inteligencia.movimientos.InteligenciaKBuscador;
import ragnarok.inteligencia.movimientos.InteligenciaKMareado;
import ragnarok.principal.Mapa;

public class KamikazeEspecial extends Kamikaze {
	
	private boolean estaMareado;
	
	public KamikazeEspecial() {
		super();
		
		inteligenciaMovimiento = new InteligenciaKBuscador();
		
		estaMareado=false;
	}
	
	public void mover() {
		if(!Mapa.getMapa().getObsList(0).getEstado()) {
			if (vida<=vidaMax*0.5 && !estaMareado) {
				inteligenciaMovimiento = new InteligenciaKMareado();
				estaMareado = true;
			}
		}
		inteligenciaMovimiento.mover(this);
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("atacar","img/nomuerto/noMuertoAtaque.png",20,1f);
		grafico.cargarAnimaciones("mover","img/nomuerto/noMuertoCaminar.png",17,1f);
		
		grafico.setDefault("mover");
		grafico.setAnimacion("mover");
		grafico.setHitbox("nomuerto");
	}
	
}