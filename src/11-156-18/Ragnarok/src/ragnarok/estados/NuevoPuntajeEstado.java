package ragnarok.estados;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ragnarok.principal.Juego;
import ragnarok.puntaje.Save;

public class NuevoPuntajeEstado extends Estado{
	
	private char[] nuevoNombre;
	private int charActual;
	private boolean esHighScore;
	private long puntaje;
	
	private BitmapFont fuente;
	private Sprite seleccion;

	public NuevoPuntajeEstado(JuegoEstadosManager g) {
		super(g);
		
		seleccion = new Sprite(new Texture(Gdx.files.internal("img/seleccion.png")));
		seleccion.setPosition((Juego.ANCHO/2), 128);
		fuente = new BitmapFont(Gdx.files.internal("res/fonts/norse.fnt"));
		puntaje = Save.gd.getPuntajeTentativo();
		esHighScore = Save.gd.esPuntajeMax(puntaje);
		nuevoNombre = new char[] { 'A', 'A', 'A'};
		charActual = 0;
	}

	public void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			if (esHighScore) {
				Save.gd.agregarPuntaje(puntaje, new String(nuevoNombre));
				Save.save();
			}
			jem.set(new MenuEstado(jem));
			dispose();
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.UP)) {
			if (nuevoNombre[charActual] == 'A') {
				nuevoNombre[charActual] = 'Z';
			}
			else {
				nuevoNombre[charActual]--;
				if (nuevoNombre[charActual] < 'A') {
					nuevoNombre[charActual] = 'Z';
				}
			}
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			if (nuevoNombre[charActual] == 'Z') {
				nuevoNombre[charActual] = 'A';
			}
			else {
				nuevoNombre[charActual]++;
				if (nuevoNombre[charActual] > 'Z') {
					nuevoNombre[charActual] = 'A';
				}
			}
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			if (charActual < nuevoNombre.length-1) {
				charActual++;
				seleccion.setPosition(seleccion.getX()+15, seleccion.getY());
			}
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			if (charActual > 0) {
				charActual--;
				seleccion.setPosition(seleccion.getX()-15, seleccion.getY());
			}
		}
	}

	public void update(float dt) {
		handleInput();
	}

	public void render(SpriteBatch sb) {
		sb.begin();
		fuente.draw(sb,Juego.idioma.getTextoNuevoPuntajeEstado()[0],(Juego.ANCHO/2)-100,500);
		fuente.draw(sb,Juego.idioma.getTextoNuevoPuntajeEstado()[1]+puntaje,(Juego.ANCHO/2)-50,450);
		fuente.draw(sb,Juego.idioma.getTextoNuevoPuntajeEstado()[2],(Juego.ANCHO/2)-150,250);
		for (int i = 0;i < nuevoNombre.length;i++) {
			fuente.draw(sb,Character.toString(nuevoNombre[i]), (Juego.ANCHO/2)+i*15, 150);
		}
		sb.draw(seleccion,seleccion.getX(),seleccion.getY());
		sb.end();
		
	}
	
	public void dispose() {
		
	}
}