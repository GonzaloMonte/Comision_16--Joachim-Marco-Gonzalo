 package ragnarok.paquete;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ragnarok.principal.Juego;

public class Main {
	public static void main(String []args) {
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Ragnarok";
		cfg.width=800; //Ancho
		cfg.height=600; //Alto
		cfg.useGL30=false;
		cfg.resizable=false; //Para que no modifique el tamaño de la pantalla
		
		new LwjglApplication(new Juego(),cfg);
	}
}
