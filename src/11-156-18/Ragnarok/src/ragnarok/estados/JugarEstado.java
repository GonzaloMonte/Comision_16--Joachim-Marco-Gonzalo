package ragnarok.estados;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import ragnarok.entidades.Entidad;
import ragnarok.graficos.Animacion;
import ragnarok.powerups.Observer;
import ragnarok.principal.Juego;
import ragnarok.principal.Mapa;
import ragnarok.puntaje.Save;

public class JugarEstado extends Estado {
	
	private Mapa mapa;
	private Sprite corazones;
	
	private Animacion fondoAnimado;
	private Animacion[] animacionesFondo;
	
	
	protected JugarEstado(JuegoEstadosManager g) {
		super(g);
		
		mapa = Mapa.getMapa();
		
		iniciarHud();
		
		iniciarAnimaciones();
	}
	
	private void iniciarAnimaciones() {
		animacionesFondo = new Animacion[5];
		animacionesFondo[0] = new Animacion(new TextureRegion(new Texture("img/fondos/fondoJuegoA.png")),20,1f);
		animacionesFondo[1] = new Animacion(new TextureRegion(new Texture("img/fondos/fondoJuegoB.png")),20,1f);
		animacionesFondo[2] = new Animacion(new TextureRegion(new Texture("img/fondos/fondoJuegoC.png")),20,1f);
		animacionesFondo[3] = new Animacion(new TextureRegion(new Texture("img/fondos/fondoJuegoD.png")),20,1f);
		animacionesFondo[4] = new Animacion(new TextureRegion(new Texture("img/fondos/fondoJuegoE.png")),20,1f);
		
		fondoAnimado = animacionesFondo[0];
	}
	
	private void actualizarFondo() {
		fondoAnimado.update(Gdx.graphics.getDeltaTime());
		if (mapa.getNivel()==3 && fondoAnimado!=animacionesFondo[1]) {
			fondoAnimado = animacionesFondo[1];
		}
		else {
			if (mapa.getNivel()==5 && fondoAnimado!=animacionesFondo[2]) {
				fondoAnimado = animacionesFondo[2];
			}
			else {
				if (mapa.getNivel()==7 && fondoAnimado!=animacionesFondo[3]) {
					fondoAnimado = animacionesFondo[3];
				}
				else {
					if (mapa.getNivel()==9 && fondoAnimado!=animacionesFondo[4]) {
						fondoAnimado = animacionesFondo[4];
					}
				}
			}
		}
	}

	public void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.ESCAPE)) {
			jem.set(new MenuEstado(jem));
			mapa.reiniciarMapa();
			dispose();
		}
	}

	public void update(float dt) {
		handleInput();
		for (Entidad e: mapa.getEntidades()) {
			e.update(dt);
		}
	}

	public void render(SpriteBatch sb) {
		
		colisionar();
		
		actualizarEntidades();
		
		checkNivel();
		
		actualizarGrafico(sb);
		
		actualizarObserver();
	}
	
	private void actualizarGrafico(SpriteBatch sb) {
		dibujarBatch(sb);
		
		actualizarVida();
		
		actualizarFondo();
	}
	
	private void actualizarObserver() {
		for (int i=0;i<2;i++) {
			Observer obs=Mapa.getMapa().getObsList(i);
			if (obs!=null) {
			obs.actualizar();
			}
		}
	}
	
	private void checkNivel() {
		if (mapa.getHeroe().getVida() <= 0) {
			mapa.resetearNivel();
			cambiarEstado(new NivelEstado(jem));
		}
		else {
			if (mapa.cantEnemigos()<=0) {
				mapa.subirNivel();
				if (mapa.getNivel()==mapa.getUltimoNivel()) {
					Save.gd.setPuntajeTentativo(Mapa.getMapa().getHeroe().getPuntaje());
					cambiarEstado(new GanarEstado(jem));
				}
				else {
					cambiarEstado(new NivelEstado(jem));
				} 
			}
		}
		if (mapa.getHeroe().getVida() <= 0 && mapa.getVidasExtra() <= 0) {
			jem.set(new GameOverEstado(jem));
			dispose();
		}
	}
	
	private void colisionar() {
		for (Entidad x:mapa.getEntidades()) {
			for (Entidad y: mapa.getEntidades()) {
				if (x!=y && x.colisiona(y)) {
					x.colisionar(y);
				}
			}
		}
	}
	
	private void actualizarEntidades() {
		for (Entidad entidad:mapa.getEntidades()) {
			entidad.setPosHeroe(mapa.getHeroe().getPos());
			entidad.actualizar();
		}
		mapa.actualizarColeccion();
	}
	
	private void dibujarBatch(SpriteBatch batch) {
		batch.begin();
		batch.draw(fondoAnimado.getFrame(),0,0);
		for (Entidad entidad: mapa.getEntidades()) {
			batch.draw(entidad.getTexture(),entidad.getPos().getX(),entidad.getPos().getY());
		}
		batch.draw(corazones,corazones.getX(),corazones.getY());
		batch.end();
	}
	
	private void iniciarHud() {
		corazones = new Sprite(new Texture("img/hud/corazones/vida100.png"));
		corazones.setPosition(10, Juego.ALTO-corazones.getHeight()-10);
	}
	
	private void actualizarVida() {
		int vida = mapa.getHeroe().getVida()/10;
		vida*=10;
		if ( vida <= 0) vida = 0;
		String imagenVida = "img/hud/corazones/vida"+vida+".png";
		corazones.setTexture(new Texture(imagenVida));
	}
	
	public void dispose(){}
}
