package ragnarok.entidades.enemigos;

import ragnarok.graficos.Grafico;
import ragnarok.inteligencia.movimientos.InteligenciaKBuscador;

public class KamikazeBuscador extends Kamikaze{
	
	public KamikazeBuscador() {
		super();
		
		valor = 1;
		
		vida = 50;
		
		inteligenciaMovimiento = new InteligenciaKBuscador();
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("mover","img/perro/perroCorrer.png", 5, 0.5f);
		
		grafico.setDefault("mover");
		grafico.setAnimacion("mover");
		grafico.setHitbox("perro");
	}
}
