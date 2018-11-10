package ragnarok.memento;

import ragnarok.inteligencia.Inteligencia;

public class Memento {
	
	private Inteligencia[] inteligencia;
	
	public Memento (Inteligencia[] arregloInt) {
		inteligencia=new Inteligencia[2];
		inteligencia[0]=arregloInt[0];
		inteligencia[1]=arregloInt[1];
	}	
	
	public Inteligencia[] getSavedStateInteligencia2() {
		return inteligencia;
	}	
}