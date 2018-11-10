package ragnarok.estados;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ragnarok.graficos.Animacion;
import ragnarok.principal.Juego;
import ragnarok.puntaje.Save;

public class PuntajeEstado extends Estado{
	
	private Sprite botonRegresar;
	
	private long[] puntajes;
	private String[] nombres;
	
	private BitmapFont fuente;
	private Animacion guerreroArrodillado;

	protected PuntajeEstado(JuegoEstadosManager g) {
		super(g);
		
		Save.load();
				
		puntajes = Save.gd.getPuntajes();
		nombres = Save.gd.getNombres();
		
		botonRegresar = new Sprite(new Texture("img/botones/botonReiniciar.png"));
		botonRegresar.setPosition(75, 75);
		
		fuente = new BitmapFont(Gdx.files.internal("res/fonts/norse.fnt"));
		
		guerreroArrodillado = new Animacion(new TextureRegion(new Texture("img/personajesextra/guerreroArrodillado.png")),10,1.2f);
		
	}
	
	public void handleInput() {
		if (clickea(botonRegresar)) {
			jem.set(new MenuEstado(jem));
			dispose();
		}
	}

	public void update(float dt) {
		handleInput();
		guerreroArrodillado.update(dt);
	}

	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(botonRegresar,botonRegresar.getX(),botonRegresar.getY());
		
		fuente.draw(sb,Juego.idioma.getTextoPuntajeEstado()[0],((Juego.ANCHO)/2)-50,550);
		int espacio = 0;
		for (int i = 0; i < puntajes.length; i++) {
			String s = String.format("%2d. %7s %s",i + 1, puntajes[i], nombres[i]);
			fuente.draw(sb,s,((Juego.ANCHO)/2)-75,500-espacio);
			espacio+=40;
		}

		sb.draw(guerreroArrodillado.getFrame(),Juego.ANCHO-10-guerreroArrodillado.getFrame().getRegionWidth(),10);
		sb.end();
	}

	public void dispose() {
		botonRegresar.getTexture().dispose();
	}
}
