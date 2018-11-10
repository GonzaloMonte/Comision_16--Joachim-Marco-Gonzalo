package ragnarok.estados;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ragnarok.principal.Juego;

public abstract class Estado {
	protected JuegoEstadosManager jem;
	protected int contador;
	protected final int contadorMax = 10;
	protected boolean lapso;
	
	protected Estado(JuegoEstadosManager g) {
		jem = g;
		contador = 0;
		lapso = false;
	}
	
	public abstract void handleInput();
	
	public abstract void update(float dt);
	
	public abstract void render(SpriteBatch sb);
	
	public abstract void dispose();
	
	private boolean estaDentro(Sprite s, int x, int y) {
		int xMax = (int) (s.getX()+s.getTexture().getWidth());
		int xMin = (int) s.getX();
		int yMax = (int) s.getY()+s.getTexture().getHeight();
		int yMin = (int) s.getY();
		return ((xMax>=x && xMin<=x) && (yMax>=y && yMin<=y));
	}
	
	private int espejoNum(int num) {
		int faltante;
		int espejo = Juego.ALTO/2;
		if (num<espejo) {
			faltante = espejo-num;
			num += faltante*2;
		}
		else {
			if (num>espejo) {
				faltante = num-espejo;
				num -= faltante*2;
			}
		}
		return num;
	}
	
	protected boolean clickea(Sprite s) {
		return estaDentro(s,Gdx.input.getX(),espejoNum(Gdx.input.getY())) && Gdx.input.isButtonPressed(Keys.LEFT);
	}
	
	protected void cambiarEstado(Estado e) {
		jem.set(e);
		dispose();
	}
	
}
