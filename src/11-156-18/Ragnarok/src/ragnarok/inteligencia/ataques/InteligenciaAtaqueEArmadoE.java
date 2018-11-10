package ragnarok.inteligencia.ataques;

import ragnarok.armas.Arma;
import ragnarok.disparos.FlechaE;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.principal.Mapa;

public class InteligenciaAtaqueEArmadoE extends Inteligencia{
	
	protected Arma arma;
	
	public InteligenciaAtaqueEArmadoE(Arma a) {
		super();
		arma = a;
	}
	
	public void atacar(Entidad e) {
		if (relojLocal>=100) {
			e.getGrafico().setAnimacion("atacar");
			Posicion pos = e.getPos();
			Posicion posDisp = new Posicion(pos.getX()-1,pos.getY()+(e.getGrafico().getAlto()/2));
			FlechaE flecha = new FlechaE(posDisp,arma.getDaño());
			flecha.setDisparo("ghostPoder", 3, 0.5f);
			Mapa.getMapa().agregarEntidad(flecha);
			relojLocal = 0;
		}
		relojLocal++;
	}
}
