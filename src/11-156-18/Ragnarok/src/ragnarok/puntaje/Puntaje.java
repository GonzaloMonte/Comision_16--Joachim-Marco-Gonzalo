package ragnarok.puntaje;

public class Puntaje {
	private int puntuacion;
	
	public Puntaje() {
		puntuacion = 0;
	}
	
	public Puntaje(int p) {
		puntuacion = p;
	}
	
	public int getPuntaje() {
		return puntuacion;
	}
	
	public void sumarPuntaje(int nuevo) {
		puntuacion+=nuevo;
	}
}
