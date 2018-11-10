package ragnarok.puntaje;

import java.io.Serializable;

public class GameData implements Serializable{
	
	private static final long serialVersionUID = 1;
	
	private final int cantPuntajes = 10;
	private long[] puntajes;
	private String[] nombres;
	
	private long puntajeTentativo;
	
	public GameData() {
		puntajes = new long[cantPuntajes];
		nombres = new String[cantPuntajes];
	}
	
	public void init() {
		for (int i = 0;i < cantPuntajes; i++)  {
			puntajes[i] = 0;
			nombres[i] = "- - -";
		}
	}
	
	public long[] getPuntajes() {
		return puntajes;
	}
	
	public String[] getNombres() {
		return nombres;
	}
	
	public long getPuntajeTentativo() {
		return puntajeTentativo;
	}
	
	public void setPuntajeTentativo(int i) {
		puntajeTentativo = i;
	}
	
	public boolean esPuntajeMax(long puntaje) {
		return puntaje > puntajes[cantPuntajes - 1];
	}
	
	public void agregarPuntaje( long nuevoPuntaje, String nombre) {
		if (esPuntajeMax(nuevoPuntaje)) {
			puntajes[cantPuntajes - 1] = nuevoPuntaje;
			nombres[cantPuntajes - 1] = nombre;
			sortPuntajes();
		}
	}
	
	private void sortPuntajes() {
		for (int i = 0; i < cantPuntajes; i++) {
			long puntaje = puntajes[i];
			String nombre = nombres[i];
			int j;
			for (j = i - 1; j >= 0 && puntajes[j] < puntaje; j--) {
				puntajes[j + 1] = puntajes[j];
				nombres[j + 1] = nombres[j];
			}
			puntajes[j + 1]  = puntaje;
			nombres[j + 1] = nombre;
		}
	}
	
	
 }
