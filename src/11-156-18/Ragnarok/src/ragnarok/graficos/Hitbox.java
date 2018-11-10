package ragnarok.graficos;

public class Hitbox {
	
	private float xMax;
	private float xMin;
	private float yMax;
	private float yMin;
	
	public Hitbox(float xMa, float xMi, float yMa, float yMi) {
		xMax = xMa;
		xMin = xMi;
		yMax = yMa;
		yMin = yMi;
	}
	
	public boolean colisiona(Hitbox h) {
		boolean choca = false;
		choca = this.estaAdentro(h) || h.estaAdentro(this);
		return choca;
	}
	
	private boolean estaAdentro(Hitbox h) {
		boolean choca = false;
		Posicion vertice1 = new Posicion(h.getXMin(),h.getYMin());
		Posicion vertice2 = new Posicion(h.getXMax(),h.getYMin());
		Posicion vertice3 = new Posicion(h.getXMin(),h.getYMax());
		Posicion vertice4 = new Posicion(h.getXMax(),h.getYMax());
		if (puntoContenido(vertice1) || puntoContenido(vertice2) || puntoContenido(vertice3) || puntoContenido(vertice4)) {
			choca = true;
		}
		return choca;
	}
	
	private boolean puntoContenido(Posicion p) {
		boolean choca=false;
		float x = p.getX();
		float y = p.getY();
		if (((x <= xMax) && (x >= xMin)) && ((y <= yMax) && (y >= yMin))) {
			choca=true;
		}
		return choca;
	}
	public void actualizar(float x,float y,float alto, float ancho) {
		xMax = x+ancho;
		xMin = x;
		yMax = y+alto;
		yMin = y;
	}
	
	public float getXMax() {
		return xMax;
	}
	
	public float getXMin() {
		return xMin;
	}
	
	public float getYMax() {
		return yMax;
	}
	
	public float getYMin() {
		return yMin;
	}
}
