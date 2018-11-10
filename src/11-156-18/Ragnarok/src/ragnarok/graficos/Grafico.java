package ragnarok.graficos;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Grafico {
	
	private float alto;
	private float ancho;
	private Sprite sprite;
	private Hitbox hitbox;
	private Posicion posicion;
	private Map<String,Animacion> animaciones;
	private Animacion animacionActual;
	private Animacion animacionDefault;
	
	public Grafico() {
		
		posicion = new Posicion();
		
		sprite = new Sprite(new Texture("img/personajesExtra/none.png"));
		alto = sprite.getHeight();
		ancho = sprite.getWidth();
		
		sprite.setPosition(posicion.getX(), posicion.getY());
		
		float xMax = posicion.getX()+ancho;
		float xMin = posicion.getX();
		float yMax = posicion.getY()+alto;
		float yMin = posicion.getY();
		
		hitbox = new Hitbox(xMax,xMin,yMax,yMin);
		
		animaciones = new HashMap<String, Animacion>();
	}
	
	public void cargarAnimaciones(String accion,String ruta, int cantFrames, float ciclo) {
		if (animaciones.get(accion)!=null) {
			animaciones.remove(accion);
		}
		Animacion animacion = new Animacion(new TextureRegion(new Texture(ruta)),cantFrames,ciclo);
		animaciones.put(accion, animacion);
		setAnimacion("idle");
		setDefault("idle");
	}
	
	public void cargarAnimaciones(String accion, Animacion animacion) {
		if (animaciones.get(accion)!=null) {
			animaciones.remove(accion);
		}
		animaciones.put(accion, animacion);
		setAnimacion("idle");
		setDefault("idle");
	}
	
	public float getAlto() {
		return alto;
	}
	
	public float getAncho() {
		return ancho;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public Animacion getAnimacionMuerte() {
		return animaciones.get("morir");
	}
	
	public boolean colisiona(Grafico g) {
		actualizarHitbox();
		g.actualizarHitbox();
		return hitbox.colisiona(g.getHitbox());
	}
	
	private void actualizarHitbox() {
		hitbox.actualizar(posicion.getX(),posicion.getY(),alto,ancho);
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public void setPosicion(float x,float y) {
		posicion.setPos(x, y);
	}
	
	public Hitbox getHitbox() {
		return hitbox;
	}
	
	public Animacion getAnimacionActual() {
		return animacionActual;
	}
	
	public TextureRegion getTexture() { 
		return animacionActual.getFrame(); 
	}
	
	public void update(float dt) {
		animacionActual.update(dt);
		actualizarAnimacion();
		if (!animacionActual.estaAnimando()) {
			animacionActual = animacionDefault;
		}
	}
	
	public void setAnimacion(String accion) {
		if (animaciones.get(accion)!=null)
			animacionActual = animaciones.get(accion);
	}
	
	public void setDefault(String accion) {
		if (animaciones.get(accion)!=null)
			animacionDefault = animaciones.get(accion);
	}
	
	public void setHitbox(String ruta) {
		sprite = new Sprite(new Texture("img/hitbox/"+ruta+".png"));
	}
	
	private void actualizarAnimacion() {
		alto = sprite.getTexture().getHeight();
		ancho = sprite.getTexture().getWidth();
	}
}
