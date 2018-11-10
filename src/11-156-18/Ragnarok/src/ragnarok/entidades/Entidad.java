package ragnarok.entidades;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ragnarok.colisiones.Colisionador;
import ragnarok.graficos.Grafico;
import ragnarok.graficos.Posicion;
import ragnarok.inteligencia.Inteligencia;
import ragnarok.inteligencia.InteligenciaNula;
import ragnarok.memento.Memento;
import ragnarok.principal.Mapa;

public abstract class Entidad {
	
	protected float velocidad;
	protected Posicion posHeroe;
	protected Grafico grafico;
	protected int vida;
	protected Colisionador colisionador;
	protected int valor;
	protected Inteligencia inteligenciaMovimiento;
	protected Inteligencia inteligenciaAtaque;
	
	public Entidad() {
		valor = 0;
		
		vida = 1;
		
		inteligenciaMovimiento = new InteligenciaNula();
		inteligenciaAtaque = new InteligenciaNula();
		
		iniciarGraficamente();
	}
	
	public abstract void iniciarGraficamente();
	
	public abstract void actualizar();
	
	public abstract void serChocado(Colisionador col);
	
	public int getValor() {
		return valor;
	}
	
	public Posicion getPosHeroe() {
		return posHeroe;
	}
	
	public void setPosHeroe(Posicion p) {
		posHeroe=p;
	}
	
	public Posicion getPos() {
		return grafico.getPosicion();
	}
	
	public void setPosicion(float x, float y ) {
		grafico.setPosicion(x, y);
	}
	
	public float getVelocidad() {
		return velocidad;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void dañar(int daño) {
		vida-=daño;
	}
	
	public void eliminar() {
		Mapa.getMapa().eliminarEntidad(this);
	}
	
	public Grafico getGrafico() {
		return grafico;
	}
	
	public boolean colisiona(Entidad e) {
		boolean choca = false;
		if (e.getGrafico().colisiona(this.getGrafico())) {
			choca = true;
		}
		return choca;
	}
	
	public void colisionar(Entidad e) {
		e.serChocado(colisionador);
	}
	
	public boolean estaAnimando() {
		return grafico.getAnimacionActual().estaAnimando();
	}
	
	public Memento saveToMemento() {
		Inteligencia[] arregloInt=new Inteligencia[2];
		arregloInt[0]=inteligenciaAtaque;
		arregloInt[1]=inteligenciaMovimiento;
		return new Memento(arregloInt);
	}

	public void restoreFromMemento(Memento m) {
		Inteligencia[] arregloInt=m.getSavedStateInteligencia2();
		inteligenciaAtaque=arregloInt[0];
		inteligenciaMovimiento=arregloInt[1];
		
	}
	
	public void setInteligenciaAtaque(Inteligencia intA) {
		inteligenciaAtaque = intA;
	}
	
	public void setInteligenciaMovimiento(Inteligencia intM) {
		inteligenciaMovimiento = intM;
	}
	
	public TextureRegion getTexture() { 
		return grafico.getTexture(); 
	}
	public void update(float dt) {
		grafico.update(dt);
	}
}
