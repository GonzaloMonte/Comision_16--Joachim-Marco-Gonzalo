package ragnarok.estados;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ragnarok.graficos.Animacion;
import ragnarok.principal.Juego;

public class MenuEstado extends Estado{
	
	private Sprite botonPlay;
	private Sprite botonPuntaje;
	private Sprite banderaIdioma;
	
	private Animacion animacionFondo;
	
	
	public MenuEstado(JuegoEstadosManager g) {
		super(g);
		
		//Mapa.getMapa().reiniciarMapa();
		
		iniciarBandera();
		
		iniciarBotones();
		
		animacionFondo = new Animacion(new TextureRegion(new Texture("img/fondos/fondomenu.png")),24,1.8f);
	}
	
	private void iniciarBotones() {
		botonPlay = new Sprite(new Texture("img/botones/botonPlay.png"));
		botonPlay.setPosition(((Juego.ANCHO/2)/2)+Juego.ANCHO/2-50, Juego.ALTO-300);
		
		botonPuntaje = new Sprite(new Texture("img/botones/botonPuntaje.png"));
		botonPuntaje.setPosition(((Juego.ANCHO/2)/2)+Juego.ANCHO/2-50, Juego.ALTO-450);
	}

	public void handleInput() {
		if (clickea(botonPlay)) {
			jem.set(new NivelEstado(jem));
			dispose();
		}
		if (clickea(botonPuntaje)) {
			jem.set(new PuntajeEstado(jem));
			dispose();
		}
		if (clickea(banderaIdioma) && lapso) {
			switch (Juego.getIdioma()) {
				case "ESPAÑOL" : {
					Juego.cambiarIdioma("INGLES");
					banderaIdioma.setTexture(new Texture("img/banderas/Ingles.png"));
					break;
				}
				case "INGLES" : {
					Juego.cambiarIdioma("ALEMAN");
					banderaIdioma.setTexture(new Texture("img/banderas/Aleman.png"));
					break;
				}
				case "ALEMAN" : {
					Juego.cambiarIdioma("PORTUGUES");
					banderaIdioma.setTexture(new Texture("img/banderas/Portugues.png"));
					break;
				}
				case "PORTUGUES" : {
					Juego.cambiarIdioma("ESPAÑOL");
					banderaIdioma.setTexture(new Texture("img/banderas/Español.png"));
					break;
				}
			}
			lapso = false;
		}
	}

	public void update(float dt) {
		if (!lapso) {
			contador++;
			if (contador>=contadorMax) {
				lapso = true;
				contador = 0;
			}
		}
		handleInput();
		animacionFondo.update(dt);
	}
	
	public void iniciarBandera() {
		if (Juego.getIdioma()=="ESPAÑOL") {
			banderaIdioma = new Sprite(new Texture("img/banderas/Español.png"));
		}
		if (Juego.getIdioma()=="INGLES") {
			banderaIdioma = new Sprite(new Texture("img/banderas/Ingles.png"));
		}
		if (Juego.getIdioma()=="ALEMAN") {
			banderaIdioma = new Sprite(new Texture("img/banderas/Aleman.png"));
		}
		if (Juego.getIdioma()=="PORTUGUES") {
			banderaIdioma = new Sprite(new Texture("img/banderas/Portugues.png"));
		}
		banderaIdioma.setPosition(Juego.ANCHO-50,Juego.ALTO-50);
	}

	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(animacionFondo.getFrame(),0,0);
		sb.draw(botonPlay,botonPlay.getX(),botonPlay.getY());
		sb.draw(botonPuntaje,botonPuntaje.getX(),botonPuntaje.getY());
		sb.draw(banderaIdioma,banderaIdioma.getX(),banderaIdioma.getY());
		sb.end();
	}

	public void dispose() {
		animacionFondo.getFrame().getTexture().dispose();
		botonPlay.getTexture().dispose();
		botonPuntaje.getTexture().dispose();
	}
}
