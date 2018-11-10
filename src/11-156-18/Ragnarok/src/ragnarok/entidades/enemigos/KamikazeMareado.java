package ragnarok.entidades.enemigos;

import ragnarok.graficos.Grafico;
import ragnarok.inteligencia.movimientos.InteligenciaKMareado;

public class KamikazeMareado extends Kamikaze {
	
	public KamikazeMareado() {
		super();
		
		valor = 3;
		
		vida = 75;

		inteligenciaMovimiento = new InteligenciaKMareado();
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("atacar","img/esqueleto/esqueletoAtaque.png",18,1f);
		grafico.cargarAnimaciones("mover","img/esqueleto/esqueletoCaminar.png",13,1f);
		
		grafico.setDefault("mover");
		grafico.setAnimacion("mover");
		grafico.setHitbox("esqueleto");
	}
	
}
