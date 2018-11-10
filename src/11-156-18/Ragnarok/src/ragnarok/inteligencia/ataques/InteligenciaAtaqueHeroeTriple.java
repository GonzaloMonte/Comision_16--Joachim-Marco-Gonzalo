package ragnarok.inteligencia.ataques;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import ragnarok.armas.Arma;
import ragnarok.disparos.Flecha;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.inteligencia.movimientos.InteligenciaDisparoDecremental;
import ragnarok.inteligencia.movimientos.InteligenciaDisparoIncremental;
import ragnarok.principal.Mapa;

public class InteligenciaAtaqueHeroeTriple extends Inteligencia{

	protected Arma arma;
	
	public InteligenciaAtaqueHeroeTriple(Arma a) {
		arma = a;
	}
	
	public void atacar(Entidad e) {
		lapso = relojLocal>=contadorMax;
		if (Gdx.input.isKeyPressed(Keys.SPACE) && lapso) {
			e.getGrafico().setAnimacion("atacar");
			Posicion pos = e.getPos();
			Posicion posDisp = new Posicion(pos.getX()+1+e.getGrafico().getAncho(),pos.getY()+(e.getGrafico().getAlto()/2));
			Posicion posDisp2 = new Posicion(pos.getX()+11+e.getGrafico().getAncho(),pos.getY()+(e.getGrafico().getAlto()/2));
			Posicion posDisp3 = new Posicion(pos.getX()+21+e.getGrafico().getAncho(),pos.getY()+(e.getGrafico().getAlto()/2));
			
			Flecha flecha = new Flecha(posDisp,arma.getDaño());
			Flecha flecha2 = new Flecha(posDisp2,arma.getDaño());
			Flecha flecha3 = new Flecha(posDisp3,arma.getDaño());
			
			flecha.setInteligenciaMovimiento(new InteligenciaDisparoIncremental());
			flecha3.setInteligenciaMovimiento(new InteligenciaDisparoDecremental());
			Mapa.getMapa().agregarEntidad(flecha);
			Mapa.getMapa().agregarEntidad(flecha2);
			Mapa.getMapa().agregarEntidad(flecha3);
			relojLocal = 0;
		}
		if (relojLocal<=contadorMax) {
			relojLocal++;
		}
	}
}

