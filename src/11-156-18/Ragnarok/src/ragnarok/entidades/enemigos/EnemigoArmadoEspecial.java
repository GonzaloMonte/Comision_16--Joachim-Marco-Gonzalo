package ragnarok.entidades.enemigos;

import ragnarok.armas.ArmaKamikaze;
import ragnarok.colisiones.ColisionadorKamikaze;
import ragnarok.graficos.Grafico;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueEArmadoE;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueKamikaze;
import ragnarok.inteligencia.movimientos.InteligenciaEArmado;
import ragnarok.inteligencia.movimientos.InteligenciaKMareado;
import ragnarok.principal.Mapa;


public class EnemigoArmadoEspecial extends EnemigoArmado {
	
	private boolean mareado;
	private int vidaMax = 100;
	
	public EnemigoArmadoEspecial() {
		super();
		
		mareado = false;
		
		valor = 4;
		
		vida = 100;
	}
	
	public void iniciarInteligencias() {
		inteligenciaMovimiento = new InteligenciaEArmado();
		inteligenciaAtaque = new InteligenciaAtaqueEArmadoE(arma);
	}
	
	protected void mover() {
		if(!Mapa.getMapa().getObsList(0).getEstado()) {
			if (!mareado && vida<=vidaMax*0.30) {
				inteligenciaMovimiento = new InteligenciaKMareado();
				arma = new ArmaKamikaze();
				inteligenciaAtaque = new InteligenciaAtaqueKamikaze(arma);
				colisionador = new ColisionadorKamikaze(arma.getDaño());
				mareado = true;
			}
		}
		inteligenciaMovimiento.mover(this);
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("atacar","img/fantasma/ghostAtaque.png", 12, 1f);
		grafico.cargarAnimaciones("mover","img/fantasma/ghostMover.png", 6, 1f);
		grafico.cargarAnimaciones("morir","img/fantasma/ghostMuerte.png", 9, 1f);
		
		grafico.setDefault("mover");
		grafico.setAnimacion("mover");
		grafico.setHitbox("ghost");
	}
}
