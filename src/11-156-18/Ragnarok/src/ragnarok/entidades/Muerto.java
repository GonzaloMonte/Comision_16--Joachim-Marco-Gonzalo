package ragnarok.entidades;

import ragnarok.colisiones.Colisionador;
import ragnarok.colisiones.ColisionadorNulo;
import ragnarok.graficos.Animacion;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.principal.Juego;

public class Muerto extends Entidad{
	
	protected boolean muerto;
	protected Animacion animacionMuerte;
	protected String rutaHitbox;
	protected Entidad ent;
	
	public Muerto(Entidad e,String ruta) {
		super();
		
		rutaHitbox = ruta;
		
		vida = 1;
		
		ent = e;
		
		animacionMuerte = e.getGrafico().getAnimacionMuerte();
		
		velocidad = 0;
		
		muerto = true;
		
		colisionador = new ColisionadorNulo();
	}

	public void iniciarGraficamente() {
		grafico = new Grafico();
		if (animacionMuerte!=null )
		grafico.cargarAnimaciones("morir",animacionMuerte);
		grafico.cargarAnimaciones("idle",ent.getRutaHitbox(),1,10f);
		grafico.setDefault("morir");
		grafico.setAnimacion("morir"); 
		grafico.setHitbox("none");
		
		Posicion posicionHeroe = new Posicion(20,(Juego.ALTO-Juego.caminable)/2);
		grafico.setPosicion(posicionHeroe.getX(), posicionHeroe.getY());
	}

	public void actualizar() {
		if (!grafico.getAnimacionActual().estaAnimando() && !muerto) {
			morir();
			grafico.setDefault("idle");
		}
	}

	public void serChocado(Colisionador col) {
		
	}
	
	public void morir() {
		muerto = true;
	}
	
	public String getRutaHitbox() {
		return "img/personajesExtra/none.png";
	}
}
