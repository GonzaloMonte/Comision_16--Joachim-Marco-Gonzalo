package ragnarok.estados;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ragnarok.principal.Juego;
import ragnarok.principal.Mapa;

public class GameOverEstado extends Estado{
	
	private BitmapFont fuente;
	
	protected GameOverEstado(JuegoEstadosManager g) {
		super(g);
		
		fuente = new BitmapFont(Gdx.files.internal("res/fonts/norse.fnt"));
		fuente.setColor(0, 0, 0, 255);
	}

	public void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			jem.set(new MenuEstado(jem));
			Mapa.getMapa().reiniciarMapa();
			dispose();

			Gdx.graphics.getGL20().glClearColor(0,0,0,0);
		}
	}

	public void update(float dt) {
		handleInput();
	}

	public void render(SpriteBatch sb) {
		sb.begin();
		Gdx.graphics.getGL20().glClearColor(255, 255, 255, 255);
		fuente.getData().setScale(2f);
		fuente.draw(sb,Juego.idioma.getTextoGameOverEstado()[0],(Juego.ANCHO/2)-150,(Juego.ALTO/2)+100);
		fuente.getData().setScale(1f);
		fuente.draw(sb,Juego.idioma.getTextoGameOverEstado()[1]+Mapa.getMapa().getHeroe().getPuntaje(),(Juego.ANCHO/2)-75,(Juego.ALTO/2)-100);
		fuente.draw(sb,Juego.idioma.getTextoGameOverEstado()[2],(Juego.ANCHO/2)-225,(Juego.ALTO/2)-200);
		sb.end();
		
	}

	public void dispose() {}
	
}
