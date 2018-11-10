package ragnarok.entidades;

import ragnarok.armas.ArmaHeroe;
import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorJugador;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.ataques.InteligenciaAtaqueHeroe;
import ragnarok.inteligencia.movimientos.InteligenciaHeroe;
import ragnarok.principal.Juego;
import ragnarok.puntaje.Puntaje;

public class Heroe extends Entidad{
	
	private final int vidaMax = 100;
	private Puntaje puntos;
	private boolean escudo;
	
	public Heroe() {
		super();
		
		escudo = false;
		
		puntos = new Puntaje();

		iniciarInteligencias();
		
		vida = 100;
		
		velocidad = 3;
		
		colisionador = new ColisionadorJugador();

		
	}
	
	public void iniciarGraficamente() {
		grafico = new Grafico();
		grafico.cargarAnimaciones("idle", "img/vikingo/vikingoQuieto.png", 10, 1f);
		grafico.cargarAnimaciones("atacar", "img/vikingo/vikingoAtaque.png", 13, 0.5f);
		grafico.cargarAnimaciones("mover", "img/vikingo/vikingoCaminar.png", 12, 0.5f);
		grafico.setDefault("idle");
		grafico.setAnimacion("idle");
		grafico.setHitbox("vikingo");
		
		Posicion posicionHeroe = new Posicion(20,(Juego.ALTO-Juego.caminable)/2);
		grafico.setPosicion(posicionHeroe.getX(), posicionHeroe.getY());
	}
	
	private void iniciarInteligencias() {
		inteligenciaAtaque = new InteligenciaAtaqueHeroe(new ArmaHeroe());
		inteligenciaMovimiento= new InteligenciaHeroe();
	}
	
	public void actualizar() {
		mover();
		atacar();
	}
	
	private void mover() {
		inteligenciaMovimiento.mover(this);
	}
	
	private void atacar() {
		inteligenciaAtaque.atacar(this);
	}

	public void serChocado(Colisionador col) {
		col.afectarHeroe(this);
	}
	
	public void sumarPuntaje(int p) {
		puntos.sumarPuntaje(p);
	}
	
	public int getPuntaje() {
		return puntos.getPuntaje();
	}
	
	public void activarEscudo() {
		escudo = true;
		cambiarAnimacion();
	}
	
	public void desactivarEscudo() {
		escudo = false;
		cambiarAnimacion();
	}
	
	private void cambiarAnimacion() {
		String esc = "";
		if (escudo) {
			esc = "Esc";
		}
		grafico.cargarAnimaciones("idle", "img/vikingo/vikingoQuieto"+esc+".png", 10, 1f);
		grafico.cargarAnimaciones("atacar", "img/vikingo/vikingoAtaque"+esc+".png", 13, 0.5f);
		grafico.cargarAnimaciones("mover", "img/vikingo/vikingoCaminar"+esc+".png", 12, 0.5f);
	}
	
	public boolean getEscudo() {
		return escudo;
	}
	
	public void curar(int vidaextra) {
		vida+=vidaextra;
		if (vida>vidaMax) {
			vida = vidaMax;
		}
	}
	
	public String getRutaHitbox() {
		return "img/hitbox/vikingo.png";
	}
}