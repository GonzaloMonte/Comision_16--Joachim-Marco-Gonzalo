package ragnarok.inteligencia.ataques;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import ragnarok.armas.Arma;
import ragnarok.disparos.Flecha;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.principal.Mapa;

public class InteligenciaAtaqueHeroeDoble extends Inteligencia{
	
	protected Arma arma;
	
	public InteligenciaAtaqueHeroeDoble(Arma a) {
		super();
		arma = a;
	}
	
	public void atacar(Entidad e) {
		lapso = relojLocal>=contadorMax;
		if (Gdx.input.isKeyPressed(Keys.SPACE) && lapso) {
			e.getGrafico().setAnimacion("atacar");
			Posicion pos = e.getPos();
			
			Posicion posDisp = new Posicion(6+pos.getX()+e.getGrafico().getAncho(),pos.getY()+(e.getGrafico().getAlto()/2)+5);
			Posicion posDisp2 = new Posicion(pos.getX()+e.getGrafico().getAncho(),pos.getY()+(e.getGrafico().getAlto()/2)-5);
			
			Flecha flecha = new Flecha(posDisp,arma.getDaño());
			Flecha flecha2 = new Flecha(posDisp2,arma.getDaño());
			
			Mapa.getMapa().agregarEntidad(flecha);
			Mapa.getMapa().agregarEntidad(flecha2);
			relojLocal = 0;
		}
		if (relojLocal<=contadorMax) {
			relojLocal++;
		}
	}
}

