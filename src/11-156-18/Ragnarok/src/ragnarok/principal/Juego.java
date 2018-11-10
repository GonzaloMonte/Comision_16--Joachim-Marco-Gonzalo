package ragnarok.principal;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ragnarok.estados.JuegoEstadosManager;
import ragnarok.estados.MenuEstado;
import ragnarok.idioma.Aleman;
import ragnarok.idioma.Español;
import ragnarok.idioma.Idioma;
import ragnarok.idioma.Ingles;
import ragnarok.idioma.Portugues;
import ragnarok.puntaje.Save;

public class Juego implements ApplicationListener {
	
	public static int ANCHO = 800;
	public static int ALTO = 600;
	public static int caminable = 150;
	public static Idioma idioma;
	
	private JuegoEstadosManager jem;
	
	private SpriteBatch batch;
	
	public void create() {
		
		ANCHO = Gdx.graphics.getWidth();
		ALTO = Gdx.graphics.getHeight();
		
		Save.load();
		
		idioma = new Español();
		
		batch = new SpriteBatch();
		
		jem = new JuegoEstadosManager();
		
		jem.push(new MenuEstado(jem));
	}
	
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		jem.update(Gdx.graphics.getDeltaTime());
		
		jem.render(batch);
		
	}
	
	public static String getIdioma() {
		return idioma.getIdioma();
	}
	
	public static void cambiarIdioma(String idiomaN) {
		switch(idiomaN) {
			case "ESPAÑOL": {
				idioma = new Español();
				break;
			}
			case "INGLES": {
				idioma = new Ingles();
				break;
			}
			case "ALEMAN": {
				idioma = new Aleman();
				break;
			}
			case "PORTUGUES": {
				idioma = new Portugues();
				break;
			}
		}
	}
	
	
	public void resize(int ancho, int alto) {}
	//Pausa la app
	public void pause() {}
	//Resume la app
	public void resume() {}
	public void dispose() {}
}
