package ragnarok.estados;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ragnarok.principal.Juego;
import ragnarok.principal.Mapa;

public class NivelEstado extends Estado{
	private int contador;
	private final int contadorMax = 100;
	
	private BitmapFont fuente;
	
	public NivelEstado(JuegoEstadosManager g) {
		super(g);
		
		fuente = new BitmapFont(Gdx.files.internal("res/fonts/norse.fnt"));
		
	}

	public void handleInput() {
		if (contador == contadorMax) {
			jem.set(new JugarEstado(jem));
			dispose();
		}
		
	}

	public void update(float dt) {
		handleInput();
		contador++;
	}

	public void render(SpriteBatch sb) {
		sb.begin();
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		fuente.draw(sb,Juego.idioma.getTextoNivelEstado()[0]+Mapa.getMapa().getNivel(), (Juego.ANCHO/2)-50,(Juego.ALTO/2));
		fuente.draw(sb,Juego.idioma.getTextoNivelEstado()[1]+Mapa.getMapa().getHeroe().getPuntaje(),600, 550);
		fuente.draw(sb,Juego.idioma.getTextoNivelEstado()[2]+Mapa.getMapa().getVidasExtra(), 50, 550);
		sb.end();
	}

	public void dispose() {
	}
}
