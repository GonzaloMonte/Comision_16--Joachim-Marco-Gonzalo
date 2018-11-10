package ragnarok.powerups;

import ragnarok.principal.Mapa;

public abstract class Observer {
	protected Mapa suject;
	protected boolean estado;
	protected int contador;
	
	public abstract void actualizarPowerUp();
	
	public abstract void actualizar();
	
	public abstract boolean getEstado();
	
	public abstract void setEstado(boolean est);
}
