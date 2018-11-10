package ragnarok.inteligencia.movimientos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;

public class InteligenciaHeroe extends Inteligencia {
	
	public void mover(Entidad h) {
		Posicion pos = h.getPos();
		float y = pos.getY();
		float x = pos.getX();
		if (Gdx.input.isKeyPressed(Keys.UP) && !pos.limiteUp(h)) {
			h.getGrafico().setAnimacion("mover");
			y=y+h.getVelocidad();
		}
		else {
			if (Gdx.input.isKeyPressed(Keys.DOWN) && !pos.limiteDown(h)) {
				h.getGrafico().setAnimacion("mover");
				y=y-h.getVelocidad();
			}
		}
		pos.setPos(x,y);
		h.setPosicion(pos.getX(), pos.getY());
	}
}