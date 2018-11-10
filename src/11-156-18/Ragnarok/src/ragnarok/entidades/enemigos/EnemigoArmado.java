package ragnarok.entidades.enemigos;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorEnemigoArmado;
import ragnarok.graficos.Grafico;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueEArmado;
import ragnarok.inteligencia.movimientos.InteligenciaEArmado;

public class EnemigoArmado extends Enemigo {
	
	public EnemigoArmado() {
		super();
		
		vida = 75;
		
		colisionador = new ColisionadorEnemigoArmado();
		
		iniciarInteligencias();
	}
	
	public void iniciarInteligencias() {
		inteligenciaMovimiento = new InteligenciaEArmado();
		inteligenciaAtaque = new InteligenciaAtaqueEArmado(arma);
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("atacar", "img/hechicero/hechiceroAtaque.png", 4, 1f);
		grafico.cargarAnimaciones("mover", "img/hechicero/hechiceroCaminar.png", 4, 0.7f);
		grafico.setDefault("mover");
		grafico.setAnimacion("mover");
		grafico.setHitbox("hechicero");
	}
	
	public void actualizar() {
		mover();
		atacar();
	}
	
	protected void atacar() {
		inteligenciaAtaque.atacar(this);
	}

	public void serChocado(Colisionador col) {
		col.afectarEnemigoArmado(this);	
	}
}
