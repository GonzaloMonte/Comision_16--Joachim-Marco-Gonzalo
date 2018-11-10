package ragnarok.memento;

import java.util.ArrayList;

public class Caretaker {
	private ArrayList<Memento> estados= new ArrayList<Memento>();
	
	public void addMemento(Memento m) {
		estados.add(m);
	}
	
	public Memento getMemento(int index) {
		return estados.get(index);
	}
}
