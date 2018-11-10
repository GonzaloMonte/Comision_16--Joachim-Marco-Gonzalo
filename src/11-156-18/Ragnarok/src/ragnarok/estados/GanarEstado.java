package ragnarok.estados;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ragnarok.graficos.Animacion;
import ragnarok.principal.Juego;
import ragnarok.principal.Mapa;
import ragnarok.puntaje.Save;

public class GanarEstado extends Estado{
	
	private int contador; 
	private final int contadorMax = 250 ;
	
	private BitmapFont fuente;
	
	private Animacion guerreroParado;
	
	public GanarEstado(JuegoEstadosManager g) {
		super(g);
		contador = 0;

		fuente = new BitmapFont(Gdx.files.internal("res/fonts/norse50.fnt"));
		fuente.setColor(0, 0, 0, 255);;
		
		guerreroParado = new Animacion(new TextureRegion(new Texture("img/personajesextra/guerreroParado.png")),8,1.2f);
	}

	public void handleInput() {}

	public void update(float dt) {
		handleInput();
		guerreroParado.update(dt);
		contador++;
		if (contador == contadorMax) {
			Gdx.graphics.getGL20().glClearColor(0,0,0,0);
			if (Save.gd.esPuntajeMax(Mapa.getMapa().getHeroe().getPuntaje())) {
				jem.set(new NuevoPuntajeEstado(jem));
				dispose();
			}
			else {
				jem.set(new MenuEstado(jem));
				Mapa.getMapa().reiniciarMapa();
				dispose();
			}
		}
	}

	public void render(SpriteBatch sb) {
		sb.begin();
		Gdx.graphics.getGL20().glClearColor(255, 255, 255, 255);
		fuente.draw(sb,Juego.idioma.getTextoGanarEstado()[0], (Juego.ANCHO/2)-200, 100+Juego.ALTO/2);
		sb.draw(guerreroParado.getFrame(),25,25);
		sb.end();
	}

	public void dispose() {}

}
